package cipherassist.encryption;

public class ArrayStack<T> implements StackInterface<T>
{
	private T[] aStack;
	private int numOfEntries;
	private static int INITIAL_CAPACITY;
	
	public ArrayStack()
	{
		this(INITIAL_CAPACITY);
	}
	
	public ArrayStack(int capacity)
	{
		aStack = (T[]) new Object[capacity];
	}

	public void push(T newEntry) 
	{
		
		
	}
	
	public T pop() 
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
}
