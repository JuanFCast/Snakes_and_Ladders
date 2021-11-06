package model;

import exceptions.InsufficientPlayersForPlayingException;
import exceptions.MoreThanNinePlayersException;
import exceptions.NoEqualPlayersException;
import exceptions.NoNumbersException;
import exceptions.SLoutBoundsException;

public class Game {

	private Board board;
	private Dice dice;
	private Winners w;

	public Game() {
		board = new Board();
		dice = new Dice(1, 6);
	}
	
	
	public void noNumbers(String players[], int n) throws NoNumbersException{
		if(n >= 0) {
			try {
				Integer.parseInt(players[n]);
				throw new NoNumbersException();
			} catch (NumberFormatException e) {
				noNumbers(players, n-1);
			}
		}
	}
	
	public void numberPlayers(String players[]) throws MoreThanNinePlayersException, InsufficientPlayersForPlayingException {
		if(players.length>9) {
			throw new MoreThanNinePlayersException();
		} else if(players.length<2) {
			throw new InsufficientPlayersForPlayingException();
		}
	}
	
	public void noEqualsPlayer(String players[], int n) throws NoEqualPlayersException{
		if(n >= 0) {
			try {
				Integer.parseInt(players[n]);
				throw new NoEqualPlayersException();
			} catch (NumberFormatException e) {
				noEqualsPlayer(players, n-1);
			}
		}
	}

	public void startingGame(int r, int c, int s, int e) throws SLoutBoundsException {
		board.createBoard(r, c);
		board.addSnakesAndLadders(s, e);
	}

	public String printBoard() {
		return board.toString();
	}
	
	
}
