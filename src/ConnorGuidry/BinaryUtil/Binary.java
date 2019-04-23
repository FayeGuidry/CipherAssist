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
		
		String workingString = binary.toString();
		
		for (int i = 0; i < binary.length(); ++i)
		{
			if (i == 0)
			{
				workingChar = workingString.charAt(0);
				workingChar = Binary.flipCharBit(workingChar);
				workingString = workingChar + workingString.substring(1);
			}
			else if ((i > 0) && (i < binary.length() - 1))
			{
				workingChar = workingString.charAt(i);
				workingChar = Binary.flipCharBit(workingChar);
				workingString = workingString.substring(0, i) + workingChar + workingString.substring(i + 1);
			}
			else
			{
				workingChar = workingString.charAt(binary.length() - 1);
				workingChar = Binary.flipCharBit(workingChar);
				workingString = workingString.substring(0, i) + workingChar;
			}
		}
		
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
		
		char firstChar = '0';
		char secondChar = '0';
		char resultChar = '0';
		
		for (int i = 0; i < firstBinary.length(); ++i)
		{
			if (i == 0)
			{
				firstChar = firstWorkingString.charAt(0);
				secondChar = secondWorkingString.charAt(0);
				resultChar = Binary.multiplyCharBits(firstChar, secondChar);
				resultString = resultChar + resultString.substring(1);
			}
			else if ((i > 0) && (i < firstBinary.length() - 1))
			{
				firstChar = firstWorkingString.charAt(i);
				secondChar = secondWorkingString.charAt(i);
				resultChar = Binary.multiplyCharBits(firstChar, secondChar);
				resultString = resultString.substring(0, i) + resultChar + resultString.substring(i + 1);
			}
			else
			{
				firstChar = firstWorkingString.charAt(firstBinary.length() - 1);
				secondChar = secondWorkingString.charAt(secondBinary.length() - 1);
				resultChar = Binary.multiplyCharBits(firstChar, secondChar);
				resultString = resultString.substring(0, i) + resultChar;
			}
		}
		
		resultBinary.setBinaryString(resultString);
		return resultBinary;
	}
	
	public static Binary OR(Binary firstBinary, Binary secondBinary)
	{
		assert (firstBinary.length() == secondBinary.length());
		Binary resultBinary = new Binary(firstBinary.toString());
		
		String resultString = resultBinary.toString();
		String firstWorkingString = firstBinary.toString();
		String secondWorkingString = secondBinary.toString();
		
		char firstChar = '0';
		char secondChar = '0';
		char resultChar = '0';
		
		for (int i = 0; i < firstBinary.length(); ++i)
		{
			if (i == 0)
			{
				firstChar = firstWorkingString.charAt(0);
				secondChar = secondWorkingString.charAt(0);
				resultChar = Binary.addCharBits(firstChar, secondChar);
				resultString = resultChar + resultString.substring(1);
			}
			else if ((i > 0) && (i < firstBinary.length() - 1))
			{
				firstChar = firstWorkingString.charAt(i);
				secondChar = secondWorkingString.charAt(i);
				resultChar = Binary.addCharBits(firstChar, secondChar);
				resultString = resultString.substring(0, i) + resultChar + resultString.substring(i + 1);
			}
			else
			{
				firstChar = firstWorkingString.charAt(firstBinary.length() - 1);
				secondChar = secondWorkingString.charAt(secondBinary.length() - 1);
				resultChar = Binary.addCharBits(firstChar, secondChar);
				resultString = resultString.substring(0, i) + resultChar;
			}
		}
		
		resultBinary.setBinaryString(resultString);
		return resultBinary;
	}
	
	public static Binary XOR(Binary firstBinary, Binary secondBinary)
	{
		assert (firstBinary.length() == secondBinary.length());
		Binary resultBinary = new Binary(firstBinary.toString());
		
		String resultString = resultBinary.toString();
		String firstWorkingString = firstBinary.toString();
		String secondWorkingString = secondBinary.toString();
		
		char firstChar = '0';
		char secondChar = '0';
		char resultChar = '0';
		
		for (int i = 0; i < firstBinary.length(); ++i)
		{
			if (i == 0)
			{
				firstChar = firstWorkingString.charAt(0);
				secondChar = secondWorkingString.charAt(0);
				resultChar = Binary.XORCharBits(firstChar, secondChar);
				resultString = resultChar + resultString.substring(1);
			}
			else if ((i > 0) && (i < firstBinary.length() - 1))
			{
				firstChar = firstWorkingString.charAt(i);
				secondChar = secondWorkingString.charAt(i);
				resultChar = Binary.XORCharBits(firstChar, secondChar);
				resultString = resultString.substring(0, i) + resultChar + resultString.substring(i + 1);
			}
			else
			{
				firstChar = firstWorkingString.charAt(firstBinary.length() - 1);
				secondChar = secondWorkingString.charAt(secondBinary.length() - 1);
				resultChar = Binary.XORCharBits(firstChar, secondChar);
				resultString = resultString.substring(0, i) + resultChar;
			}
		}
		
		resultBinary.setBinaryString(resultString);
		return resultBinary;
	}
	
	public static Binary XOR(Binary firstBinary, Binary secondBinary, Binary thirdBinary)
	{
		assert (firstBinary.length() == secondBinary.length());
		assert (secondBinary.length() == thirdBinary.length());
		
		Binary resultBinary = new Binary(firstBinary.toString());
		
		String resultString = resultBinary.toString();
		String firstWorkingString = firstBinary.toString();
		String secondWorkingString = secondBinary.toString();
		String thirdWorkingString = thirdBinary.toString();
		
		char firstChar = '0';
		char secondChar = '0';
		char thirdChar = '0';
		char resultChar = '0';
		
		for (int i = 0; i < firstBinary.length(); ++i)
		{
			if (i == 0)
			{
				firstChar = firstWorkingString.charAt(0);
				secondChar = secondWorkingString.charAt(0);
				thirdChar = thirdWorkingString.charAt(0);
				resultChar = Binary.XORCharBits(firstChar, secondChar, thirdChar);
				resultString = resultChar + resultString.substring(1);
			}
			else if ((i > 0) && (i < firstBinary.length() - 1))
			{
				firstChar = firstWorkingString.charAt(i);
				secondChar = secondWorkingString.charAt(i);
				thirdChar = thirdWorkingString.charAt(i);
				resultChar = Binary.XORCharBits(firstChar, secondChar, thirdChar);
				resultString = resultString.substring(0, i) + resultChar + resultString.substring(i + 1);
			}
			else
			{
				firstChar = firstWorkingString.charAt(firstBinary.length() - 1);
				secondChar = secondWorkingString.charAt(secondBinary.length() - 1);
				thirdChar = thirdWorkingString.charAt(thirdBinary.length() - 1);
				resultChar = Binary.XORCharBits(firstChar, secondChar, thirdChar);
				resultString = resultString.substring(0, i) + resultChar;
			}
		}
		
		resultBinary.setBinaryString(resultString);
		return resultBinary;
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
	
	public static char multiplyCharBits(char firstBit, char secondBit)
	{
		char resultBit;
		
		if ((firstBit == '1') & (secondBit == '1'))
			resultBit = '1';
		else
			resultBit = '0';
		
		return resultBit;
	}
	
	public static char addCharBits(char firstBit, char secondBit)
	{
		char resultBit;
		
		if ((firstBit == '0') & (secondBit == '0'))
			resultBit = '0';
		else
			resultBit = '1';
		
		return resultBit;
	}
	
	//2-input XOR method
	public static char XORCharBits(char firstBit, char secondBit)
	{
		char resultBit;
		
		if (((firstBit == '1') & (secondBit == '1')) | ((firstBit == '0') & (secondBit == '0')))
			resultBit = '0';
		else
			resultBit = '1';
		
		return resultBit;
	}
	
	//3-input XOR method
	public static char XORCharBits(char firstBit, char secondBit, char thirdBit)
	{
		char resultBit;
		
		int num = Character.getNumericValue(firstBit) + Character.getNumericValue(secondBit) + Character.getNumericValue(thirdBit);
		
		if (num == 1)
			resultBit = '1';
		else
			resultBit = '0';
		
		return resultBit;
	}
}
