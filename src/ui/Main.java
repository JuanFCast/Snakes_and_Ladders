package ui;

import model.Game;

/**
 * This class contains attributes, relationships, and methods of a winner.
 * @version 1
 * @author Juan Felipe Castillo Gomez, https://github.com/JuanFCast
 * @author Juan Camilo Ramirez Tabares, https://github.com/JCamiloRamirezTabares
 * @author Jesus David Rodriguez Burbano, https://github.com/JesusD03
 */

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
