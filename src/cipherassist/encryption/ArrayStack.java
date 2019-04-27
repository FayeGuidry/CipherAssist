package cipherassist.encryption;

public class ArrayStack<T> implements StackInterface<T>
{
	private T[] aStack;
	private int numOfEntries;
	private int topIndex;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	
	public ArrayStack()
	{
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	public ArrayStack(int capacity)
	{
		// the cast is safe because the new array contains null entries
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[capacity];
		aStack = tempStack;
		topIndex = -1;
		numOfEntries = 0;
	}

	public void push(T newEntry) 
	{
		resizeArray();
		topIndex++;
		aStack[topIndex] = newEntry;
		
	}
	
	private void resizeArray()
	{
		if (topIndex == aStack.length - 1) //if array is full,
		{
			//double size of array
			@SuppressWarnings("unchecked")
			T[] aNewStack = (T[]) new Object[2 * aStack.length];
			for(int i = 0; i < aStack.length; i++)
			{
				aNewStack[i] = aStack[i];
			}
			aStack = aNewStack;
		}		
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
