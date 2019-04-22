package cipherassist.verification;

public class LinkedList<T>
{
	private Node firstNode;
	private int numberOfEntries;

	public LinkedList() 
	{
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

	public boolean add(T newEntry)
	{
		boolean result = false;
		// Node newNode; Just a reference variable.
		// Node newNode = new Node(newEntry, firstNode);
		Node newNode = new Node(newEntry);
		newNode.nextNode = firstNode;

		firstNode = newNode;
		numberOfEntries++;
		result = true;

		return result;
	}

	public T remove() 
	{
		T result = null;
		if (firstNode != null) 
		{
			result = firstNode.getData();
			firstNode = firstNode.nextNode;
			numberOfEntries--;
		}
		return result;
	}

	public boolean remove(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && currentNode != null) 
		{
			if (anEntry.equals(currentNode.getData())) 
			{
				found = true;
				currentNode.setData(firstNode.getData());
				remove();
			}
			currentNode = currentNode.nextNode;
		}
		return found;
	}

	public void clear() 
	{
		while (!isEmpty())
			remove();
	}

	public int getFrequencyOf(T anEntry)
	{
		int frequency = 0;

		int counter = 0;
		Node currentNode = firstNode;
		while ((counter < numberOfEntries) && (currentNode != null)) 
		{
			if (anEntry.equals(currentNode.data))
				frequency++;
			counter++;
			currentNode = currentNode.nextNode;
		}
		return frequency;
	}

	public boolean contains(T anEntry) 
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) 
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.nextNode;
		}
		return found;
	}

	public Node getReferenceTo(T anEntry) 
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) 
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.nextNode;
		}
		return currentNode;
	}

	public T[] toArray() 
	{
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;

		while ((index < numberOfEntries) && (currentNode != null)) 
		{
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.nextNode;
		}
		return result;
	}
	
	public Node getFirst()
	{
		return firstNode;
	}

	public boolean combine(LinkedList<T> aBag) 
	{
		boolean result = false;
		Node currentNode = this.firstNode;
		this.numberOfEntries += aBag.numberOfEntries;
		while (currentNode.getNextNode() != null) 
		{
			currentNode = currentNode.nextNode;
		}
		currentNode.nextNode = aBag.firstNode;
		return result;
	}

	public boolean splice(int index, LinkedList<T> aBag) 
	{
		boolean result = false;
		Node currentNode = this.firstNode;
		this.numberOfEntries += aBag.numberOfEntries;
		for (int i = 0; i < index; i++) 
		{
			currentNode = currentNode.getNextNode();
		}
		Node currentNode2 = aBag.firstNode;
		while (currentNode2.getNextNode() != null) 
		{
			currentNode2 = currentNode2.nextNode;
		}
		currentNode2.nextNode = currentNode.nextNode;
		currentNode.nextNode = aBag.firstNode;
		result = true;
		return result;
	}

	private class Node 
	{
		private T data;
		private Node nextNode;

		private Node() 
		{
			this(null, null);
		}
		
		private Node(T anEntry) 
		{
			this(anEntry, null);
		}

		private Node(T dataPortion, Node nextNode) 
		{
			this.data = dataPortion;
			this.nextNode = nextNode;
		}

		private void setData(T data) 
		{
			this.data = data;
		}

		private T getData() 
		{
			return data;
		}

		private Node getNextNode() 
		{
			return nextNode;
		}

		@SuppressWarnings("unused")
		private void setNextNode(Node nextNode)
		{
			this.nextNode = nextNode;
		}
	}
}