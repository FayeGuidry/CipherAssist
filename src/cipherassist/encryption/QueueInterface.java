package cipherassist.encryption;

public interface QueueInterface<T>
{
	public boolean add(T newEntry);
	
	public boolean offer(T newEntry);
	
	public T remove();
	
	public T poll();
	
	public T element();
	
	public T peek();
	
	public boolean isEmpty();
	
	public void clear();
	
	public int size();
}
