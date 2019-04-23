package ConnorGuidry.BinaryUtil;

//Created by ConnorGuidry
//Binary is a String-based binary-holding data type that allows the direct and simple manipulation of bits in Java. 
public class Binary 
{
	
	String binaryString = null;
	
	public Binary(String binaryString)
	{
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
	
	public static Binary leftShift()
	{
		
	}
}
