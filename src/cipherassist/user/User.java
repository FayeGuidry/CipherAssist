package cipherassist.user;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = 8167391005507975683L;
	
	private Vault vault = new Vault();
	private String password = "";
	private String username = "";
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getUsername()
	{
		return username;
	}

	public Vault getVault() 
	{
		return vault;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}

	public void setVault(Vault vault) 
	{
		this.vault = vault;
	}

}
