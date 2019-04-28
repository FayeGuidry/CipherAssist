package ConnorGuidry.crypto.BSA512;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.concurrent.LinkedBlockingQueue;

import ConnorGuidry.BinaryUtil.Binary;

public class BSA512 
{
	public String messageString;
	
	public String keyString;
	
	public String cipherText;
	
	public char[] messageArray;
	
	public int zerosToAdd;
	
	public int nodes;
	
	public Binary workingBin;
	
	public Binary preXOR;
	
	public Binary postXOR;
	
	public Binary[] parsedForXOR;
	
	public BinaryStackTree tree;
	
	public BSA512(String plaintext, String key) throws UnsupportedEncodingException
	{
		messageString = new String(plaintext);
		keyString = new String(key);
	}
	
	public String encrypt() throws InterruptedException, UnsupportedEncodingException
	{
		prepMessage();
		
		shuffleBits();
		
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
		workingBin = new Binary(messageToBinary(messageString));
		messageString = new String(workingBin.toString());
	}
	
	public void shuffleBits() throws InterruptedException
	{
		tree.levelOrderLoad(messageArray);
		char [] result = tree.postOrderUnload();
		String str = new String(result);
		cipherText = new String(str);
		
	}
	
	public void applyKey()
	{
		int blockIndex = 0;
		parsedForXOR = new Binary[nodes];
		
		String workingMessageString = new String(cipherText);
		
		for (int i = 0; i < nodes; ++i)
		{
			String messageBlockString = workingMessageString.substring(blockIndex, blockIndex + 511);
			blockIndex += 512;
			
			
			parsedForXOR[i] = new Binary(messageBlockString);
		}
		
		BigInteger preKey = new BigInteger(keyString, 16);
		Binary keyBin = new Binary(preKey.toString(2));
		
		for (int j = 0; j < nodes; ++j)
		{
			postXOR.append(Binary.XOR(parsedForXOR[j], keyBin));
		}
		
		cipherText = postXOR.toHexString();
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
	
	public String decrypt()
	{
		//applykey
		//tree
		//depadding
		//format and return
		return null;
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
		System.out.println(messageString);
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
