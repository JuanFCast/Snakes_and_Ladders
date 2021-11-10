package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DiceTest {
	
	private Dice dice;

	public void setupScenary3() {
		
	}
	
	@Test
	public void testRandomNumber() {
		setupScenary3();
		
		int minimum = 1;
		int maximum = 6;
		
		dice = new Dice(minimum, maximum);
		
		int n = dice.roll();
		
		if(minimum <= n && n <= maximum) {
			
		} else {
			fail();
		}
	}

}
