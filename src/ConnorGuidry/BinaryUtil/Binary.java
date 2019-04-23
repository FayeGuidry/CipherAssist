package ConnorGuidry.BinaryUtil;

//Created by ConnorGuidry
//Binary is a String-based binary-holding data type that allows the direct and simple manipulation of bits in Java. 
public class Binary 
{
	
	private String binaryString = null;
	
	public Binary(String binaryString)
	{
		setBinaryString(binaryString);
	}
	
	public static Binary leftShift(Binary binary, int shiftAmount)
	{	
		String workingString = binary.getBinaryString();
		
		if (shiftAmount > workingString.length())
			throw new IndexOutOfBoundsException("shiftAmount cannot be greater than the input String length");
		
		String trimmedString = workingString.substring(0, shiftAmount);
		workingString = trimmedString;
		
		for (int i = 0; i < shiftAmount; ++i)
		{
			workingString += '0';
		}
		
		binary.setBinaryString(workingString);
		return binary;
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
					if ((binaryString.charAt(count) != '1') || (binaryString.charAt(count) != '0'))
					{
						count = binaryString.length() + 1;
						throw new IllegalArgumentException("Binary data type can only accept Strings consisting of either 1 or 0.");
					}
				}
				
				this.binaryString = binaryString;
	}
}
