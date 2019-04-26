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
	
	
	
	

}
