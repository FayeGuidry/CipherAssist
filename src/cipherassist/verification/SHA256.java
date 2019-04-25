package cipherassist.verification;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;

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
	
	//Working variables, 32-bit words used to compute hash values
	private Binary a;
	private Binary b;
	private Binary c;
	private Binary d;
	private Binary e;
	private Binary f;
	private Binary g;
	private Binary h;
	
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
		
		System.out.println(convertedToBinary);
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
		
		/*
		System.out.println(h0.toHexString());
		System.out.println(h0);
		System.out.println(h1.toHexString());
		System.out.println(h1);
		System.out.println(h2.toHexString());
		System.out.println(h2);
		System.out.println(h3.toHexString());
		System.out.println(h3);
		System.out.println(h4.toHexString());
		System.out.println(h4);
		System.out.println(h5.toHexString());
		System.out.println(h5);
		System.out.println(h6.toHexString());
		System.out.println(h6);
		System.out.println(h7.toHexString());
		System.out.println(h7);
		*/
		
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
		
		messageDigest = computeHash();
		
		//System.out.println(this.M);
		return messageDigest.toHexString();
	}
	
	private void get_N()
	{
		N = this.M.length() / 512;
	}
	
	private void preProcess()
	{
		generate_l();
		generate_k();
		
		padMessage();
	}
	
	private Binary computeHash()
	{
		return new Binary("0");
	}
	
	private Binary[] parseWords(String messageBlock)
	{
		
	}
	
	private void parseMessage()
	{
		int blockIndex = 0;
		
		String workingMessageString = this.M.toString();
		
		for (int i = 0; i < N; ++i)
		{
			String messageBlockString = workingMessageString.substring(blockIndex, blockIndex + 512);
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
		
		assert (this.M.length() % 512 == 0);
	}
	
	private void generate_k()
	{
		int modResult = l % 512;
		k = (512 - modResult - 65);
		assert ((k + 65) % 512 == 0);
		
		//System.out.println(l);
		//System.out.println(k);
	}
	
	private void generate_l()
	{
		l = this.M.length();
	}
	
	
	//SHA256 Functions
	
	//CHECK THIS ONE FOR BITSTRING LENGTH SAFETY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//Add zero padding after operation if necessary.
	private Binary addMod2Raised32(Binary firstBinary, Binary secondBinary)
	{
		Binary result = new Binary("");
		
		BigInteger firstNum = new BigInteger(firstBinary.toString(), 2);
		BigInteger secondNum = new BigInteger(secondBinary.toString(), 2);
		
		BigInteger postAddNum = firstNum.add(secondNum);
		
		BigInteger preMod = new BigInteger("2", 10);
		BigInteger mod = preMod.pow(32);
		
		BigInteger resultNum = preMod;
		
		if ((postAddNum.compareTo(mod) == 1) || (postAddNum.compareTo(mod) == 0))
			resultNum = postAddNum.subtract(mod);
		
		result = padVar(resultNum);
		
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
		
		Binary result = Binary.OR(firstVar, secondVar);
		
		return result;
	}
	
	private Binary bigSigma0(Binary x)
	{
		Binary result;
		
		result = Binary.XOR(ROTR(x, 2), ROTR(x, 13), ROTR(x, 22));
		
		return result;
	}
	
	private Binary bigSigma1(Binary x)
	{
		Binary result;
		
		result = Binary.XOR(ROTR(x, 6), ROTR(x, 11), ROTR(x, 25));
		
		return result;
	}
	
	private Binary littleSigma0(Binary x)
	{
		Binary result;
		
		result = Binary.XOR(ROTR(x, 7), ROTR(x, 18), SHR(x, 3));
		
		return result;
	}
	
	private Binary littleSigma1(Binary x)
	{
		Binary result;
		
		result = Binary.XOR(ROTR(x, 17), ROTR(x, 19), SHR(x, 10));
		
		return result;
	}
	
}
