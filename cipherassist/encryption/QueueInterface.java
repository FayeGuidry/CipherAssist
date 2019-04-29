package cipherassist.encryption;

public interface QueueInterface<T>
{
	public boolean enqueue(T newEntry);
	
	public T dequeue();
	
	public T getFront();
	
	public boolean isEmpty();
	
	public void clear();
	
	public int getSize();
}
