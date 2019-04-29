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
import cipherassist.verification.Hashmap;

public class CipherIO {

	private static final byte[] SALT = new byte[] { 4, 4, 4, 4, 4, 4, 4, 4 };
	
	public static void seal(User user, String username) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, IOException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException
	{
		String password = user.getPassword();
		
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEwithMD5AndDES");
		SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
		
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(SALT, 100);
		Cipher cipher = Cipher.getInstance("PBEwithMD5AndDES");
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
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEwithMD5AndDES");
		SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
		
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(SALT, 100);
		
		Cipher cipher = null;
		
		try {
			cipher = Cipher.getInstance("PBEwithMD5AndDES");
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

	public static void store(Hashmap hashmap) throws IOException
	{
		FileOutputStream outStream = new FileOutputStream("userdata.dat");
		ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);
				
		objectOutputFile.writeObject(hashmap);
		
		objectOutputFile.close();
	}
	
	public static Settings access(String filename) throws IOException, ClassNotFoundException
	{
		FileInputStream inStream = new FileInputStream((filename));
		ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
		
		Settings settings = (Settings) objectInputFile.readObject();
		
		objectInputFile.close();
		
		return settings;
	}
	
	public static void store(Settings settings) throws IOException
	{
		FileOutputStream outStream = new FileOutputStream("settings.dat");
		ObjectOutputStream objectOutputFile = new ObjectOutputStream(outStream);
				
		objectOutputFile.writeObject(settings);
		
		objectOutputFile.close();
	}
	
	public static Hashmap access() throws IOException, ClassNotFoundException
	{
		FileInputStream inStream = new FileInputStream(("userdata.dat"));
		ObjectInputStream objectInputFile = new ObjectInputStream(inStream);
		
		Hashmap hashmap = (Hashmap) objectInputFile.readObject();
		
		objectInputFile.close();
		
		return hashmap;
	}
	
	
}
