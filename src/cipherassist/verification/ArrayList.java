package cipherassist.verification;

public class ArrayList<T>
{
	// simple array list implementation
	private int INITIAL_CAPACITY = 20;
	private T[] itemlist;
	private int numberOfItems;
	
	public ArrayList()
	{
		this(0);
	}
	
	public ArrayList(int num)
	{
		itemlist = (T[]) new Object[INITIAL_CAPACITY];
		this.numberOfItems = 0;
	}
	
	public boolean isEmpty()
	{
		return numberOfItems == 0;
	}
	
	public boolean isFull()
	{
		return true;
	}
	
	public void itemListResize()
	{
		
	}
	
	public void add(T newItem)
	{
		if(isFull())
		{
			itemListResize();
		}
		
		itemlist[numberOfItems] = newItem;
		numberOfItems++;
	}
	
	public T remove()
	{
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray()
	{
		T[] result = (T[]) new Object[numberOfItems];
		for(int i = 0; i < numberOfItems; i++)
		{
			result[i] =  itemlist[i];
		}
		return result;
	}
}
