package cipherassist.verification;

public class DemoClass 
{
	public static void main(String[] args) 
	{
		HashMap first = new HashMap(); //initialize hashmap
		//username is the key //password is the value
		first.add("Username", "Password"); //first item on bucket 3, index 2
		first.add("Username", "Notebook"); //Cannot add because username is taken
		System.out.println(first.getSize()); //1 account in whole hashmap
		System.out.println(first.get("Username")); //get the password back with given username as the key, value = Password
		first.add("Pasgdbrb", "Usernam1"); // first item on bucket 6, index 5
		first.add("Passwor6", "Usernam7"); // first item on bucket 10, index 9
		first.add("PZ", "Winston"); // first item on bucket 9, index 8
		first.add("Z", "Keith"); // first item on bucket 5, index 4
		first.add("N", "A bug"); // second item on bucket 3, index 2
		first.add("r", "validate"); // third item on bucket 3, index 2
		System.out.println(first.get("NoSuchUsername")); // non exist username
		System.out.println(first.get("Pasgdbrb")); //return the value = Usernam1
		System.out.println(first.get("Passwor6")); //return the value = Usernam7
		System.out.println(first.get("PZ")); //return the value = Winston
		System.out.println(first.getSize()); // return number of account in whole hashmap, should be 6
		System.out.println(first.getBucketSize(2)); // should return 2
		first.changeValue("N", "testing");
		System.out.println(first.remove("N")); // remove the node contain the username = N
		System.out.println(first.get("N")); // since is removed, should return null
		System.out.println(first.get("Username")); // Was checking for bug
		System.out.println(first.getSize()); // return size
		System.out.println(first.getBucketSize(2)); //should return 1
	}
}
