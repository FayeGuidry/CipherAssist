package ConnorGuidry.crypto.BSA512;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import ConnorGuidry.BinaryUtil.Binary;

public class BSA512 
{
	public char[] charArray;
	
	public int paddedMessageLength = 0;
	
	public String messageString;
	
	public String plainText;
	
	public String cipherText;
	
	public String keyString;
	
	public int zerosToAdd;
	
	public BSA512(String plaintext, String key) throws UnsupportedEncodingException
	{
		messageString = new String(plaintext);
		keyString = new String(key);
	}
	
	public String encrypt()
	{
		prepMessage();
		
		//shuffleBits();
		
		applyKey();
		
		return cipherText;
	}
	
	public void prepMessage()
	{
		initZeros();
		initPaddedMessage();
	}
	
	public void initZeros()
	{
		int len = messageString.length();
		String leng = Integer.toString(len);
		
		BigInteger fiveTwelve = new BigInteger("512", 10);
		BigInteger modResult;
		BigInteger stringLength = new BigInteger(leng, 10);
		
		modResult = stringLength.mod(fiveTwelve);
		
		int amountZeros = 512 - modResult.intValue() - 1;
		
		zerosToAdd = amountZeros;
	}
	
	public String decrypt()
	{
		//applykey
		//tree
		//depadding
		//format and return
		return plainText;
	}
	
	public void applyKey()
	{
		Binary result = new Binary("");
		
		
	}
	
	
	public void initPaddedMessage()
	{
		String onePadding = "1";

		String zeros = "";
		
		for (int i = 0; i < zerosToAdd; ++i)
		{
			zeros += '0';
		}
		
		Binary zeroPadding = new Binary(zeros);
		
		this.M.append(onePadding);
		this.M.append(zeroPadding);
		
		return
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
