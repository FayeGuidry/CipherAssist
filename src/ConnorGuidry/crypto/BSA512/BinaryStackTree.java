package ConnorGuidry.crypto.BSA512;

import java.util.Iterator;
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
				BinaryStackTree.generateNodes(leftTree, nodeCount);
				
				BinaryStackTree rightTree = new BinaryStackTree();
				rightTree.setTree(tree.getRoot().getRightChild());
				BinaryStackTree.generateNodes(rightTree, nodeCount);
			}
			
		}
			
	}
	
	public BinaryNode getRoot()
	{
		return this.root;
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
	
	private class PostOrderIterator implements Iterator<Stack<Character>>
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
