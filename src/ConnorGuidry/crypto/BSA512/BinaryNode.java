package ConnorGuidry.crypto.BSA512;

import java.util.Stack;

public class BinaryNode 
{
	private Stack<Character> bitStack;
	private BinaryNode leftChild;
	private BinaryNode rightChild;
	
	public BinaryNode()
	{
		bitStack = new Stack<Character>();
		
		leftChild = null;
		rightChild = null;
	}
	
	public BinaryNode(char bitChar)
	{
		bitStack = new Stack<Character>();
		bitStack.push(bitChar);
		
		leftChild = null;
		rightChild = null;
	}
	
	public BinaryNode(char bitChar, BinaryNode newLeftChild, BinaryNode newRightChild)
	{
		bitStack = new Stack<Character>();
		bitStack.push(bitChar);
		
		leftChild = newLeftChild;
		rightChild = newRightChild;
		
	}
	
	public char popBit()
	{
		return bitStack.pop();
	}
	
	public void pushBit(char bit)
	{
		bitStack.push(bit);
	}
	
	public BinaryNode getLeftChild()
	{
		return leftChild;
	}
	
	public void setLeftChild(BinaryNode newLeftChild)
	{
		leftChild = newLeftChild;
	}
	
	public boolean hasLeftChild()
	{
		return leftChild != null;
	}
	
	public BinaryNode getRightChild()
	{
		return rightChild;
	}
	
	public void setRightChild(BinaryNode newRightChild)
	{
		rightChild = newRightChild;
	}
	
	public boolean hasRightChild()
	{
		return rightChild != null;
	}
	
	public boolean isLeaf()
	{
		return (leftChild == null) && (rightChild == null);
	}
	
	public int getNumberOfNodes()
	{
		int leftNumber = 0;
		int rightNumber = 0;
		
		if (leftChild != null)
			leftNumber = leftChild.getNumberOfNodes();
		
		if (rightChild != null)
			rightNumber = rightChild.getNumberOfNodes();
		
		return 1 + leftNumber + rightNumber;
	}
	
	public int getHeight()
	{
		return getHeight(this);
	}
	
	private int getHeight(BinaryNode node)
	{
		int height = 0;
		
		if (node != null)
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		
		return height;
	}
	
}
