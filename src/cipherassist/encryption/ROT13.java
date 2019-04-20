package cipherassist.encryption;

public class ROT13 extends EncryptionBase implements EncryptionMethod 
{

	public ROT13()
	{
		setNote("For casual use only; not cryptographically secure.");
		setMethodName("ROT13");
	}
	
	@Override
	public String getEncryptedString(String plaintext) {
		// TODO Auto-generated method stub
		return encrypt(plaintext);
	}

	@Override
	public String getDecryptedString(String ciphertext) {
		// TODO Auto-generated method stub
		return encrypt(ciphertext);
	}

	@Override
	public void getKey(String key) 
	{
		//No key required for ROT13
	}
	
	private String encrypt(String text)
	{
		return "test";
	}
	
}
