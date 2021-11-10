package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.SLoutBoundsException;

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
	public void testHeadSnakesInLast() {
		setupScenary2();
		
		if(miniGame.getLast().getSnake() != null) {
			assertNotEquals(miniGame.getLast().getSnake().getEnd(), miniGame.getLast());
		} else {
			assertEquals(miniGame.getLast().getSnake(), null);
		}
	}
	
	@Test
	public void testStartLadderInFirst() {
		setupScenary2();
		
		if(miniGame.getFirst().getLadder() != null) {
			assertNotEquals(miniGame.getFirst().getLadder().getStart(), miniGame.getFirst());
		} else {
			assertEquals(miniGame.getFirst().getLadder(), null);
		}
	}
	
	@Test
	public void testSnakesAndLadderLessThatNXM() {
		setupScenary1();
		
		int n, m, s, e;
		String players[] = {"$", "%", "&"};
		
		n = 4;
		m = 4;
		s = 5;
		e = 4;
		
		try {
			miniGame.startingGame(n, m, s, e, players);
			fail();
		} catch (SLoutBoundsException e1) {}
	}

}
