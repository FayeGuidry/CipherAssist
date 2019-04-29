package ConnorGuidry.crypto.BSA512;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import ConnorGuidry.BinaryUtil.Binary;

public class BSA512 
{
	public String messageString;
	
	public String keyString;
	
	public String plainText;
	
	public String cipherText;
	
	public char[] messageArray;
	
	public byte[] messageBytes;
	
	public int zerosToAdd;
	
	public int nodes;
	
	public Binary workingBin;
	
	public Binary preXOR;
	
	public Binary postXOR;
	
	public Binary keyBin;
	
	public Binary[] parsedForXOR;
	
	public BinaryStackTree tree;
	
	public BSA512(String plaintext, String key) throws UnsupportedEncodingException
	{
		messageString = new String(plaintext);
		keyString = new String(key);
		
		System.out.println("String in: " + messageString);
	}
	
	public String encrypt() throws InterruptedException, UnsupportedEncodingException
	{
		prepMessage();
		
		shuffleBits();
		
		prepKey();
		
		applyKey();
		
		return cipherText;
	}
	
	public void prepMessage() throws UnsupportedEncodingException, InterruptedException
	{
		initBinaryMessage();
		initZeros();
		initPaddedMessage();
		initTree();

	}
	
	public void initBinaryMessage() throws UnsupportedEncodingException
	{
		messageBytes = messageString.getBytes(StandardCharsets.UTF_8);
		
		int unsignedInt = 0;
		String resultString = "";
		
		for (int i = 0; i < messageBytes.length; ++i)
		{
			unsignedInt = Byte.toUnsignedInt(messageBytes[i]);
			String workingBits = Integer.toBinaryString(unsignedInt);
			
			String z = "";
			int bitCount = 8 - workingBits.length();
			
			while (bitCount > 0)
			{
				z += "0";
				--bitCount;
			}
			
			workingBits = z + workingBits;
			
			
			//System.out.println(bytes[i]);
			//System.out.println(workingBits);
			
			
			resultString  += new String(workingBits);
		}
		
		messageString = new String(resultString);
		System.out.println("Binary in: " + messageString);
		workingBin = new Binary(messageString);
		
		//workingBin = new Binary(messageToBinary(messageString));
		//messageString = new String(workingBin.toString());
	}
	
	public void initDecryption()
	{
		BigInteger hex = new BigInteger(messageString, 16);
		String str = hex.toString(2);
		workingBin = new Binary(str);
		messageString = workingBin.toString();
		
		
		System.out.println("Binary in (pre padding): " + str);
		
		//cipherText = new String(str);
		int len = messageString.length();
		String leng = Integer.toString(len);
		
		BigInteger fiveTwelve = new BigInteger("512", 10);
		BigInteger modResult;
		BigInteger stringLength = new BigInteger(leng, 10);
		
		modResult = stringLength.mod(fiveTwelve);
		
		int padding = 512 - modResult.intValue();
		String z = "";
		
		for (int i = 0; i < padding; ++i)
		{
			z += '0';
		}
		
		z += messageString;
		
		messageString = new String(z);
		
		System.out.println("Binary in (post padding): " + messageString);
		
		if (messageString.length() % 512 != 0)
			System.out.println("at initDecryption binary string is not a multiple of 512!");
	}
	
	public void shuffleBits() throws InterruptedException
	{
		tree.levelOrderLoad(messageArray);
		char[] result = tree.postOrderUnload();
		cipherText = new String(result);
	}
	
	public void prepKey()
	{
		BigInteger preKey = new BigInteger(keyString, 16);
		String stringKey = preKey.toString(2);
		keyBin = new Binary(preKey.toString(2));
		

		int padding = 512 - stringKey.length();
		String z = "";
		
		for (int i = 0; i < padding; ++i)
		{
			z += '0';
		}
		
		z += stringKey;
		
		//System.out.println(z);
		keyBin = new Binary(z);
	}
	
	public void applyKey()
	{
		int blockIndex = 0;
		parsedForXOR = new Binary[nodes];
		
		String workingMessageString = new String(cipherText);
		//System.out.println(cipherText);
		
		for (int i = 0; i < nodes; ++i)
		{
			String messageBlockString = workingMessageString.substring(blockIndex, blockIndex + 512);
			blockIndex += 512;
			
			
			parsedForXOR[i] = new Binary(messageBlockString);
		}
		
		
		
		postXOR = new Binary();
		
		for (int j = 0; j < nodes; ++j)
		{
			Binary result = Binary.XOR(parsedForXOR[j], keyBin);
			postXOR.append(result);
		}
		
		cipherText = postXOR.toString();
		System.out.println("Binary out: " + cipherText);
		
		BigInteger decimal = new BigInteger(cipherText, 2);
		String hexStr = decimal.toString(16);
		
		cipherText = new String(hexStr);
	}
	
