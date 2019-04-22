package cipherassist.verification;

public class DemoClass 
{
	public static void main(String[] args) 
	{
		HashMap first = new HashMap();
		
		first.add("Password", "Username");
		System.out.println(first.getSize());
		System.out.println(first.get("Password"));
		first.add("Passwor3", "Usernam3");
		
		first.add("Passwor1", "Usernam1");
		
		first.add("Passwor6", "Usernam7");
		
		System.out.println(first.get("ISUCK"));
		
		System.out.println(first.get("Passwor3"));
		
		System.out.println(first.get("Passwor1"));
		
		System.out.println(first.getSize());
		
	}
}
