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
	
	public void addPlayerInNode(Player p) {
		if(players == null) {
			players = p;
		} else {
			
		}
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
	
	//ToString Players in Node
	private String toStringPlayers(Player p) {
		String s = "";
		if(p != null) {
			s += p.toString();
			p = p.getNext();
			toStringPlayers(p);
		}
		
		return s;
	}
	
	
	//ToString Node
	public String toString() {
		String p = toStringPlayers(players);
		
		if(numbNode >= 10) {
			return "[  " + numbNode + p + "  ]";
		} else {
			return "[   0" + numbNode + p + "  ]";
		}
	}
}
