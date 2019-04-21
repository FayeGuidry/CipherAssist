package cipherassist.fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import cipherassist.user.User;

public class CipherIO {

	private static final byte[] SALT = new byte[] { 4, 4, 4, 4, 4, 4, 4, 4 };
	
	public static void seal(User user, String username) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, IOException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException
	{
		String password = user.getPassword();
		
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndTripleDES");
		SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
		
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(SALT, 100);
		Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, pbeParameterSpec);
		
		SealedObject sealedUser = new SealedObject(user, cipher);
		
		FileOutputStream outStream = new FileOutputStream(username);
		ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);
				
		objectOutputFile.writeObject(sealedUser);
		
		objectOutputFile.close();
	}
	
	public static User unseal(String username, String password) throws IOException, ClassNotFoundException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException
	{
		User unsealedUser = null;
		
		FileInputStream inStream = new FileInputStream((username));
		ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
				
		SealedObject sealedUser;
		sealedUser = (SealedObject) objectInputFile.readObject();
		
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndTripleDES");
		SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
		
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(SALT, 100);
		
		Cipher cipher = null;
		
		try {
			cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
		} catch (NoSuchPaddingException e1) {
			e1.printStackTrace();
		}
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey, pbeParameterSpec);
		
		try {
			unsealedUser = (User)sealedUser.getObject(cipher);
		} catch (Exception e) {
			e.printStackTrace();
		};
		
		objectInputFile.close();
		
		return unsealedUser;
	}

}
