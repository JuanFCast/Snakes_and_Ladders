package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Game;

public class Menu {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Game snakeAndLadders = new Game();

	public Menu() {
		welcome();
	}
	
	public void welcome() {
		System.out.println(" |============================================================|\n"
				+ " |=================|        WELCOME TO      |=================|\n"
				+ " |=================|    SNAKE AND LADDERS   |=================|\n"
				+ " |=================|                        |=================|\n"
				+ " |=================|   Developed by J.J.J   |=================|\n"
				+ " |============================================================|\n");
	}
	
	public void mainMenu(int o) throws NumberFormatException, IOException {
		if(o != 1) {
			System.out.print(" |------------------------------------------------------------|\n"
					+ " | o Please choose a option that you wanna do:                |\n"
					+ " |                                                            |\n"
					+ " |       1 - Play game...                                     |\n"
					+ " |       2 - Show game scoreboard...                          |\n"
					+ " |       3 - Exit...                                          |\n"
					+ " |                                                            |\n"
					+ " |------------------------------------------------------------|\n"
					+ " | Choose: ");
			
			int option = Integer.parseInt(br.readLine());
			
			switch(option) {
			case 1:
				startGame();
				mainMenu(o);
				break;
			case 2:

				mainMenu(o);
				break;
			case 3:
				System.out.println(" | See you later :3");
				mainMenu(1);
				break;
			default:
				System.out.println(" | GONZO IS THE BEST");
				System.out.println(" | You found an easter egg, congratulations!!!");
				mainMenu(1);
				break;
			}
		}
	}
	
	public void startGame() throws IOException {
		System.out.print(" | Please enter the following values on the same line:        |\n"
				+ " |   o ROWS COLUMNS SNAKES LADDERS PLAYERS                    |\n"
				+ " |                                                            |\n"
				+ " |     Values: ");
		
		String parts[] = br.readLine().split(" ");
		System.out.println(" |------------------------------------------------------------|");
		snakeAndLadders.createBoard(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
		System.out.println(snakeAndLadders.printBoard());
	}
	
	public void play(String mode) {
		
	}
}
