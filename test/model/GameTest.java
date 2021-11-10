package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.InsufficientPlayersForPlayingException;
import exceptions.MoreThanNinePlayersException;
import exceptions.NoEqualPlayersException;
import exceptions.NoNumbersException;
import exceptions.SLoutBoundsException;
import exceptions.signsExeption;

class GameTest {

	private Game miniGame;
	
	public void setupScenary1() {
		miniGame = new Game();
	}
	
	public void setupScenary2() {
		miniGame = new Game();
		try {
			String p[] = {"$", "&"};
			miniGame.startingGame(4, 4, 2, 1, p);
		} catch (SLoutBoundsException e) {}
	}
	
	@Test
	public void testCreateBoard() {
		setupScenary1();
		
		int n, m, s, e;
		String players[] = {"$", "%", "&"};
		
		n = 3;
		m = 4;
		s = 2;
		e = 3;
		
		try {
			miniGame.startingGame(n, m, s, e, players);
		} catch (SLoutBoundsException e1) {}
		
		assertEquals(miniGame.getFirst().getNumbNode(), 1);
		assertEquals(miniGame.getLast().getNumbNode(), (n*m));
	}
	
	
	
	@Test
	public void playersDontBeNumbers() {
		setupScenary1();
	
		String players[] = {"1", "2", "3"};
		
		try {
			miniGame.noNumbers(players, players.length-1);
			fail();
		} catch (NoNumbersException e1) {
			
		}
		
	}
	
	@Test
	public void minimun2Players() {
		setupScenary1();
		
		String players[] = {"#"};
		
		try {
			miniGame.numberPlayers(players);;
			fail();
		} catch (MoreThanNinePlayersException e1) {
			fail();
		} catch (InsufficientPlayersForPlayingException e1) {
			
		}
		
	}
	
	@Test
	public void maximum9Players() {
		setupScenary1();
		
		String players[] = {"*", "!", "O", "X", "%", "$", "#", "+", "&", "/"};
		
		try {
			miniGame.numberPlayers(players);;
			fail();
		} catch (MoreThanNinePlayersException e1) {
			
		} catch (InsufficientPlayersForPlayingException e1) {
			fail();
		}
		
	}
	
	@Test
	public void dontRepeatPlayers() {
		setupScenary1();
		
		String players[] = {"*", "!", "O", "X", "$", "$", "#", "+", "&"};
		int n = players.length-1;
		
		try {
			miniGame.noEqualsPlayer(players, n, n);
			fail();
		} catch (NoEqualPlayersException e) {
			
		}
		
		
	}
	
	@Test
	public void playersMustBeTheSigns() {
		setupScenary1();
		
		String players[] = {"*", "!", "O", "B", "A", "$", "#", "+", "&"};
		
		try {
			miniGame.signs(players, players.length-1);
			fail();
		} catch (signsExeption e) {
			
		}
		
	}

}
