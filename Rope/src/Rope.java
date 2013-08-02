//The rope splits up a long string so insertion deletion and random
//access can be done efficiently

//Each node contains a short string

//Each node has a weight equal to the length of its string
//plus the sum of all the weights in the left subtree

//Operations include index, split, concat, insert, delete, report
public class Rope 
{
	private Node root;
	public Rope()
	{
		
	}
	
	//Index returns the character at position i
	//Runs in O(log n) n being the length of the rope
	
	//Given the position of the character i, start at the root, given the weight of a node.
	//If the weight is greater than or equal to i and a left child exists, go to the left child.
	//If the weight is greater than or equal to i and no left child exists, return the node's string
	//at character position i
	//If the weight is less than the given i then subtract the weight from i (i = i-weight) and go
	//to the right child
	
	//recursive method, private because the non-recursive method should be the one starting the call
	
	private char index(int i, Node n)
	{
		//Only call the recursive method to get weight once, recursion kills performance
		int weight = n.getWeight();
		if(weight< i)
		{
			i = i-weight;
			return index(i, n.getRight());
		}
		else
		{
			if(n.getLeft() != null)
			{
				return index(i, n.getLeft());
			}
			else
			{
				return (n.getString().charAt(i));
			}
		}
	}
	
	//Split: (i,s) splits s into two new strings s1 and s2, s1 = c1...ci, s2=ci+1...clast
	
	
	//Call the recursive method starting at the root with i
	
	//I seperate the recursive method from the method I want users to use to allow for easier 
	//use and easier for me to implement and understand
	public char getChar(int index)
	{
		return index(index, root);
	}
}
