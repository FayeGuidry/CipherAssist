package cipherassist.verification;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;


import ConnorGuidry.BinaryUtil.Binary;

//This implementation of SHA256 is dependent on ConnorGuidry.BinaryUtil.Binary to function
//Implemented by hand for learning purposes.
public class SHA256 
{
	//Variables that hold the hash values
	private BigInteger b0 = new BigInteger("6a09e667", 16);
	private BigInteger b1 = new BigInteger("bb67ae85", 16);
	private BigInteger b2 = new BigInteger("3c6ef372", 16);
	private BigInteger b3 = new BigInteger("a54ff53a", 16);
	private BigInteger b4 = new BigInteger("510e527f", 16);
	private BigInteger b5 = new BigInteger("9b05688c", 16);
	private BigInteger b6 = new BigInteger("1f83d9ab", 16);
	private BigInteger b7 = new BigInteger("5be0cd19", 16);
	
	private Binary h0;
	private Binary h1;
	private Binary h2;
	private Binary h3;
	private Binary h4;
	private Binary h5;
	private Binary h6;
	private Binary h7;
	
	//Constants used for iterations of hash computation
	private String[] preK = new String[] { "428a2f98", "71374491", "b5c0fbcf", "e9b5dba5", "3956c25b", "59f111f1", "923f82a4", "ab1c5ed5",
			   "d807aa98", "12835b01", "243185be", "550c7dc3", "72be5d74", "80deb1fe", "9bdc06a7", "c19bf174",
			   "e49b69c1", "efbe4786", "0fc19dc6", "240ca1cc", "2de92c6f", "4a7484aa", "5cb0a9dc", "76f988da",
			   "983e5152", "a831c66d", "b00327c8", "bf597fc7", "c6e00bf3", "d5a79147", "06ca6351", "14292967",
			   "27b70a85", "2e1b2138", "4d2c6dfc", "53380d13", "650a7354", "766a0abb", "81c2c92e", "92722c85",
			   "a2bfe8a1", "a81a664b", "c24b8b70", "c76c51a3", "d192e819", "d6990624", "f40e3585", "106aa070",
			   "19a4c116", "1e376c08", "2748774c", "34b0bcb5", "391c0cb3", "4ed8aa4a", "5b9cca4f", "682e6ff3",
			   "748f82ee", "78a5636f", "84c87814", "8cc70208", "90befffa", "a4506ceb", "bef9a3f7", "c67178f2" };
	
	private Binary[] K = new Binary[64];
	
	//N = number of blocks in the padded message
	private int N;
	
	//Message (M) length in bits
	private int l;
	
	//Number of 0's appended to a message during padding
	private int k;
	
	//Message and message list
	private Binary M;
	ArrayList<Binary[]> messageArray;
	
	public SHA256(String message) throws UnsupportedEncodingException
	{
		loadK();
		loadH();
		
		setM(messageToBinary(message));
	}
	
	private String messageToBinary(String message) throws UnsupportedEncodingException
	{
		byte[] bytes = message.getBytes("UTF8");
		String convertedToBinary = new BigInteger(bytes).toString(2);
		
		if (convertedToBinary.length() % 8 != 0)
		{
			int mod = convertedToBinary.length() % 8;
			int zeros = 8 - mod;
			String append = "";
			
			for (int i = 0; i < zeros; ++i)
			{
				append += "0";
			}
			
			convertedToBinary = append + convertedToBinary;
		}
		
		//System.out.println(convertedToBinary);
		return convertedToBinary;
	}
	
	private void setM(String message)
	{
		this.M = new Binary(message);
	}
	
	private void loadH()
	{
		h0 = padVar(b0);
		h1 = padVar(b1);
		h2 = padVar(b2);
		h3 = padVar(b3);
		h4 = padVar(b4);
		h5 = padVar(b5);
		h6 = padVar(b6);
		h7 = padVar(b7);
	}
	
	private Binary padVar(BigInteger b)
	{
		Binary resultBinary;
		String appendedString = "";
		String resultString = "";
			
		resultString = b.toString(2);
			
		if (b.toString(2).length() != 32)
		{
			int zeros = 32 - b.toString(2).length();
			appendedString = "";
			
			for (int j = 0; j < zeros; ++j)
			{
				appendedString += '0';
			}	
			appendedString += b.toString(2);
			resultString = appendedString;
		}
		
		resultBinary = new Binary(resultString);
		return resultBinary;
	}
	
