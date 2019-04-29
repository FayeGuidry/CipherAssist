package cipherassist.verification;

import java.io.Serializable;

import cipherassist.verification.LinkedMap.HashNode;


public class Hashmap implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5485340010277239481L;
	// simple HashMap implementation
	private int capacity = 10; // number of buckets
	private LinkedMap[] numBuckets; // An array of linked list
	private int size; //Keep track on entries
	
	public Hashmap() //initialize constructor
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
	
	public int getBucketSize(int index)
	{
		return numBuckets[index].getCurrentSize();
	}
	
	private int makeHash(String key)
	{
		/* @param the key, the username
		 * A simple hash algorithm
		 * Caesar Cipher
		 */
		int hash = 0;
		for(int i = 0; i < key.length(); i++)
		{
			int x = key.charAt(i);
			if(x >= 65 && x <= 90)
			{
				hash += ( ( ( x - 65 ) + 20 ) % 26 ) + 65;
			}
			else if(x >= 97 && x <= 122)	
			{
				hash += ( ( ( x - 65 ) + 20 ) % 26 ) + 65;
			}
			else
				hash = 9;
		}
		return hash; 
	}
	
	private int getBucketIndex(String key)
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
		 * decline if the duplicate keys are found
		 */
		int index = getBucketIndex(key);
		//System.out.println(index);
		HashNode currentNode = numBuckets[index].getFirst();
		while(currentNode != null)
		{
			if(currentNode.getKey().equals(key))
			{
				System.out.println("Username is taken\nPlease choose again");
				break;
			}
			currentNode = currentNode.getNext();
		}
		if(currentNode == null)
		{
			numBuckets[index].add(key, value);
			size++;
		}
	}
	
	public String get(String key)
	{
		/*
		 * getting the value with a given key
		 */
		int index = getBucketIndex(key);
		HashNode head = numBuckets[index].getHashNode(key);
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
	
	public boolean hasThisUsername(String username)
	{
		boolean found = false;
		int index = getBucketIndex(username);
		HashNode head = numBuckets[index].getHashNode(username);
		
		while (head != null && found == false)
		{
			if(head.getKey().equals(username))
			{
				found = true;
			}
			head = head.getNext();
		}
		
		return found; 
	}

	public String remove(String key)
	{
		/*
		 * removing the value with a given key
		 */
		String result = "";
		
		if (hasThisUsername(key))
		{
			int index = getBucketIndex(key);
			result = numBuckets[index].remove(key);
			size--;
		}
		
		return result;
	}
	
	public void changeValue(String key, String newValue)
	{
		int index = getBucketIndex(key);
		numBuckets[index].changeNodeValue(key, newValue);
	}
}
