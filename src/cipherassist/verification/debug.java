package cipherassist.verification;

import java.io.File;
import java.io.IOException;

public class debug {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = new File(".").getCanonicalPath();
		
		System.out.println(path);
		
		Hashmap map = new Hashmap();
		map.add("username", "blah");
		map.remove("username");
		System.out.println(map.get("username"));
	}

}
