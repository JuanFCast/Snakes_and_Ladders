package model;

public class Node {

	private int row;
	private int col;

	private int numbNode;
	private Player players;
	private Linked snake;
	private Linked ladder;

	//Nodes around
	private Node next;
	private Node prev;
	private Node up;
	private Node down;

	public Node(int r, int c) {
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


	//For Snakes and Ladders
	public Linked getSnake() {
		return snake;
	}

	public Linked getLadder() {
		return ladder;
	}

	public void setSnake(Linked snake) {
		this.snake = snake;
	}

	public void setLadder(Linked ladder) {
		this.ladder = ladder;
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

	private String toStringSnakesAndLadders(Linked s) {
		String m = "";
		if(s != null) {
			m += s.toString();
		}

		return m;
	}


	//ToString Node
	public String toString() {
		String s = toStringSnakesAndLadders(snake);
		String l = toStringSnakesAndLadders(ladder);
		String p = toStringPlayers(players);

		if(numbNode >= 10) {
			return "[  " + numbNode + s + l + p + "  ]";
		} else {
			return "[   " + numbNode +  s + l + p + "  ]";
		}
	}
}
