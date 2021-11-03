package ui;

import model.Game;

public class Main {

	private Game snakeAndLadders;

	public Main() {
		snakeAndLadders = new Game();
	}

	public static void main(String [] team) {
		Main m = new Main();
		m.snakeAndLadders.createBoard(4, 4);
		System.out.println(m.snakeAndLadders.printBoard());
	}
	
	
}
