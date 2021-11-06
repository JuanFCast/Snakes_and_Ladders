package model;

public class Dice {

	private int minimum;
	private int maximum;

	public Dice(int mi, int ma) {
		minimum = mi;
		maximum = ma;
	}

	public int roll() {
		return (int) Math.floor(Math.random()*(maximum - minimum + 1) + minimum);	
	}

	public String dimension() {
		return "The dice can return a value between " + minimum + " and " + maximum;
	}
}
