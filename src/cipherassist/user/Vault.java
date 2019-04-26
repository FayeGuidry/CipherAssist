package cipherassist.user;

import java.io.Serializable;

public class Vault implements Serializable {

	private static final long serialVersionUID = 4629219938307023396L;
	
	VaultItemList itemList = new VaultItemList();
	
	public VaultItemList getVaultItemList()
	{
		return this.itemList;
	}
	
	public void setVaultItemList(VaultItemList itemList)
	{
		this.itemList = itemList;
	}
	
}
