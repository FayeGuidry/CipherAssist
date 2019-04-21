package cipherassist.user;

public class VaultItemList 
{
	private VaultItem[] list;
	private int numberOfEntries;
	private final int DEFAULT_CAPACITY = 20;
	private final int MAX_CAPACITY = 100;
	private boolean initialized = false;
	
	public VaultItemList()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public VaultItemList(int initialCapacity)
	{
		if (initialCapacity < DEFAULT_CAPACITY)
			initialCapacity = DEFAULT_CAPACITY;
		else
			checkCapacity(initialCapacity);
		
		VaultItem[] tempList = new VaultItem[initialCapacity + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	}
	
	public void add(VaultItem newEntry)
	{
		checkInitialization();
		list[numberOfEntries + 1] = newEntry;
		++numberOfEntries;
		ensureCapacity();
	}
	
	public void add(int newPosition, VaultItem newEntry)
	{
		//
	}
	
	public VaultItem remove(int givenPosition)
	{
		//
	}
	
	public void clear()
	{
		//
	}
	
	public VaultItem replace(int givenPosition, VaultItem newEntry)
	{
		//
	}
	
	public VaultItem getEntry(int givenPosition)
	{
		//
	}
	
	public VaultItem[] toArray()
	{
		checkInitialization();
		
		VaultItem[] result = new VaultItem[numberOfEntries];
		for (int index = 0; index < numberOfEntries; ++index)
		{
			
		}
	}
	
	public boolean contains(VaultItem anEntry)
	{
		
	}
	
	public int getLength()
	{
		
	}
	
	public boolean isEmpty()
	{
		
	}
}
