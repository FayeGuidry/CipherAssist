package cipherassist.verification;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

//import ConnorGuidry.BinaryUtil.Binary;

public class SHA256Demo {

	public static void main(String[] args) throws UnsupportedEncodingException 
	{
		
		//String test = "0111000001100001011100110111001101110111011011110111001001100100";
		//String test2 = "111000001100001011100110111001101110111011011110111001001100100";
		//System.out.println(test);
		
		//System.out.println(messageToBinary("password"));
		
		//SHA256 hash = new SHA256(test);
		//System.out.println(hash.getHash());
		
		//SHA256 hash1 = new SHA256(test2);
		//System.out.println(hash1.getHash());
		
		SHA256 hash3 = new SHA256("passworddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
		System.out.println(hash3.getHash());
		
		SHA256 hash2 = new SHA256();
		System.out.println(hash2.getHash());
		
		
	}
	
	private static String messageToBinary(String message) throws UnsupportedEncodingException
	{
		byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
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

}
