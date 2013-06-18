//Holds methods specific to when you have access to a certain node and not searching through
//the rope for a specific node

//Confused deciding whether or not getWeight should stay in Node or in Rope like how I put
//the non recursive method of index in rope.

public class Node 
{
	private String string;
	private Node leftNode;
	private Node rightNode;
	
	public Node(String s)
	{
		string = s;
	}
	
	
	public void addChild(Node n)
	{
		
	}
	public String getString()
	{
		return string;
	}
	
	//To calculate the weight, get the weight of the node's left child and the weight of all
	//the nodes in it's right subtree
	
	//Recursive method
	private int weight(Node n)
	{
		if(n.getRight() == null)
		{
			return n.getString().length();
		}
		return n.getString().length() + weight(n.getRight());
	}
	
	//To get the weight you have to call the getWeight starting with the first node on the left subtree
	public int getWeight()
	{
		//If there's no left subtree, return the length of the string
		if(this.leftNode == null)
		{
			return string.length();
		}
		return weight(this.leftNode);
	}
	

	
	
	
	public Node getLeft()
	{
		return leftNode;
	}
	public Node getRight()
	{
		return rightNode;
	}
}