	private void loadK()
	{
		String appendedString = "";
		String resultString = "";
		
		for (int i = 0; i < 64; ++i)
		{
			BigInteger bigInt = new BigInteger(preK[i], 16);
			
			resultString = bigInt.toString(2);
			
			if (bigInt.toString(2).length() != 32)
			{
				int zeros = 32 - bigInt.toString(2).length();
				appendedString = "";
				
				for (int j = 0; j < zeros; ++j)
				{
					appendedString += '0';
				}
				
				appendedString += bigInt.toString(2);
				resultString = appendedString;
			}
			
			//System.out.println(resultString);
			K[i] = new Binary(resultString);
			//System.out.println(K[i].toHexString());
		}
	}
	
	public String getHash()
	{
		Binary messageDigest;
		
		preProcess();
		
		get_N();
		
		parseMessage();
		
		messageDigest = computeHash();
		
		//System.out.println(messageDigest);
		
		return messageDigest.toHexString();
	}
	
	private void get_N()
	{
		N = this.M.length() / 512;
		messageArray = new ArrayList<Binary[]>(N);
	}
	
	private void preProcess()
	{
		generate_l();
		generate_k();
		
		padMessage();
	}
	
	private Binary computeHash()
	{
		for (int i = 0; i < N; ++i)
		{
			ArrayList<Binary> messageSchedule = new ArrayList<Binary>(64);
			
			//Both loops below process the message schedule for each block iteration
			for (int j = 0; j < 16; ++j)
			{
				Binary[] messageBlock = messageArray.get(i);
				messageSchedule.add(j, messageBlock[j]);
				
				//System.out.println("MS16: " + messageBlock[j]);
			}
			
			for (int j = 16; j < 64; ++j)
			{
				Binary scheduleItem;
				Binary sigmaOne = new Binary((littleSigma1(messageSchedule.get(j-2))).toString());
				//System.out.println("init ls1: " + sigmaOne);
				Binary sigmaZero = new Binary((littleSigma0(messageSchedule.get(j-15))).toString());
				//System.out.println("init ls0: " + sigmaZero);
				
				scheduleItem = new Binary((addMod2Raised32(sigmaOne, messageSchedule.get(j-7))).toString());
				//System.out.println("SI1: " + scheduleItem);
				scheduleItem = new Binary((addMod2Raised32(scheduleItem, sigmaZero)).toString());
				//System.out.println("SI2: " + scheduleItem);
				scheduleItem = new Binary((addMod2Raised32(scheduleItem, messageSchedule.get(j-16))).toString());
				//System.out.println("SI3: " + scheduleItem);
				
				//System.out.println("MS64: " + scheduleItem);
				
				messageSchedule.add(scheduleItem);
			}
			
			//Working variables, 32-bit words used to compute hash values
			Binary a = new Binary (h0.toString());
			Binary b = new Binary (h1.toString());
			Binary c = new Binary (h2.toString());
			Binary d = new Binary (h3.toString());
			Binary e = new Binary (h4.toString());
			Binary f = new Binary (h5.toString());
			Binary g = new Binary (h6.toString());
			Binary h = new Binary (h7.toString());
			
			/*
			System.out.println("PREPRE");
			System.out.println("pa: " + a.toString());
			System.out.println("pb: " + b.toString());
			System.out.println("pc: " + c.toString());
			System.out.println("pd: " + d.toString());
			System.out.println("pe: " + e.toString());
			System.out.println("pf: " + f.toString());
			System.out.println("pg: " + g.toString());
			System.out.println("ph: " + h.toString());
			*/
			
			/*
			System.out.println(a);
			System.out.println(b);
			System.out.println(c);
			System.out.println(d);
			System.out.println(e);
			System.out.println(f);
			System.out.println(g);
			System.out.println(h);
			*/
			String test = a.toString();
			System.out.println(test);
			
			for (int t = 0; t < 64; ++t)
			{
				Binary T1 =  new Binary((addMod2Raised32(h, bigSigma1(e)).toString()));
				
				T1 = new Binary((addMod2Raised32(T1, ch(e, f, g))).toString());
				T1 = new Binary((addMod2Raised32(T1, K[t])).toString());
				T1 = new Binary((addMod2Raised32(T1, messageSchedule.get(t))).toString());
				
				Binary T2 = new Binary((addMod2Raised32(bigSigma0(a), maj(a, b, c))).toString());
				
				h = new Binary(g.toString());
				g = new Binary(f.toString());
				f = new Binary(e.toString());
				e = new Binary((addMod2Raised32(d, T1)).toString());
				d = new Binary(c.toString());
				c = new Binary(b.toString());
				b = new Binary(a.toString());
				a = new Binary((addMod2Raised32(T1, T2)).toString());
				/*
				System.out.println("POSTASSIGN");
				System.out.println("a: " + a.toString());
				System.out.println("b: " + b.toString());
				System.out.println("c: " + c.toString());
				System.out.println("d: " + d.toString());
				System.out.println("e: " + e.toString());
				System.out.println("f: " + f.toString());
				System.out.println("g: " + g.toString());
				System.out.println("h: " + h.toString());
				*/
				
			}
			
			System.out.println(h0.toHexString());
			//System.out.println(h0);
			System.out.println(h1.toHexString());
			//System.out.println(h1);
			System.out.println(h2.toHexString());
			//System.out.println(h2);
			System.out.println(h3.toHexString());
			//System.out.println(h3);
			System.out.println(h4.toHexString());
			//System.out.println(h4);
			System.out.println(h5.toHexString());
			//System.out.println(h5);
			System.out.println(h6.toHexString());
			//System.out.println(h6);
			System.out.println(h7.toHexString());
			//System.out.println(h7);
			
			
			
			
			h0 = new Binary((addMod2Raised32(a, h0)).toString());
			h1 = new Binary((addMod2Raised32(b, h1)).toString());
			h2 = new Binary((addMod2Raised32(c, h2)).toString());
			h3 = new Binary((addMod2Raised32(d, h3)).toString());
			h4 = new Binary((addMod2Raised32(e, h4)).toString());
			h5 = new Binary((addMod2Raised32(f, h5)).toString());
			h6 = new Binary((addMod2Raised32(g, h6)).toString());
			h7 = new Binary((addMod2Raised32(h, h7)).toString());
			
			//System.out.println("h1: " + h1.toString());
		}
		
		String messageString = h0.toString() + h1.toString() + h2.toString() 
							+ h3.toString() + h4.toString() + h5.toString()
								+ h6.toString() + h7.toString();
		
		return new Binary(messageString);
	}
	
