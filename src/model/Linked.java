package model;

public class Linked {

	private char nameSnake;
	private int nameLadders;
	
	//Nodes
	private Node start;
	private Node end;
	
	
	//For Snakes
	public Linked(char ns, Node s, Node e) {
		nameSnake = ns;
		
		start = s;
		end = e;
	}
	
	//For Ladders
	public Linked(int nl, Node s, Node e) {
		nameLadders = nl;
		start = s;
		end = e;
	}

	public Node getStart() {
		return start;
	}

	public Node getEnd() {
		return end;
	}
	
	public String toString() {
		if(nameLadders == 0) {
			return " " + nameSnake;
		} else {
			return " " + nameLadders;
		}
	}
	
}
