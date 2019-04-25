package cipherassist.verification;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class SHA256Demo {

	public static void main(String[] args) throws UnsupportedEncodingException 
	{
		
		SHA256 hash = new SHA256("This is a test of the binary encoding.");
		
		hash.getHash();
		
		/*
		BigInteger first = new BigInteger("ffffffff", 16);
		BigInteger second = new BigInteger("ffffffff", 16);
		
		BigInteger result = hash.addMod2Raised32(first, second);
		
		System.out.println(result.toString(16));
		
		BigInteger third = new BigInteger("77359400", 16);
		BigInteger fourth = new BigInteger("b2d05e00", 16);
		
		BigInteger result2 = hash.addMod2Raised32(third, fourth);
		
		System.out.println(result2.toString(16));
		*/
	
		//int num = 0xb5c0fbcf;
		//BigInteger big = new BigInteger("b5c0fbcf", 16);
		//BigInteger alsoBig = new BigInteger(Integer.toString(num, 16), 16);
		
		
		//System.out.println(big);
		//System.out.println(alsoBig);
		//System.out.println(num);
		
		
		
		//int l = 3;
		//int k;
		
		//int modResult = l % 512;
		//k = (512 - modResult - 65);
		
		//System.out.println(k);
	}

}
