package cipherassist.encryption;

public class LinkedQueue<T> implements QueueInterface<T>
{
	private Node firstNode;
	private Node lastNode;
	
	public LinkedQueue()
	{
		this.firstNode = null;
		this.lastNode = null;
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
		}
		else
		{
			lastNode.setNext(newNode);
			lastNode = newNode;
			added = true;
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
		}
		return front;
	}

	public T poll() 
	{
		
		return null;
	}

	public T element() 
	{
		
		return null;
	}

	public T peek() 
	{
		
		return null;
	}

	public boolean isEmpty() 
	{
		return firstNode == null && lastNode == null;
	}

	public void clear() 
	{	
		
	}

	public int size() 
	{
		return 0;
	}

	
	private class Node
	{
		private T data;
		private Node next;
		
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
