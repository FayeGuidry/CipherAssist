package cipherassist.user;

public class Accounts 
{
	public static User createUser(String username, String password)
	{
		User newUser = new User(username, password);
		return newUser;
	}
	
	public static void deleteUser(User user)
	{
		//delete serialized file in program directory, then log out
	}
}
