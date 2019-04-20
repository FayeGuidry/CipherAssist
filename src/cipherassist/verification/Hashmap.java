package cipherassist.verification;

public class Hashmap <K, V>
{
	//Test comment
	/**hash map example**/
	
	private mapNode<K, V>[] buckets;
	private static final int INITIAL_CAPACITY = 9; //81
	private int size = 0;
	
	public Hashmap()
	{
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public Hashmap(int capacity)
	{
		this.buckets = new mapNode[capacity];
	}
	
	public int getBucketSize()
	{
		return INITIAL_CAPACITY;
	}
	
	public int getHash(K key)
	{
		int hashcode = Integer.parseInt((String) key);
		return hashcode;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void add(K key, V data)
	{
		mapNode<K, V> newNode = new mapNode<>(key, data, null);
		
		int bucket = getHash(key) % getBucketSize();
		
		mapNode<K, V> existing = buckets[bucket];
		if(existing == null)
		{
			buckets[bucket] = newNode;
			size++;
		}
		else
		{
			while(existing.next != null)
			{
				if(existing.getKey().equals(key))
				{
					existing.setData(data);
					return;
				}
				existing = existing.getNext();
			}
		}
		
		if(existing.getKey().equals(key))
		{
			existing.setData(data);
		}
		else
		{
			existing = existing.getNext();
			existing.setData(data);
			size++;
		}
	}
	
	public V get(K key)
	{
		mapNode<K, V> bucket = buckets[getHash(key) % getBucketSize()];
		
		while(bucket != null)
		{
			if(bucket.getKey().equals(key))
			{
				return bucket.getData();
			}
			bucket = bucket.getNext();
		}
		return null;
	}
	
	public boolean notNull()
	{
		return this.buckets == null;
	}
	
	public static boolean equals(int x, int y)
	{
		return x == y;
	}
	
	public boolean equals(V data, V input)
	{
		if(data.equals(input))
			return true;
		else
			return false;
	}
	
	private class mapNode<K, V>
	{
		final K key;
		private V data;
		private mapNode<K, V> next;
		
		public mapNode(K key, V data, mapNode<K, V> next)
		{
			this.key = key;
			this.data = data;
			this.next = next;
		}

		public V getData() {
			return data;
		}

		public void setData(V data) {
			this.data = data;
		}

		public mapNode<K, V> getNext() {
			return next;
		}

		public void setNext(mapNode<K, V> next) {
			this.next = next;
		}

		public K getKey() {
			return key;
		}
	
	}
}
