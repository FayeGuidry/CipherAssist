package ConnorGuidry.crypto.BSA512;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class BSA512 
{
	public BSA512()
	{
		
	}
	
	public String getPaddedMessage(String unpaddedMessage)
	{
		
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
