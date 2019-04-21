package cipherassist.verification;

public class DemoClass 
{
	public static void main(String[] args) 
	{
		Map<String, String> first = new Map<String, String>();
		
		first.add("Password", "Username");
		
		first.add("Password2", "Username2");
		
		System.out.println(first.get("Password"));
		
		
	}
}