	private Binary[] parseWords(String messageBlock)
	{
		Binary[] resultArray = new Binary[16];
		int bitIndex = 0;
		
		for (int i = 0; i < 16; ++i)
		{
			String parsedWord;
			
			if (i == 15)
				parsedWord = messageBlock.substring(479);
			else
				parsedWord = messageBlock.substring(bitIndex, bitIndex + 32);
			
			Binary parsedBinary = new Binary(parsedWord);
			resultArray[i] = parsedBinary;
			//System.out.print(resultArray[i]);
			//System.out.println(" " + i);
			bitIndex += 32;
		}
		
		//System.out.println(" 16 x 32bit array produced.");
		return resultArray;
	}
	
	private void parseMessage()
	{
		int blockIndex = 0;
		
		String workingMessageString = this.M.toString();
		
		for (int i = 0; i < N; ++i)
		{
			String messageBlockString = workingMessageString.substring(blockIndex, blockIndex + 511);
			blockIndex += 512;
			
			Binary[] parsedWords = parseWords(messageBlockString);
			messageArray.add(i, parsedWords);
			
			//System.out.println("16x32bit array added to list!");
		}
	
	}
	
	private void padMessage()
	{
		appendBits();
		appendIntBlock();
	}
	
	private void appendBits()
	{
		Binary onePadding = new Binary("1");

		String zeros = "";
		
		for (int i = 0; i < k; ++i)
		{
			zeros += '0';
		}
		
		Binary zeroPadding = new Binary(zeros);
		
		
		//System.out.println("One padding: " + onePadding);
		//System.out.println("Zero padding: " + zeroPadding);
		this.M.append(onePadding);
		this.M.append(zeroPadding);
		
	}
	
