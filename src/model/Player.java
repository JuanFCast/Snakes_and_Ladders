package model;

public class Player {
	
	private char player;
	private String numPlayer;
	
	//Players
	Player nextPlayer;
	
	public Player(char name, String nump) {
		player = name;
		numPlayer = nump;
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
