package cipherassist.verification;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class SHA256Demo {

	public static void main(String[] args) throws UnsupportedEncodingException 
	{
		
		SHA256 hash = new SHA256("dog");
		System.out.println(hash.getHash());
		
		/*
		SHA256 hash1 = new SHA256("This is a test of the binary encoding. This sentence is significantly long enough to test more than 512 bit blocks of data."
				+ "This is a test of the binary encoding. This sentence is significantly long enough to test more than 512 bit blocks of data."
				+ "This is a test of the binary encoding. This sentence is significantly long enough to test more than 512 bit blocks of data."
				+ "This is a test of the binary encoding. This sentence is significantly long enough to test more than 512 bit blocks of data."
				+ "This is a test of the binary encoding. This sentence is significantly long enough to test more than 512 bit blocks of data."
				+ "This is a test of the binary encoding. This sentence is significantly long enough to test more than 512 bit blocks of data.");
		System.out.println(hash1.getHash());
		
		SHA256 hash2 = new SHA256("1");
		System.out.println(hash2.getHash());
		*/
		
	}

}
