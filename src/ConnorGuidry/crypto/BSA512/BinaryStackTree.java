package ConnorGuidry.crypto.BSA512;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

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
	
	public void levelOrderLoad(char[] chars)
	{
		
	}
	
	public char[] levelOrderUnload()
	{
		return null;
	}
	
	
	public static void generateNodes(BinaryStackTree tree, int nodeCount)
	{
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
				
				
				if (nodeCount > 0)
				{
					BinaryStackTree rightTree = new BinaryStackTree();
					rightTree.setTree(tree.getRoot().getRightChild());
					--nodeCount;
					BinaryStackTree.generateNodes(rightTree, nodeCount);
					
				}
				
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

		@Override
		public boolean hasNext() 
		{
			return false;
		}

		@Override
		public Stack<Character> next() 
		{
			return null;
		}
		
	}
}
