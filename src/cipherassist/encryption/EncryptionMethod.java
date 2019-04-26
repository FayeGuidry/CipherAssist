package cipherassist.encryption;

/** 
 * @author ConnorGuidry
 *
 */
public interface EncryptionMethod 
{
	/** 
	 * @return Returns encrypted text as String
	 */
	public String getEncryptedString(String plaintext);
	
	
	/** 
	 * @return Returns decrypted text as String
	 */
	public String getDecryptedString(String ciphertext);
	
	
	/**
	 * @param key Encryption key as a string
	 */
	public void getKey(String key);
}
