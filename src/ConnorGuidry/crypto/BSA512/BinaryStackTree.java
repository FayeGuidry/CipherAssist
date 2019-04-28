package ConnorGuidry.crypto.BSA512;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryStackTree 
{
	//ea. node has an empty stack instantiated upon creation
	
	private BinaryNode root;
	
	public BinaryStackTree()
	{
		root = new BinaryNode();
	}
	
	
	public void setTree(BinaryNode newRoot)
	{
		root = newRoot;
	}
	
	public void postOrderLoad(char[] chars)
	{
		
		int i = 0;
		int j = 0;
		
		while (i < 512)
		{
			PostOrderIterator iter = new PostOrderIterator(root);
			
			while (iter.hasNext())
			{
				Stack<Character> tempStack = iter.next();
				tempStack.push(chars[j]);
				//System.out.println(chars[j]);
				++j;
			}
			
			++i;
		}
	}
	
	public char[] postOrderUnload()
	{
		
		int i = 0;
		int j = 0;
		String resultString = "";
		
		while (i < 512)
		{
			PostOrderIterator iter = new PostOrderIterator(root);
			while (iter.hasNext())
			{
				Stack<Character> tempStack = iter.next();
				resultString += tempStack.pop();
				//System.out.println(resultString);
				++j;
			}
			
			++i;
		}
		
		return resultString.toCharArray();
	}
	
	public void levelOrderLoad(char[] chars) throws InterruptedException
	{
		int i = 0;
		int j = 0;
		
		while (i < 512)
		{
			LevelOrderIterator iter = new LevelOrderIterator(root);
			
			while (iter.hasNext())
			{
				Stack<Character> tempStack = iter.next();
				tempStack.push(chars[j]);
				//System.out.println(j);
				++j;
			}
			
			++i;
		}
	}
	
	public char[] levelOrderUnload() throws InterruptedException
	{
		int i = 0;
		//int j = 0;
		String resultString = "";
		
		while (i < 512)
		{
			LevelOrderIterator iter = new LevelOrderIterator(root);
			while (iter.hasNext())
			{
				Stack<Character> tempStack = iter.next();
				resultString += tempStack.pop();
				//System.out.println(resultString);
				//++j;
			}
			
			++i;
		}
		
		return resultString.toCharArray();
	}
	
	//Just wanna say I'm very proud of this particular method.
	public void addNodes(LinkedBlockingQueue<BinaryNode> levelQ, int nodeCount) throws InterruptedException
	{
		
		if (levelQ.isEmpty())
		{
			--nodeCount;
			
				if ((!root.hasLeftChild()) && (nodeCount != 0))
				{
					BinaryNode leftChild = new BinaryNode();
					root.setLeftChild(leftChild);
					levelQ.put(leftChild);
					--nodeCount;
				}
					
				if ((!root.hasRightChild()) && (nodeCount != 0))
				{
					BinaryNode rightChild = new BinaryNode();
					root.setRightChild(rightChild);
					levelQ.put(rightChild);
					--nodeCount;
				}
			
			addNodes(levelQ, nodeCount);
		}
		
		else
		{
			while (nodeCount != 0)
			{
				BinaryNode newRoot = levelQ.poll();
				
				if (!newRoot.hasLeftChild())
				{
					BinaryNode leftChild = new BinaryNode();
					newRoot.setLeftChild(leftChild);
					levelQ.put(leftChild);
					--nodeCount;
				}
					
				if (!newRoot.hasRightChild())
				{
					BinaryNode rightChild = new BinaryNode();
					newRoot.setRightChild(rightChild);
					levelQ.put(rightChild);
					--nodeCount;
				}
			}
		}
		
	}
	
	public static void generateNodes(BinaryStackTree tree, int innodeCount)
	{
		int nodeCount = innodeCount - 1;
		while (nodeCount > 0)
		{
			if (!tree.getRoot().hasLeftChild())
			{
				BinaryNode newNode = new BinaryNode();
				tree.getRoot().setLeftChild(newNode);
				--nodeCount;
			}
			
			else if ((tree.getRoot().hasLeftChild()) && (!tree.getRoot().hasRightChild()))
			{
				BinaryNode newNode = new BinaryNode();
				tree.getRoot().setRightChild(newNode);
				--nodeCount;
			}
			
			else if ((tree.getRoot().hasLeftChild()) && (tree.getRoot().hasRightChild()))
			{
				BinaryStackTree leftTree = new BinaryStackTree();
				leftTree.setTree(tree.getRoot().getLeftChild());
				--nodeCount;
				BinaryStackTree.generateNodes(leftTree, nodeCount);
				
				
				//if (nodeCount > 0)
				//{
					BinaryStackTree rightTree = new BinaryStackTree();
					rightTree.setTree(tree.getRoot().getRightChild());
					--nodeCount;
					BinaryStackTree.generateNodes(rightTree, nodeCount);
					
				//}
				
			}
			
		}
			
	}
	
	public BinaryNode getRoot()
	{
		return this.root;
	}
	
	private class PostOrderIterator implements Iterator<Stack<Character>>
	{
		private Stack<BinaryNode> nodeStack = new Stack<BinaryNode>();
		
		/*
		public PostOrderIterator()
		{
			//nodeStack = new Stack<BinaryNode>();
			
			//BinaryNode test = new BinaryNode();
			//nodeStack.push(test);
			
			//currentNode = root;
		}
		*/
		
		public PostOrderIterator(BinaryNode root)
		{
			nodeStack = new Stack<BinaryNode>();
			findNextLeaf(root);
		}
		
		@Override
		public boolean hasNext() 
		{
			return !nodeStack.isEmpty();
		}

		private void findNextLeaf(BinaryNode currentNode)
		{
			while (currentNode != null)
			{
				nodeStack.push(currentNode);
				
				if (currentNode.getLeftChild() != null)
				{
					currentNode = currentNode.getLeftChild();
				}
				else
				{
					currentNode = currentNode.getRightChild();
				}
			}
		}
		
		@Override
		public Stack<Character> next() 
		{
			if (!hasNext()) 
			{
				throw new NoSuchElementException("All nodes have been visited.");
			}
			
			BinaryNode nextNode = nodeStack.pop();
			
			if (!nodeStack.isEmpty())
			{
				BinaryNode currentNode = nodeStack.peek();
				
				if (nextNode == currentNode.getLeftChild())
				{
					findNextLeaf(currentNode.getRightChild());
				}
			}
			
			return nextNode.getBitStack();
		}
		
	}
	
	private class LevelOrderIterator implements Iterator<Stack<Character>>
	{
		LinkedBlockingQueue<BinaryNode> nodeQueue;
		BinaryNode levelRoot;
		
		public LevelOrderIterator(BinaryNode root) throws InterruptedException
		{
			nodeQueue = new LinkedBlockingQueue<BinaryNode>();
			this.levelRoot = root;
			reset();
		}
		
		public void reset() throws InterruptedException
		{
			nodeQueue.clear();
			
			if (levelRoot != null)
				nodeQueue.put(levelRoot);
		}
		
		@Override
		public boolean hasNext() 
		{
			return !nodeQueue.isEmpty();
		}
		

		@Override
		public Stack<Character> next() 
		{
			BinaryNode current = (BinaryNode) nodeQueue.poll();
			Stack<Character> bitStack = current.getBitStack();
			
			if (current.getLeftChild() != null)
				try {
					nodeQueue.put(current.getLeftChild());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if (current.getRightChild() != null)
				try {
					nodeQueue.put(current.getRightChild());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return bitStack;
		}
		
	}
}
