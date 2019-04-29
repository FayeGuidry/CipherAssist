package ConnorGuidry.crypto.BSA512;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.commons.codec.DecoderException;

import ConnorGuidry.BinaryUtil.Binary;

public class DemoBSA512 
{

	public static void main(String[] args) throws Exception 
	{
		
		
		String str = "abcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnopabcdefghijklmnop";
		BSA512 bsa = new BSA512(str, "5D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C7");
		System.out.println("Output: " + bsa.encrypt());
		System.out.println();
		
		String ciphertext = "5d44b5d354c71f91f58c45d21d3575d44b5d354c71f91f58c45d21d3575d44b5d354c71f91f58c45d21d3575d44b5d354c71f91f58c45d21d3575d44b5d356a73df3c99d199ad4bac4187bfd05f07c1733201e22581e0c83e5cb56fa79d8153fc52539657acdd5d6382f665c7a0a5b3e87ec056830a91074881c6db0875c5d06269786eb6f291777a666d4406a1078513246c73dafaf54719dacc32351646ae55c1f3cb26192e8099f4eefdee49f531a4482a0d4aba8766fd0380e8e14c533f471c9ea48c6b6a1db1ea40211ff8537fdc5b6bb17aae46b3fb47264801d967001d1dbfec0ba3e3f64e9d3171bd7a14c27230cb69207cf2f504531165df272b6b76279bbb9d3dce4bca5fb79dc5864bfff79c14b6349241693b7080afd763a477bf6e2b076ff78d1cec06dc34f3f531ca6ae448236b68ddb3a09ce89339dfe119e270f842f264836488e4775c2269b71b208a6a0fe069c52d59147d3a3814b0fb892a52decbfcce20ddd46dfdc042c7929092e22b46918130efb9c048745977fc956abd608f1f178e0990916488f45c3dea0d56a8f9b4a75710a3e2f989d4410d2633b8a40da3ebdf990922cb2ff88ed3c77fed3f14b3f4813b46a52c1e6d926b7c3e2feea0b66f5e2e2b50bb01a3e9fbd3b2a49023ca4d473f5c91ffc4f984d76ab29ec71b8129f9ef38b425cface0cbf5a000765b3fc04b239650e6d1b9252cc96d949a43caa52c4aec775262fba7c15308e06744a1717be97b7b04120784930aa4f356e4fa3c76c8becd785d2727365c33a02b2a8a3396d9e0487ef85075ae855b7ec18a7ab34dff6e31618bc2312e767d06ad7e388a1122f756610b5ed069c5dbf49444ae8f822a23270269e8069814efec0c0730fee00e8997f2ab63945d53239fa5e0bcc6de063ea0ecb5a9497a474603b26f6e2e475942a1ddd120c8e9ee1c8b930a928858ea1481e5bf52c5efb69c78e76364900aac127ab7e5ecb1554bf71cefaba8e998a2f1591a53518308d311604b003763681bf9611c36cf340d390af52ade690c1c88707c705025d16380d8013ec76fd3369dc0cb7ed65b470db181b6e78651b51bedd471c11ed715eda40b25697d4cf7829a8d87249c52df2bf38dc98dc7b46e66c1c7e3b3e1e520952fc1eb440130f6c9d91d844839e10e4ce66cb9f3d473c0aa392b14a574e3f07a4d5fb7e752e58f52bd3646fb15056aedca323bb51dca8476ee3890b5acc8e54f6340cd27171234efaf2c12a6d9b56054d4b354ba9bfff46021fbe16fbb37473df80c0c93b1994520d9f16112765d24d74a887f427aa1b84a381f7a4e7a36e50b0356a0b6e869216088aa6bfb4b3ea7a97d20f4e7ea4a07bddb8df9f792de17bfb43ae6c8782953416c7327219f64b2386ffd998840384320f393572b636fb1f1cc29a774483d92946a3781817ff1860735fcb8c0c7f0cacb0ce4267bc1edf64c624207ac12ef26d29523b6aca10fca6c5ec69c97516ee7768826a097b911a971e7eed8730601954eaa002766a94b4570978f2c2ba3a4a421ae7fcb3e8f62d3447a9684e659fb099431ec4f5a47f7001eca91ff6e3e37aa59ca9d60565efe559530f8a6cad2fa110ac864daf3463c51fca1cb55f207afe71d9fad7af7bcd5251c80e02eee740255177ec967810a7196fbbd8bba4c434c3eb34be9866ef463beb3fa7f9a6dcb27737081d34530f7fca00a0ed2bf88c1f0c2e2db7035c1536f6c5dd70d21fa262020a6aa3602e56045736c54df28c26ce546636c5247b17d340b75c3c0685511599960ae2c3636bad165d0425399ebd7d200c4ad41a32fb33b0245e5d2ccb369ac146cb2e6f72faf91c42be18c93b68f998c11089560581e6c454f437a2ca27632a55c780bdccd6c2f65942245f47a28a9154b8ac7da7221b0c5b84c416cee1819e7b14890efb7867894a9adba79ed46299a70bd17266bf755d3a0660fca684cab5e36b387f1a87576316eed3af3b888fda6bf685a3008157fe416049d20c935a32ac79ff9303bd54b755a7bc298892cefefe34447b7e6c93eabf45734cf775dfdfa60c8320614af0829eec6fd8cbfc6c1a165a86d96efc3c52761a6eeb42251f7442d3d62dd7e9bc4505263161bc367fbc0a5e0884e102fc66186c363ac8e32a4b74f8a89c6d548e7d50a11ebf206123a2521ca096b7a2cb233ed90aacdfbf5fc07110cb06cb7a873a60a9960b1cb4a029c26afad66cb6240f763b479e9ac4fdf23a50bfd20ede27a3e2cd";
		BSA512 bsa2 = new BSA512(ciphertext, "5D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C7");
		System.out.println("Output: " + bsa2.decrypt());
		System.out.println();
		
		
		String key = "5468576D5A7134743677397A24432646294A404E635266556A586E327235753878214125442A472D4B6150645367566B597033733676397924423F4528482B4D";
		String text = "I really love doggos a lot.";
		BSA512 bsa3 = new BSA512(text, key);
		System.out.println("Output: " + bsa3.encrypt());
		System.out.println();
		
		//String key = "5468576D5A7134743677397A24432646294A404E635266556A586E327235753878214125442A472D4B6150645367566B597033733676397924423F4528482B4D";
		String ciphertext1 = "5468576d5a7134743677397a24432646294a404e635266556a586e327235753878214125455e69db7d65d6609d91b08daf5637d558800f7dba7409c38e062fdf";
		BSA512 bsa4 = new BSA512(ciphertext1, key);
		System.out.println("Output: " + bsa4.decrypt());
		System.out.println();
		
		/*
		String str = "zZf27";
		System.out.println(str);
		byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
		String str4 = Arrays.toString(bytes);
		
		System.out.println(str4);
		
		String unsignedString = byteArrayToUnsignedBinary(bytes);
		
		System.out.println(unsignedString);
		

		Binary bin = new Binary(unsignedString);

		System.out.println(bin);
		
		String result = bin.toString();
		
		//int i = Integer.parseInt(result, 2);
		//System.out.println(i);
		
		byte[] bytes2 = binaryStringToByteArray(result);
		
		String str9 = Arrays.toString(bytes2);
		
		System.out.println(str9);
		
		
		
		//System.out.println(str3);
		
		String result1 = new String(bytes2, StandardCharsets.UTF_8);
		System.out.println(result1);
		
		
		//BigInteger hexKey = new BigInteger("5D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C71F91F58C45D21D3575D44B5D354C7", 16);
		//System.out.println(hexKey.toString(2));
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		BinaryStackTree tree = new BinaryStackTree();
		
		BinaryStackTree.generateNodes(tree, 3);
		
		
		char[] mychars;
		
		mychars = str.toCharArray();
		
		tree.postOrderLoad(mychars);
		
		char[]  newchars = tree.levelOrderUnload();
		String resultString = new String(newchars);
		
		System.out.println(("char[] encrypted chars: " + resultString));
		
		String cipherString = "pnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecabpnomkljhigefdbcaopnlmkijhfgecdbpaomnljkighfdecab";
		
		char[] cipherChars = cipherString.toCharArray();
		
		tree.levelOrderLoad(cipherChars);
		
		char[] plainChars = tree.postOrderUnload();
		String plaintext = new String(plainChars);
		
		System.out.println(("char[] decrypted chars: " + plaintext)); 
		
		
		*/
		
	}
	

	public static String byteArrayToUnsignedBinary(byte[] bytes)
	{
		int unsignedInt = 0;
		String result = "";
		
		for (int i = 0; i < bytes.length; ++i)
		{
			unsignedInt = Byte.toUnsignedInt(bytes[i]);
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
			
			
			result += workingBits;
		}
		
		return result;
	}
	
	public static byte[] binaryStringToByteArray(String str)
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

	
}
