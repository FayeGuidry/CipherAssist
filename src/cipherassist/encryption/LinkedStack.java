package cipherassist.encryption;

public class LinkedStack<T> implements StackInterface<T>
{
	private Node topNode;
	
	public LinkedStack()
	{
		topNode = null;
	}

	@Override
	public void push(T newEntry) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
		
		public getData()
		{
			return this.data;
		}
		
		public setData(T newData)
		{
			this.data = newData;
		}
		
		public getNext()
		{
			return this.next;
		}
		
		public setNext(Node next)
		{
			this.next = next;
		}
	}

}
