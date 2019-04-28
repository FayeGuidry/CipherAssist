package cipherassist.encryption;

public class LinkedQueue<T> implements QueueInterface<T>
{
	private Node firstNode;
	private Node lastNode;
	
	public boolean add(T newEntry) 
	{
		
		return false;
	}

	public boolean offer(T newEntry) 
	{
		
		return false;
	}

	public T remove() 
	{
		
		return null;
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
		
		return false;
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
