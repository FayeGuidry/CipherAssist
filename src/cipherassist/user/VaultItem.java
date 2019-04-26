package cipherassist.user;

import java.io.Serializable;

public class VaultItem implements Serializable
{
	private static final long serialVersionUID = -1035334641171613865L;
	
	private String data;
	private String filename;
	private String timestamp;
	
	public VaultItem()
	{
		setData("");
		setFilename("");
		setTimestamp("");
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
