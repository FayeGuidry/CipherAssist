package cipherassist.verification;

import java.math.BigInteger;

public class SHA256Demo {

	public static void main(String[] args) 
	{
		SHA256 hash = new SHA256();
		
		BigInteger first = new BigInteger("ffffffff", 16);
		BigInteger second = new BigInteger("ffffffff", 16);
		
		BigInteger result = hash.addMod2Raised32(first, second);
		
		System.out.println(result.toString(16));
		
		BigInteger third = new BigInteger("77359400", 16);
		BigInteger fourth = new BigInteger("b2d05e00", 16);
		
		BigInteger result2 = hash.addMod2Raised32(third, fourth);
		
		System.out.println(result2.toString(16));
	}

}
