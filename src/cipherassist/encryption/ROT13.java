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
		String result;
		
		
		
		return "test";
	}
	
	private char shift13(char c)
	{
		char shiftedChar = ' ';
		
		switch (c) {
		case ' ':
			shiftedChar = ' ';
		case 'A':
			shiftedChar = 'N';
			break;
		case 'B':
			shiftedChar = 'O';
			break;
		case 'C':
			shiftedChar = 'P';
			break;
		case 'D':
			shiftedChar = 'Q';
			break;
		case 'E':
			shiftedChar = 'R';
			break;
		case 'F':
			shiftedChar = 'S';
			break;
		case 'G':
			shiftedChar = 'T';
			break;
		case 'H':
			shiftedChar = 'U';
			break;
		case 'I':
			shiftedChar = 'V';
			break;
		case 'J':
			shiftedChar = 'W';
			break;
		case 'K':
			shiftedChar = 'X';
			break;
		case 'L':
			shiftedChar = 'Y';
			break;
		case 'M':
			shiftedChar = 'Z';
			break;
		case 'N':
			shiftedChar = 'A';
			break;
		case 'O':
			shiftedChar = 'B';
			break;
		case 'P':
			shiftedChar = 'C';
			break;
		case 'Q':
			shiftedChar = 'D';
			break;
		case 'R':
			shiftedChar = 'E';
			break;
		case 'S':
			shiftedChar = 'F';
			break;
		case 'T':
			shiftedChar = 'G';
			break;
		case 'U':
			shiftedChar = 'H';
			break;
		case 'V':
			shiftedChar = 'I';
			break;
		case 'W':
			shiftedChar = 'J';
			break;
		case 'X':
			shiftedChar = 'K';
			break;
		case 'Y':
			shiftedChar = 'L';
			break;
		case 'Z':
			shiftedChar = 'M';
			break;
		case 'a':
			shiftedChar = 'n';
			break;
		case 'b':
			shiftedChar = 'o';
			break;
		case 'c':
			shiftedChar = 'p';
			break;
		case 'd':
			shiftedChar = 'q';
			break;
		case 'e':
			shiftedChar = 'r';
			break;
		case 'f':
			shiftedChar = 's';
			break;
		case 'g':
			shiftedChar = 't';
			break;
		case 'h':
			shiftedChar = 'u';
			break;
		case 'i':
			shiftedChar = 'v';
			break;
		case 'j':
			shiftedChar = 'w';
			break;
		case 'k':
			shiftedChar = 'x';
			break;
		case 'l':
			shiftedChar = 'y';
			break;
		case 'm':
			shiftedChar = 'z';
			break;
		case 'n':
			shiftedChar = 'a';
			break;
		case 'o':
			shiftedChar = 'b';
			break;
		case 'p':
			shiftedChar = 'c';
			break;
		case 'q':
			shiftedChar = 'd';
			break;
		case 'r':
			shiftedChar = 'e';
			break;
		case 's':
			shiftedChar = 'f';
			break;
		case 't':
			shiftedChar = 'g';
			break;
		case 'u':
			shiftedChar = 'h';
			break;
		case 'v':
			shiftedChar = 'i';
			break;
		case 'w':
			shiftedChar = 'j';
			break;
		case 'x':
			shiftedChar = 'k';
			break;
		case 'y':
			shiftedChar = 'l';
			break;
		case 'z':
			shiftedChar = 'm';
			break;
		default:
			shiftedChar = ' ';
			break;
		}
		
		return shiftedChar;
	}
	
}
