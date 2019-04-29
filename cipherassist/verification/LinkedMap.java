package cipherassist.verification;

import java.io.Serializable;

public class LinkedMap  implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9033964336606642010L;
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
		/*
		 * remove the first node of the linked list
		 */
		String result = null;
		if(!isEmpty())
		{
			result = firstNode.getData();
			firstNode = firstNode.getNext();
			numberOfEntries--;
		}
		return result;
	}
	
	public String remove (String key)
	{
		/*
		 * given a key
		 * if the key is found, remove the node where key is found
		 * redirect the currentNode to the next existence node or set next to null
		 */
		String result = null;
		HashNode currentNode = firstNode;
		while(currentNode != null)
		{
			if(key.equals(currentNode.getKey()))
			{
				if(currentNode == firstNode)
				{
					remove();
				}
				else 
				{
					currentNode.setData(firstNode.getData());
					currentNode.setKey(firstNode.getKey());
					System.out.println(currentNode.getData());
					remove();
				}
			}
			currentNode = currentNode.getNext();
		}
		return result;
	}
	
	public void changeNodeValue(String key, String newValue)
	{
		HashNode currentNode = firstNode;
		boolean keyFound = false;
		while(currentNode.getNext() != null)
		{
			if(key.equals(currentNode.getKey()))
			{
				keyFound = true;
				currentNode.setData(newValue);
				
			}
			currentNode = currentNode.getNext();
		}
		if(keyFound == true)
			System.out.println("Password change successful");
		else
			System.out.println("Not Found");
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
	
	public class HashNode implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 6331780365384687493L;
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
