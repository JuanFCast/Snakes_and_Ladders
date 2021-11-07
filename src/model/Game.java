package model;

import exceptions.InsufficientPlayersForPlayingException;
import exceptions.MoreThanNinePlayersException;
import exceptions.NoEqualPlayersException;
import exceptions.NoNumbersException;
import exceptions.SLoutBoundsException;
import exceptions.signsExeption;

public class Game {

	private Board board;
	private Dice dice;
	private Winners w;

	public Game() {
		dice = new Dice(1, 6);
	}
	
	public void startingGame(int r, int c, int s, int e, String p[]) throws SLoutBoundsException {
		board = new Board();
		board.createBoard(r, c);
		board.addSnakesAndLadders(s, e);
		board.addPlayers(p, 0);
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
	
	
	public void noEqualsPlayer(String players[], int n, int m) throws NoEqualPlayersException{
		
		if (n>=0) {
			if (m>=0) {
				if(n!=m && players[n].equals(players[m])) {

					throw new NoEqualPlayersException();

				}else {
					noEqualsPlayer(players, n, m-1);
				}
			}
			noEqualsPlayer(players, n-1, players.length-1);
		}



	}
	
	public void signs(String players[], int n) throws signsExeption {
		String symbol1 = "*";
		String symbol2 = "!";
		String symbol3 = "O";
		String symbol4 = "X";
		String symbol5 = "%";
		String symbol6 = "$";
		String symbol7 = "#";
		String symbol8 = "+";
		String symbol9 = "&";
		
		if (n>=0) {
			if(players[n].equals(symbol1) || players[n].equals(symbol2) || players[n].equals(symbol3) || players[n].equals(symbol4) || players[n].equals(symbol5) || players[n].equals(symbol6) || players[n].equals(symbol7) || players[n].equals(symbol8) || players[n].equals(symbol9)) {
				signs(players, n-1);

			}else {

				throw new signsExeption();
			}

		}
	}
	
	
	
	
	public Winners getW() {
		return w;
	}

	public void setW(Winners w) {
		this.w = w;
	}

	public String printSimpleBoard() {
		return board.simpleBoard();
	}
	
	public String printCompleteBoard() {
		return board.completeBoard();
	}
		
}
