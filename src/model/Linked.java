package model;


//Es una clase que puede transformarse en una serpiente o en una escalera de acuerdo a la necesidad
public class Linked {

	private char nameSnake;    //    <---- Si tiene una serpiente
	private int nameLadders;   //    <---- Si tiene una escalera

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
			return "" + nameSnake;
		} else {
			return "" + nameLadders;
		}
	}

}
