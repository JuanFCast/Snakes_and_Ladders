package model;

public class Game {

	private Board board;
	private Dice dice;
	
	public Game() {
		board = new Board();
		dice = new Dice(1, 6);
	}
	
	public void createBoard(int r, int c) {
		board.createBoard(r, c);
	}
	
	public String printBoard() {
		return board.toString();
	}
	
	
}
