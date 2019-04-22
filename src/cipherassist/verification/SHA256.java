package cipherassist.verification;

public class SHA256 
{
	//Variables that hold the hash values
	private int h0 = 0x6a09e667;
	private int h1 = 0xbb67ae85;
	private int h2 = 0x3c6ef372;
	private int h3 = 0xa54ff53a;
	private int h4 = 0x510e527f;
	private int h5 = 0x9b05688c;
	private int h6 = 0x1f83d9ab;
	private int h7 = 0x5be0cd19;
	
	//Working variables
	private int a;
	private int b;
	private int c;
	private int d;
	private int e;
	private int f;
	private int g;
	private int h;
	
	//N = number of blocks in the padded message
	private int N;
	
	
	public SHA256()
	{
		
	}
}
