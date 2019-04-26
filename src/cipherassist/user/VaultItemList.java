package cipherassist.user;

import java.util.Arrays;

public class VaultItemList 
{
	private VaultItem[] list;
	private int numberOfEntries;
	private final static int DEFAULT_CAPACITY = 20;
	private final static int MAX_CAPACITY = 100;
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
		checkInitialization();
		
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1))
		{
			if ((newPosition <= numberOfEntries))
				makeRoom(newPosition);
			list[newPosition] = newEntry;
			++numberOfEntries;
			ensureCapacity();
		}
		else
			throw new IndexOutOfBoundsException(
					"Given position of add's new entry is out of bounds.");
	}
	
	public VaultItem remove(int givenPosition)
	{
		checkInitialization();
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			VaultItem result = list[givenPosition];
			
			if (givenPosition < numberOfEntries)
				removeGap(givenPosition);
			
			--numberOfEntries;
			return result;
		}
		else
			throw new IndexOutOfBoundsException(
					"Illegal position given to remove operation.");
	}
	
	public void clear()
	{
		Arrays.fill(list, null);
	}
	
	public VaultItem replace(int givenPosition, VaultItem newEntry)
	{
		checkInitialization();
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			VaultItem originalEntry = list[givenPosition];
			list[givenPosition] = newEntry;
			return originalEntry;
		}
		else
			throw new IndexOutOfBoundsException(
					"Illegal position given to replace operation");
	}
	
	public VaultItem getEntry(int givenPosition)
	{
		checkInitialization();
		
		if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
		{
			assert !isEmpty();
			return list[givenPosition];
		}
		else
			throw new IndexOutOfBoundsException(
					"Illegal position given to getEntry operation");
		
	}
	
	public VaultItem[] toArray()
	{
		checkInitialization();
		
		VaultItem[] result = new VaultItem[numberOfEntries];
		for (int index = 0; index < numberOfEntries; ++index)
		{
			result[index] = list[index + 1];
		}
		
		return result;
	}
	
	public boolean contains(VaultItem anEntry)
	{
		checkInitialization();
		
		boolean found = false;
		int index = 1;
		
		while (!found && (index <= numberOfEntries))
		{
			if (anEntry.equals(list[index]))
				found = true;
			++index;
		}
		
		return found;
	}
	
	public int getLength()
	{
		return numberOfEntries;
	}
	
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}
	
	private void ensureCapacity()
	{
		int capacity = list.length - 1;
		if (numberOfEntries >= capacity)
		{
			int newCapacity = 2 * capacity;
			checkCapacity(newCapacity);
			list = Arrays.copyOf(list, newCapacity + 1);
		}
	}

	private void makeRoom(int newPosition)
	{
		assert (newPosition >= 1) && (newPosition <= numberOfEntries + 1);
		
		int newIndex = newPosition;
		int lastIndex = numberOfEntries;
		
		for (int index = lastIndex; index >= newIndex; --index)
		{
			list[index + 1] = list[index];
		}
	}
	
	private void removeGap(int givenPosition)
	{
		assert (givenPosition >= 1) && (givenPosition < numberOfEntries);
		
		int removedIndex = givenPosition;
		int lastIndex = numberOfEntries;
		
		for (int index = removedIndex; index < lastIndex; ++index)
		{
			list[index] = list[index + 1];
		}
	}
	
	private void checkInitialization()
	{
		if (!initialized)
        {
            throw new SecurityException ("VaultItemList object is not initialized properly.");
        }
	}
	
	private void checkCapacity(int newCapacity) 
	{
		if (newCapacity > MAX_CAPACITY)
        {
            throw new SecurityException ("VaultItemList object set beyond MAX_CAPACITY.");
        }
	}
	
}
