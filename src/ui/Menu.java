package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.SLoutBoundsException;
import exceptions.InsufficientPlayersForPlayingException;
import exceptions.MoreThanNinePlayersException;
import exceptions.NoEqualPlayersException;
import exceptions.NoNumbersException;
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
			System.out.println(" |------------------------------------------------------------|");

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
				System.out.println(" | Hey you, I hope you have a beautiful day <3");
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

		try {
			String players[] = parts[4].split("");
			snakeAndLadders.startingGame(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]),
					Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), players );
			snakeAndLadders.numberPlayers(players);
			snakeAndLadders.noNumbers(players, players.length-1);
			snakeAndLadders.noEqualsPlayer(players, players.length-1, players.length-1);
			System.out.println(snakeAndLadders.printSimpleBoard());
			br.readLine();
			System.out.println(snakeAndLadders.printCompleteBoard());
			playing();
			
		} catch (NumberFormatException e1) {
			System.out.println(" | The values of Row, Columns, Snakes and Ladders should be numbers");
		} catch (SLoutBoundsException e1) {
			System.out.println(" | Snakes and Ladders exceed the allowed limit");
		} catch (MoreThanNinePlayersException e) {
			System.out.println(" | Players exceed the allowed limit                           |");
			mainMenu(0);
		} catch (InsufficientPlayersForPlayingException e) {
			System.out.println(" | Insufficient players to start the game                     |");
			mainMenu(0);
		} catch (NoNumbersException e) {
			System.out.println(" | The players should be chars like * ! O X % $ # + &         |");
		} catch (NoEqualPlayersException e) {
			System.out.println(" | Players must have different symbols                        |");
		}

	}

	public void playing() throws IOException {
		if(snakeAndLadders.getW()==null) {
			String option = br.readLine();
			if(option.equals("menu")) {
				
			}else {
				play(option);
				System.out.println(snakeAndLadders.printCompleteBoard());
				playing();
			}
			
		}
	}

	public void play(String mode) throws IOException {

		if(mode.equals(" ")) {
			
		} else if(mode.equals("simul")) {
			
		}else if(mode.equals("num")) {
			System.out.println(snakeAndLadders.printSimpleBoard());
			br.readLine();
		}
	}

	

	

}
