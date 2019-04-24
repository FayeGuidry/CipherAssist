package cipherassist.verification;

public class LinkedMap 
{
	private HashNode firstNode;
	private int numberOfEntries;
	
	public LinkedMap()
	{
		//System.out.println("Linked Map made");
		firstNode = null;
		numberOfEntries = 0;
	}
	
	public int getCurrentSize()
	{
		return numberOfEntries;
	}
	
	public boolean isEmpty()
	{
		return firstNode == null;
	}
	
	public HashNode getFirst()
	{
		if(!isEmpty())
			return firstNode;
		else
			return null;
	}
	
	public void add(String newKey, String newData)
	{
		HashNode newNode = new HashNode(newKey, newData);
		if(isEmpty())
		{
			firstNode = newNode;
		}
		else
		{
			HashNode currentNode = firstNode;
			while(currentNode.getNext() != null)
			{
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
		}
		numberOfEntries++;
	}
	
	public String remove()
	{
		String result = null;
		if(firstNode != null)
		{
			result = firstNode.getData();
			firstNode = firstNode.getNext();
			numberOfEntries--;
		}
		return result;
	}
	
	public String remove (String key)
	{
		String result = null;
		HashNode currentNode = firstNode;
		while(currentNode != null)
		{
			if(key.equals(currentNode.getKey()))
			{
				currentNode.setData(firstNode.getData());
				result = remove();
			}
			currentNode = currentNode.getNext();
		}
		return result;
	}
	
	public void clear()
	{
		while (!isEmpty())
			remove();
	}
	
	public int getFrequencyOf(String key)
	{
		int frequency = 0;
		
		int counter = 0;
		HashNode currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null))
		{
			if (key.equals(currentNode.getKey()))
				frequency++;
			counter++;
			currentNode = currentNode.next;
		}
		return frequency;
	}
	
	public boolean contains(String key)
	{
		boolean found = false;
		HashNode currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (key.equals(currentNode.getKey()))
				found = true;
			else
				currentNode = currentNode.getNext();
		}
		return found;
	}
	
	public HashNode getHashNode(String key) 
	{
		/*
		 * getting the node by given key
		 * When the key is same as the given key
		 * it return the whole node
		 */
		HashNode currentNode = firstNode;
		while(currentNode != null)
		{
			if(currentNode.getKey().equals(key))
			{
				return currentNode;
			}
			currentNode = currentNode.getNext();
		}
		return null;
	}
	
	@SuppressWarnings("unused")
	private HashNode getReferenceTo(String anEntry)
	{
		boolean found = false;
		HashNode currentNode = firstNode;
		
		while(!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
				found = true;
			else
				currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	
	public String[] toArray()
	{
		String[] result = (String[]) new Object[numberOfEntries];
		
		int index = 0;
		HashNode currentNode = firstNode;
		
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNext();
		}
		return result;
	}
	
	public class HashNode
	{
		private String data;
		private String key;
		private HashNode next;
		
		public HashNode()
		{
			this(null, null);
		}
		
		public HashNode(String key, String dataPortion)
		{
			this.data = dataPortion;
			this.key = key;
		}
		
		public HashNode(String dataPortion, String key, HashNode next)
		{
			this.data = dataPortion;
			this.key = key;
			this.next = next;
		}
		
		public void setData(String data)
		{
			this.data = data;
		}
		
		public String getData()
		{
			return data;
		}
		
		public void setKey(String key)
		{
			this.key = key;
		}
		
		public String getKey()
		{
			return key;
		}
		
		public HashNode getNext()
		{
			return next;
		}
		
		public void setNext(HashNode next)
		{
			this.next = next;
		}
	}	
}
