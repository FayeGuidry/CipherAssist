package cipherassist.verification;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import cipherassist.fileio.CipherIO;

public class debugmain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Hashmap map = new Hashmap();
		SHA256 hash = new SHA256("password");
		String password = hash.getHash();
		
		map.add("username", password);
		CipherIO.store(map);
		
	}

}