	public String byteArrayToHex(byte[] b)
	{
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (byte byt: b)
			sb.append(String.format("%02x", byt));
		return sb.toString();
			
	}
	
	public byte[] binaryStringToByteArray(String str)
	{
		int blocks = str.length() / 8;
		int blockIndex = 0;
		String[] strArray = new String[blocks];
		byte[] byteArray = new byte[blocks];
		
		for (int i = 0; i < blocks; ++i)
		{
			String messageBlockString = str.substring(blockIndex, blockIndex + 8);
			blockIndex += 8;
			
			
			strArray[i] = messageBlockString;
		}
		
		for (int j = 0; j < blocks; ++j)
		{
			int num = Integer.parseInt(strArray[j], 2);
			
			byteArray[j] = (byte) num;
		}
		
		return byteArray;
	}
	
	public void applyDecKey()
	{
		int blockIndex = 0;
		parsedForXOR = new Binary[nodes];
		
		String workingMessageString = new String(messageString);
		
		for (int i = 0; i < nodes; ++i)
		{
			String messageBlockString = workingMessageString.substring(blockIndex, blockIndex + 512);
			//System.out.println(messageBlockString);
			blockIndex += 512;
			
			
			parsedForXOR[i] = new Binary(messageBlockString);
		}
		
		
		
		postXOR = new Binary();
		
		for (int j = 0; j < nodes; ++j)
		{
			Binary result = Binary.XOR(parsedForXOR[j], keyBin);
			postXOR.append(result);
		}
		
		cipherText = postXOR.toString();
	}
	
	public static String generateKey()
	{
		return null;
	}
	
	public void initTree() throws InterruptedException
	{
		int num1 = messageString.length();
		nodes = num1 / 512;
		
		tree = new BinaryStackTree();
		LinkedBlockingQueue<BinaryNode> q = new LinkedBlockingQueue<BinaryNode>();
		tree.addNodes(q, nodes);
	}
	
	public void initZeros()
	{
		int len = messageString.length();
		String leng = Integer.toString(len);
		
		BigInteger fiveTwelve = new BigInteger("512", 10);
		BigInteger modResult;
		BigInteger stringLength = new BigInteger(leng, 10);
		
		modResult = stringLength.mod(fiveTwelve);
		
		int amountZeros = 512 - modResult.intValue() - 1;
		
		zerosToAdd = amountZeros;
	}
	
	public String decrypt() throws UnsupportedEncodingException, InterruptedException, DecoderException
	{
		prepKey();
		
		initDecryption();
		
		initTree();
		
		applyDecKey();
		
		deshuffle();
		
		depadMessage();
		
		
		Binary preHex = new Binary(plainText);
		String hex = preHex.toHexString();
		byte[] bytes = Hex.decodeHex(hex.toCharArray());
		plainText = new String(bytes, "UTF-8");
		
		return plainText;
	}
	
	public void deshuffle() throws InterruptedException
	{
		messageArray = cipherText.toCharArray();
		tree.postOrderLoad(messageArray);
		char [] result = tree.levelOrderUnload();
		messageArray = result;
		String str = new String(result);
		cipherText = new String(str);
		System.out.println("Binary out (padded): " + cipherText);
	}
	
	public void depadMessage()
	{
		int endIndex = cipherText.lastIndexOf('1');
		String trimmed = cipherText.substring(0, endIndex);
		plainText = new String(trimmed);
		System.out.println("Binary out (depadded): " + plainText);
	}
	
	
	public void initPaddedMessage()
	{
		String result = "1";

		String zeros = "";
		
		for (int i = 0; i < zerosToAdd; ++i)
		{
			zeros += '0';
		}
		
		result += zeros;
		messageString += result;
		System.out.println("Padded in: " + messageString);
		workingBin = new Binary(messageString);
		//System.out.println(messageString);
		messageArray = messageString.toCharArray();
	}
	
	private String messageToBinary(String message) throws UnsupportedEncodingException
	{
		byte[] bytes = message.getBytes("UTF8");
		String convertedToBinary = new BigInteger(bytes).toString(2);
		
		if (convertedToBinary.length() % 8 != 0)
		{
			int mod = convertedToBinary.length() % 8;
			int zeros = 8 - mod;
			String append = "";
			
			for (int i = 0; i < zeros; ++i)
			{
				append += "0";
			}
			
			convertedToBinary = append + convertedToBinary;
		}
		
		return convertedToBinary;
	}
}
