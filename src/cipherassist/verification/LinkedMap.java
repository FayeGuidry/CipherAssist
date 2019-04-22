package cipherassist.verification;

public class LinkedMap 
{
	private Node firstNode;
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
	
	public void add(String newData, String newKey)
	{
		Node newNode = new Node(newData, newKey);
		if(isEmpty())
		{
			firstNode = newNode;
		}
		else
		{
			Node currentNode = firstNode;
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
			firstNode = firstNode.next;
			numberOfEntries--;
		}
		return result;
	}
	
	public boolean remove (String anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && currentNode != null)
		{
			if(anEntry.equals(currentNode.getData()))
			{
				found = true;
				currentNode.setData(firstNode.getData());
				remove();
			}
			currentNode = currentNode.next;
		}
		return found;
	}
	
	public void clear()
	{
		while (!isEmpty())
			remove();
	}
	
	public int getFrequencyOf(String anEntry)
	{
		int frequency = 0;
		
		int counter = 0;
		Node currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				frequency++;
			counter++;
			currentNode = currentNode.next;
		}
		return frequency;
	}
	
	public boolean contains(String anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		}
		return found;
	}
	
	public Node get(String key) 
	{
		/*
		 * getting the node by given key
		 * When the key is same as the given key
		 * it return the whole node
		 */
		Node currentNode = firstNode;
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
	private Node getReferenceTo(String anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		}
		return currentNode;
	}
	
	public String[] toArray()
	{
		String[] result = (String[]) new Object[numberOfEntries];
		
		int index = 0;
		Node currentNode = firstNode;
		
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		return result;
	}
	
	public class Node
	{
		private String data;
		private String key;
		private Node next;
		
		public Node()
		{
			this(null, null, null);
		}
		
		public Node(String dataPortion, String key)
		{
			this.data = dataPortion;
			this.key = key;
		}
		
		public Node(String dataPortion, String key, Node next)
		{
			this.data = dataPortion;
			this.key = key;
			this.next = next;
		}
		
		void setData(String data)
		{
			this.data = data;
		}
		
		String getData()
		{
			return data;
		}
		
		void setKey(String key)
		{
			this.key = key;
		}
		
		String getKey()
		{
			return key;
		}
		
		Node getNext()
		{
			return next;
		}
		
		void setNext(Node next)
		{
			this.next = next;
		}
	}	
}
