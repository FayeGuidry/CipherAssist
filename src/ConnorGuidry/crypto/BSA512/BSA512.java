package ConnorGuidry.crypto.BSA512;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import ConnorGuidry.BinaryUtil.Binary;

public class BSA512 
{
	public char[] charArray;
	
	public int paddedMessageLength = 0;
	
	public Binary message;
	
	public String plainText;
	
	public String cipherText;
	
	public Binary key;
	
	public int zerosToAdd;
	
	public BSA512(String plaintext, String key) throws UnsupportedEncodingException
	{
		message = new Binary(messageToBinary(plaintext));
	}
	
	public String encrypt()
	{
		prepMessage();
		
		shuffleBits();
		
		applyKey();
		
		return cipherText;
	}
	
	public String decrypt()
	{
		//applykey
		//tree
		//depadding
		//format and return
	}
	
	public void applyKey()
	{
		Binary result = new Binary("");
		
		
	}
	
	
	public String getPaddedMessage(String unpaddedMessage)
	{
		Binary onePadding = new Binary("1");

		String zeros = "";
		
		for (int i = 0; i < zerosToAdd; ++i)
		{
			zeros += '0';
		}
		
		Binary zeroPadding = new Binary(zeros);
		
		
		//System.out.println("One padding: " + onePadding);
		//System.out.println("Zero padding: " + zeroPadding);
		this.M.append(onePadding);
		this.M.append(zeroPadding);
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
		
		return convertedToBinary;
	}
}
