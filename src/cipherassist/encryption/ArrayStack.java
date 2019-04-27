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
		numOfEntries++;
	}
	
	private void resizeArray()
	{
		if (isFull()) //if array is full,
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
		T top = null;
		
		if(!isEmpty())
		{
			top = aStack[topIndex];
			aStack[topIndex] = null;
			topIndex--;
		}
		return top;
	}
	
	public T peek() 
	{
		T top = null;
		if(!isEmpty())
			top = aStack[topIndex];
		
		return top;
	}
	
	public boolean isEmpty() 
	{
		return numOfEntries == 0;
	}
	
	private boolean isFull()
	{
		return topIndex == aStack.length - 1;
	}
	
	public void clear() 
	{
		
		
	}
}
