package cipherassist.verification;

import java.math.BigInteger;
import java.util.Arrays;

public class SHA256 
{
	//Variables that hold the hash values
	private int h0 = 0x6a09e667;
	private int h1 = 0xbb67ae85;
	private int h2 = 0x3c6ef372;
	private int h3 = 0xa54ff53a;
	private int h4 = 0x510e527f;
	private int h5 = 0x9b05688c;
	private int h6 = 0x1f83d9ab;
	private int h7 = 0x5be0cd19;
	
	//Working variables, 32-bit words used to compute hash values
	private int a;
	private int b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private int h;
	
	//Constants used for iterations of hash computation
	private static final int K[] = new int[] { 0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
			   0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
			   0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
			   0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
			   0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
			   0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
			   0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
			   0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2 };
	
	//N = number of blocks in the padded message
	private int N;
	
	//Message (M) length in bytes
	private int l;
	
	//Number of 0x0 appended to a message during padding
	private int k;
	
	//Message
	private byte[] M;
	
	public SHA256()
	{
		//
	}
	
	public String hashString(String str)
	{
		byte[] message;
		byte[] messageDigest;
		
		message = stringToByteArray(str);
		
		setM(message);
		
		preProcess();
		
		messageDigest = computeHash();
		
		return byteArrayToString(messageDigest);
	}
	
	private void preProcess()
	{
		generate_l();
		generate_k();
		
		padMessage();
		
	}
	
	private byte[] computeHash()
	{
		
	}
	
	private void padMessage()
	{
		appendBytes();
		appendIntBlock();
	}
	
	private String byteArrayToString(byte[] bytes)
	{
		String str = new String(bytes);
		return str;
	}
	
	private byte[] stringToByteArray(String str)
	{
		byte[] bytes = str.getBytes();
		return bytes;
	}
	
	private void setM(byte[] M)
	{
		this.M = M;
	}
	
	private void appendBytes()
	{
		//Preparation for appending bytes to message
		int lengthM = this.M.length;
		int newArraySize = lengthM + k + 9;
		byte[] newM = Arrays.copyOf(this.M, newArraySize);
		this.M = newM;
		
		byte one = (byte) 0x80;
		byte zeros = (byte) 0x0;
		
		//Appends message with 0x80
		this.M[lengthM + 1] = (byte) one;
		
		//Appends message with k bytes of 0x0
		for (int count = lengthM + 2; count < lengthM + k; ++count)
			this.M[count] = zeros;
	}
	
	private void appendIntBlock()
	{
		//Commented out while testing long bit shifting as better implementation
		/*
		int startIndex = 0;
		
		//Converts message's size in bits to an integer stored as a byte[]
		BigInteger lInt = BigInteger.valueOf(l * 8);
		byte[] intPortion = lInt.toByteArray();
		
		//Appending operation preparation
		byte[] intBlock = new byte[8];
		int intPortionLength = intPortion.length;
		startIndex = 8 - intPortionLength;
		int intPortionStartIndex = 0;
		
		//Places int byte(s) within new array
		for (int count = startIndex; count < intPortionLength - 1; ++count)
		{
			intBlock[count] = intPortion[intPortionStartIndex];
			++intPortionStartIndex;
		}
		
		//Fills remainder of array with 0x0 bytes if applicable
		for (int count = 0; count < startIndex; ++count)
		{
			intBlock[count] = (byte) 0x0;
		}
		
		*/
		
		int intBlockStartIndex = 0;
		
		long bitLength = l * 8;
		
		byte[] intBlock = new byte[] {
				(byte) bitLength,
				(byte) (bitLength >> 8),
				(byte) (bitLength >> 16),
				(byte) (bitLength >> 24),
				(byte) (bitLength >> 32),
				(byte) (bitLength >> 40),
				(byte) (bitLength >> 48),
				(byte) (bitLength >> 56)};
		
		
		//Appends 64 bit integer block to end of message
		for (int count = this.M.length - 8; count < this.M.length; ++count)
		{
			this.M[count] = intBlock[intBlockStartIndex];
			++intBlockStartIndex;
		}
	}
	
	private void generate_k()
	{
		int modResult = l % 64;
		k = (64 - modResult - 9);
		assert ((k + 9) % 64 == 0);
	}
	
	private void generate_l()
	{
		l = this.M.length;
		assert (l < 0xffffffff);
	}
	
}
