package cipherassist.verification;

import java.math.BigInteger;
import java.util.Arrays;

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
	
	private Binary h0 = new Binary(b0.toString(2));
	private Binary h1 = new Binary(b1.toString(2));
	private Binary h2 = new Binary(b2.toString(2));
	private Binary h3 = new Binary(b3.toString(2));
	private Binary h4 = new Binary(b4.toString(2));
	private Binary h5 = new Binary(b5.toString(2));
	private Binary h6 = new Binary(b6.toString(2));
	private Binary h7 = new Binary(b7.toString(2));
	
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
	private int[] preK = new int[] { 0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
			   0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
			   0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
			   0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
			   0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
			   0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
			   0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
			   0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2 };
	
	private Binary[] K = new Binary[63];
	
	//N = number of blocks in the padded message
	private int N;
	
	//Message (M) length in bits
	private int l;
	
	//Number of 0's appended to a message during padding
	private int k;
	
	//Message
	private Binary M;
	
	public SHA256()
	{
		loadK();
	}
	
	private void setM(String message)
	{
		this.M = new Binary(message);
	}
	
	private void loadK()
	{
		for (int i = 0; i < 64; ++i)
		{
			K[i] = new Binary(preK[i]);
		}
	}
	
	public String hashString(String str)
	{
		setM(str);
		Binary messageDigest;
		
		
		setM(message);
		
		preProcess();
		
		messageDigest = computeHash();
		
		return messageDigest.toHexString();
	}
	
	private void preProcess()
	{
		generate_l();
		generate_k();
		
		padMessage();
		
	}
	
	private Binary computeHash()
	{
		
	}
	
	private void padMessage()
	{
		appendBytes();
		appendIntBlock();
	}
	
	private void appendBytes()
	{
		
	}
	
	private void appendIntBlock()
	{
		
	}
	
	private void generate_k()
	{
		int modResult = l % 512;
		k = (512 - modResult - 65);
		assert ((k + 65) % 512 == 0);
	}
	
	private void generate_l()
	{
		l = this.M.length();
	}
	
	
	//SHA256 Functions
	private BigInteger addMod2Raised32(BigInteger firstNum, BigInteger secondNum)
	{
		BigInteger result;
		BigInteger preMod = new BigInteger("2");
		BigInteger mod = preMod.pow(32);
		
		result = firstNum.add(secondNum);
		
		result = result.mod(mod);
		
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
