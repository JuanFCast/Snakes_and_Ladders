package model;

public class Player {
	
	private char player;
	private String numPlayer;
	private int numbMovements;
	private int diceMovements;
	
	//Players
	Player nextPlayer;
	
	public Player(char symbol) {
		player = symbol;
		numbMovements = 0;
		diceMovements = 0;
	}
	
	//Getters & Setters
	public char get() {
		return player;
	}
	
	public void set(char c) {
		player = c;
	}
	
	public String getNumPlayer() {
		return numPlayer;
	}
	
	public int getNumbMovements() {
		return numbMovements;
	}

	public void setNumbMovements(int numbMovements) {
		this.numbMovements = numbMovements;
	}

	public int getDiceMovements() {
		return diceMovements;
	}

	public void setDiceMovements(int diceMovements) {
		this.diceMovements = diceMovements;
	}

	
	//For next
	public Player getNext() {
		return nextPlayer;
	}
	
	public void setNext(Player p) {
		nextPlayer = p;
	}
	
	
	
	public String toString() {
		return "" + player;
	}
}
