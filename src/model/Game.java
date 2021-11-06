package model;

import exceptions.SLoutBoundsException;

public class Game {

	private Board board;
	private Dice dice;
	private Winners w;

	public Game() {
		board = new Board();
		dice = new Dice(1, 6);
	}

	public void startingGame(int r, int c, int s, int e) throws SLoutBoundsException {
		board.createBoard(r, c);
		board.addSnakesAndLadders(s, e);
	}

	public String printBoard() {
		return board.toString();
	}
}
