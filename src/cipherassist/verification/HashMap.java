package cipherassist.verification;

import cipherassist.verification.LinkedMap.Node;

public class HashMap 
{
	private int capacity = 10; // number of buckets
	private LinkedMap[] numBuckets; // An array of linked list
	private int size; //Keep track on entries
	
	public HashMap() //initialize constructor
	{
		this.numBuckets = new LinkedMap[capacity]; //initialize the size of the array
		
		for(int i = 0; i < capacity; i++)
		{
			numBuckets[i] = new LinkedMap(); //create linked list object for each array[i]
		}
	}
	
	public int getSize()
	{
		return size; //return number of entries
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public int makeHash(String key)
	{
		/*
		 * A simple hash algorithm
		 * Caesar Cipher
		 */
		int hash = 0;
		for(int i = 0; i < key.length(); i++)
		{
			int x = key.charAt(i);
			if(x >= 65 && x <= 90)
			{
				hash += (((x-65)+20)%26)+65;
			}
			else if(x >= 97 && x <= 122)	
			{
				hash += (((x-65)+20)%26)+65;
			}
			else
				hash = 9;
		}
		return hash; 
	}
	
	public int getBucketIndex(String key)
	{
		/*
		 * get the index number by modulo the array size
		 */
		int hashCod = makeHash(key);
		return hashCod % numBuckets.length;
	}

	public void add(String key, String value)
	{
		/*
		 * adding a new node to an array
		 */
		int index = getBucketIndex(key);
		System.out.println(index);
		numBuckets[index].add(key, value);
		size++;
	}
	
	public String get(String key)
	{
		/*
		 * getting the value with a given key
		 */
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
		/*
		 * removing the value with a given key
		 */
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
}
