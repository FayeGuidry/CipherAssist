package cipherassist.user;

import java.io.Serializable;

public class Vault implements Serializable {

	private static final long serialVersionUID = 4629219938307023396L;
	
	VaultItem item1 = new VaultItem();
	VaultItem item2 = null;
	VaultItem item3 = null;
	
	public VaultItem[] vaultItems = new VaultItem[] { item1, item2, item3 };
	
}
