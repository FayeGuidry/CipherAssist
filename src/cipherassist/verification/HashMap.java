package cipherassist.verification;

import cipherassist.verification.LinkedMap.Node;

public class HashMap 
{
	private LinkedMap[] numBuckets;
	private int capacity = 10;
	//private LinkedMap list = new LinkedMap();
	private int size;
	
	public HashMap()
	{
		this.numBuckets = new LinkedMap[capacity];
	}
	
	public int getSize()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int getBucketIndex(String key)
	{
		int hashCod = key.length();
		if(hashCod < 0)
			hashCod = hashCod + numBuckets.length;
		return hashCod%numBuckets.length;
	}
	
	public void add(String key, String value)
	{
		int index = getBucketIndex(key);
		System.out.println(index);
		numBuckets[index].add(value, key);
		size++;
	}
	
	public String get(String key)
	{
		int index = getBucketIndex(key);
		Node head = numBuckets[index].get(key);
		while(head != null)
		{
			if(head.getKey().equals(key))
			{
				return head.getData();
			}
			head = head.getNext();
		}
		return null;
	}	

	public String remove(String key)
	{
		int index = getBucketIndex(key);
		Node head = numBuckets[index].get(key);
		while(head != null)
		{
			if(head.getKey().equals(key))
			{
				String val = head.getData();
				head.setNext(head.getNext());
				size--;
				return val;
			}
			head.getNext();
		}
		return null;
	}
	
	/*private class HashNode
	{
		private String value;
		private String key;
		private HashNode next;
		
		private HashNode()
		{
			this(null, null);
		}
		
		private HashNode(String key, String value)
		{
			this.key = key;
			this.value = value;
		}

		public String getValue() 
		{
			return value;
		}

		public void setValue(String value) 
		{
			this.value = value;
		}

		public String getKey() 
		{
			return key;
		}

		public void setKey(String key) 
		{
			this.key = key;
		}

		public HashNode getNext() 
		{
			return next;
		}

		public void setNext(HashNode next) 
		{
			this.next = next;
		}	
	}*/
}
