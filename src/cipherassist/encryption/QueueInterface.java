package cipherassist.encryption;

public interface QueueInterface<T>
{
	public boolean enqueue(T newEntry);
	
	public T dequeue();
	
	public T poll();
	
	public T element();
	
	public T peek();
	
	public boolean isEmpty();
	
	public void clear();
	
	public int size();
}
