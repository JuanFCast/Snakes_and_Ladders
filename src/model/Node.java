package model;

public class Node {
	
	private int row;
	private int col;
	
	private int numbNode;
	private Player players;
	
	//Nodes around
	private Node next;
	private Node prev;
	private Node up;
	private Node down;
	
	public Node(int r, int c) 
	{
		row = r;
		col = c;
	}
	
	//Getters and Setters
	public int getNumbNode() {
		return numbNode;
	}
	
	public void setNumbNode(int numbNode) {
		this.numbNode = numbNode;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}


	//of Nodes
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}
	
	public String toString() {
		return "[" + row + ", " + col + "]";
	}
}