	private void appendIntBlock()
	{
		String messageLength = Integer.toString(l, 2);
		String padding = "";
		
		for (int i = 0; i < 64 - messageLength.length(); ++i)
		{
			padding += '0';
		}
		
		messageLength = padding + messageLength;
		
		Binary lengthBlock = new Binary(messageLength);
		
		this.M.append(lengthBlock);
		
		//System.out.println("Int block padding: " + lengthBlock);
		
		assert (this.M.length() % 512 == 0);
	}
	
	private void generate_k()
	{
		BigInteger modResult = new BigInteger(Integer.toString(l, 10), 10);
		BigInteger modVal = new BigInteger("512", 10);
		BigInteger padding = new BigInteger("65", 10);
		
		modResult = modResult.add(padding);
		modResult = modResult.mod(modVal);
		
		BigInteger bigk;
		bigk = modVal.subtract(modResult);
		
		k = bigk.intValue();
		
		//System.out.println("Message Length: " + l);
		//System.out.println("Zeros to be added: " + k);
	}
	
	private void generate_l()
	{
		l = this.M.length();
	}
	
	
	//SHA256 Functions
	private Binary addMod2Raised32(Binary firstBinary, Binary secondBinary)
	{
		Binary result = new Binary("");
		
		result = Binary.XOR(firstBinary, secondBinary);
		
		return result;
	}
	
	private Binary ch(Binary x, Binary y, Binary z)
	{
		Binary var1 = Binary.AND(x, y);
		Binary var2 = Binary.AND(Binary.complement(x), z);
		
		Binary result = Binary.XOR(var1, var2);
		
		return result;
	}
	
	private Binary maj(Binary x, Binary y, Binary z)
	{
		Binary var1 = Binary.AND(x, y);
		Binary var2 = Binary.AND(x, z);
		Binary var3 = Binary.AND(y, z);
		
		Binary result = Binary.XOR(var1, var2, var3);
		
		return result;
	}
	
	private Binary SHR(Binary x, int n)
	{
		Binary.rightShift(x, n);
		
		return x;
	}
	
	private Binary ROTR(Binary firstVar, int n)
	{
		Binary secondVar = new Binary(firstVar.toString());
		
		Binary.rightShift(firstVar, n);
		Binary.leftShift(secondVar, (32 - n));
		
		Binary first = new Binary(firstVar.toString());
		
		Binary result = Binary.OR(first, secondVar);
		
		return result;
	}
	
	private Binary bigSigma0(Binary x)
	{
		Binary result = new Binary("");
		
		Binary x1 = new Binary(x.toString());
		Binary x2 = new Binary(x.toString());
		Binary x3 = new Binary(x.toString());
		
		result = Binary.XOR(ROTR(x1, 2), ROTR(x2, 13), ROTR(x3, 22));
		
		return result;
	}
	
	private Binary bigSigma1(Binary x)
	{
		Binary result = new Binary("");
		
		Binary x1 = new Binary(x.toString());
		Binary x2 = new Binary(x.toString());
		Binary x3 = new Binary(x.toString());
		
		result = Binary.XOR(ROTR(x1, 6), ROTR(x2, 11), ROTR(x3, 25));
		
		return result;
	}
	
	private Binary littleSigma0(Binary x)
	{
		Binary result = new Binary("");
		
		Binary x1 = new Binary(x.toString());
		Binary x2 = new Binary(x.toString());
		Binary x3 = new Binary(x.toString());
		
		result = Binary.XOR(ROTR(x1, 7), ROTR(x2, 18), SHR(x3, 3));
		
		return result;
	}
	
	private Binary littleSigma1(Binary x)
	{
		Binary result = new Binary("");
		
		Binary x1 = new Binary(x.toString());
		Binary x2 = new Binary(x.toString());
		Binary x3 = new Binary(x.toString());
		
		result = Binary.XOR(ROTR(x1, 17), ROTR(x2, 19), SHR(x3, 10));
		
		return result;
	}
	
}
