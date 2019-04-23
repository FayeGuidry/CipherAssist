package ConnorGuidry.BinaryUtil;

import java.math.BigInteger;

//Created by ConnorGuidry
//Binary is a String-based binary-holding data type that allows the direct and simple manipulation of bits in Java. 
public class Binary 
{
	
	private String binaryString = null;
	
	public Binary(String binaryString)
	{
		setBinaryString(binaryString);
	}
	
	public static int binaryToInt(Binary binary)
	{
		String workingString = binary.getBinaryString();
		
		int num = Integer.parseInt(workingString, 2);
		
		return num;
	}
	
	public static Binary intToBinary(int num)
	{
		String intString = Integer.toBinaryString(num);
		
		Binary newBinary = new Binary(intString);
		
		return newBinary;
	}
	
	public static void leftShift(Binary binary, int shiftAmount)
	{	
		String workingString = binary.getBinaryString();
		
		if (shiftAmount > workingString.length())
			throw new IndexOutOfBoundsException("shiftAmount cannot be greater than the input String length");
		
		String trimmedString = workingString.substring(shiftAmount - 1, workingString.length() - 1);
		workingString = trimmedString;
		
		for (int i = 0; i < shiftAmount; ++i)
		{
			workingString += '0';
		}
		
		binary.setBinaryString(workingString);
	}
	
	public static void rightShift(Binary binary, int shiftAmount)
	{
		String workingString = binary.getBinaryString();
		
		if (shiftAmount > workingString.length())
			throw new IndexOutOfBoundsException("shiftAmount cannot be greater than the input String length");
		
		String trimmedString = workingString.substring(0, workingString.length() - shiftAmount);
		workingString = trimmedString;
		
		String leftPadding = "";
		
		for (int i = 0; i < shiftAmount; ++i)
		{
			leftPadding += '0';
		}
		
		leftPadding += workingString;
		
		workingString = leftPadding;
		
		binary.setBinaryString(workingString);
	}
	
	public static Binary complement(Binary binary)
	{	
		Binary resultBinary = new Binary(binary.toString());
		char workingChar = '0';
		
		//String resultString = binary.toString();
		String workingString = binary.toString();
		
		for (int i = 0; i < binary.length(); ++i)
		{
			if (i == 0)
			{
				workingChar = workingString.charAt(0);
				workingChar = Binary.flipCharBit(workingChar);
				workingString = workingChar + workingString.substring(1);
			}
			else
			{
				workingChar = workingString.charAt(i);
				workingChar = Binary.flipCharBit(workingChar);
				workingString = workingString.substring(0, i - 1) + workingChar + workingString.substring(i + 1);
			}
		}
		System.out.println(workingString);
		resultBinary.setBinaryString(workingString);
		return resultBinary;
	}
	
	public static Binary AND(Binary firstBinary, Binary secondBinary)
	{
		assert (firstBinary.length() == secondBinary.length());
		Binary resultBinary = new Binary(firstBinary.toString());
		
		String resultString = resultBinary.toString();
		String firstWorkingString = firstBinary.toString();
		String secondWorkingString = secondBinary.toString();
		
		for (int i = 0; i < firstBinary.length(); ++i)
		{
			resultString = 1;
			//resultstring 
		}
	}
	
	public static Binary OR(Binary firstBinary, Binary secondBinary)
	{
		assert (firstBinary.length() == secondBinary.length());
	}
	
	public static Binary XOR(Binary firstBinary, Binary secondBinary)
	{
		assert (firstBinary.length() == secondBinary.length());
	}
	
	public String getBinaryString()
	{
		return binaryString;
	}
	
	public void setBinaryString(String binaryString)
	{
		//Checks if param binaryString only consists of 1's or 0's
				for (int count = 0; count < binaryString.length(); ++count)
				{
					assert (binaryString != null);
					
					if ((binaryString.charAt(count) != '1') && (binaryString.charAt(count) != '0'))
					{
						count = binaryString.length() + 1;
						throw new IllegalArgumentException("Binary data type can only accept Strings consisting of either 1 or 0.");
					}
				}
				
				this.binaryString = binaryString;
	}
	
	public String toString()
	{
		return this.binaryString;
	}
	
	public String toHexString()
	{
		BigInteger decimal = new BigInteger(this.binaryString, 2);
		String hexString = decimal.toString(16);
		return hexString;
	}
	
	public int length()
	{
		return this.binaryString.length();
	}
	
	public static char flipCharBit(char bit)
	{
		if (bit == '0')
			bit = '1';
		else
			bit = '0';
		
		return bit;
	}
}
