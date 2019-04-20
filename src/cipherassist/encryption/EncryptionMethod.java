package cipherassist.encryption;

/** 
 * @author ConnorGuidry
 *
 */
public interface EncryptionMethod 
{
	/** Takes plaintext string and key string
	 * @return Returns encrypted text as String
	 */
	public String getEncryptedString(String plaintext, String key);
	
	
	/** Takes ciphertext string and key string
	 * @return Returns decrypted text as String
	 */
	public String getDecryptedString(String ciphertext, String key);
	
}
