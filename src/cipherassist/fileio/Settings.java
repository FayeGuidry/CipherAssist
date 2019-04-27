package cipherassist.fileio;

import java.io.Serializable;

public class Settings implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -795295003196432714L;
	public boolean lightmodeEnabled = false;
	
	public void setLightmodeEnabled(boolean setting)
	{
		lightmodeEnabled = setting;
	}
	
	public boolean isLightmodeEnabled()
	{
		return lightmodeEnabled;
	}
}
