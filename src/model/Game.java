package model;

public class Game {

	private Board board;
	
	public Game() {
		board = new Board();
	}
	
	public void createBoard(int r, int c) {
		board.createMatrix(r, c);
	}
	
	public String printBoard() {
		return board.toString();
	}
	
}
