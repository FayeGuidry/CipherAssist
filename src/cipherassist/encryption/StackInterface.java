package cipherassist.encryption;

public interface StackInterface 
{
	public interface StackADT <T>
	{
		public void push(T newEntry);
		
		public T pop();
		
		public T peek();
		
		public boolean isEmpty();
	
		public void clear();
	}
}
