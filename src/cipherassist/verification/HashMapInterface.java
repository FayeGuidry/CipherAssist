package cipherassist.verification;

public interface HashMapInterface <K, V>
{
	public V put(K key, V value);
	
	public V remove(K key, V value);
	
	public V get(K key);
	
	public boolean containsKey(K key);
	
	public boolean containsValue(V value);
	
	public boolean isEmpty();
	
	public int getSize();
	
	public void clear();

}
