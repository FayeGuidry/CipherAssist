package cipherassist.encryption;

public class LinkedQueue<T> implements QueueInterface<T>
{
	private Node firstNode;
	private Node lastNode;
	private int numOfEntries;
	
	public LinkedQueue()
	{
		this.firstNode = null;
		this.lastNode = null;
		this.numOfEntries = 0;
	}
	
	public boolean enqueue(T newEntry) 
	{
		boolean added = false;
		Node newNode = new Node(newEntry);
		
		if(isEmpty())
		{
			firstNode = newNode;
			lastNode = newNode;
			added = true;
			numOfEntries++;
		}
		else
		{
			lastNode.setNext(newNode);
			lastNode = newNode;
			added = true;
			numOfEntries++;
		}
		
		return added;
	}

	public T dequeue() 
	{
		T front = null;
		
		if(!isEmpty())
		{
			front = firstNode.getData();
			firstNode = firstNode.getNext();
			
			if(firstNode == null)
			{
				lastNode = null;
			}
			numOfEntries--;
		}
		return front;
	}

	public T getFront() 
	{
		T front = null;
		if(!isEmpty())
			front = firstNode.getData(); 
		return front;
	}

	public boolean isEmpty() 
	{
		return (firstNode == null) && (lastNode == null);
	}

	public void clear() 
	{	
		firstNode = null;
		lastNode = null;
		numOfEntries = 0;
	}

	public int getSize() 
	{
		return numOfEntries;
	}

	
	private class Node
	{
		private T data;
		private Node next;
		
		@SuppressWarnings("unused")
		public Node()
		{
			this(null, null);
		}
		
		public Node(T data)
		{
			this.data = data;
			this.next = null;
		}
		
		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		
		public T getData()
		{
			return data;
		}
		
		@SuppressWarnings("unused")
		public void setData(T newData)
		{
			this.data = newData;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node next)
		{
			this.next = next;
		}
	}
}
