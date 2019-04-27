package cipherassist.encryption;

public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode;
	
	public LinkedStack()
	{
		topNode = null;
	}

	public void push(T newEntry) 
	{
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
		
	}

	public T pop() 
	{
		T top = peek();
		if(topNode != null)
			topNode = topNode.getNext();
		return top;
	}

	public T peek() 
	{
		T top = null;
		if(topNode != null)
			top = topNode.getData();
		return top;
	}

	public boolean isEmpty() 
	{
		return topNode == null;
	}

	public void clear() 
	{
		topNode = null;
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
		
		public Node(T data, Node next)
		{
			this.data = data;
			this.next = next;
		}
		
		public T getData()
		{
			return this.data;
		}
		
		@SuppressWarnings("unused")
		public void setData(T newData)
		{
			this.data = newData;
		}
		
		public Node getNext()
		{
			return this.next;
		}
		
		@SuppressWarnings("unused")
		public void setNext(Node next)
		{
			this.next = next;
		}
	}

}
