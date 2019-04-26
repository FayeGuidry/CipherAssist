package cipherassist.verification;

import cipherassist.fileio.CipherIO;
import cipherassist.user.User;

public class Verify 
{
	public static User login(String username, String password, Hashmap hashmap)
	{
		User userNotFound = null;
		
		//String hash = SHA256.hash(password);
		//verificationHash = hashmap.get(username);
		
		//If no match, null user object is returned to indicate failure
		/*
		if (hash.equals(verificationHash))
			return CipherIO.unseal(username, password);
		else
			return userNotFound;
			*/
	}
}
