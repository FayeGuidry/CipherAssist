package cipherassist.encryption;

import ConnorGuidry.crypto.BSA512.BSA512;

public class Encrypt 
{
	//update the switch statement in the GUI to add new encryption methods
	//public EncryptionMethod rot13 = new ROT13();
	
	//public EncryptionMethod bsa512 = new BSA512();
	
	public static EncryptionMethod getMethod(int index)
	{
		
		EncryptionMethod method;
		switch(index)
		{
		case 0: //ROT13
			method = new ROT13();
			break;
		case 1: //BSA512
			method = new BSA512();
			break;
		default: method = null;//Encryption doesn't exist
			break;
		}
		
		return method;
	}
	
	
}
