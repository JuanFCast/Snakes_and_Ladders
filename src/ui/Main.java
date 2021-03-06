package ui;

import java.io.IOException;

/**
 * This is Main Class.
 * @version 1
 * @author Juan Felipe Castillo Gomez, https://github.com/JuanFCast
 * @author Juan Camilo Ramirez Tabares, https://github.com/JCamiloRamirezTabares
 * @author Jesus David Rodriguez Burbano, https://github.com/JesusD03
 */


/** Propuestas para pruebas unitarias
 *  No hayan cabeza de serpientes en el nodo nxm
 *  No hayan inicios de escaleras en el nodo nxm
 * 
 *
 */

public class Main {

	private Menu app;

	public Main() {
		app = new Menu();
	}

	public static void main(String [] team) {
		Main ppal = new Main();
		try {
			ppal.app.mainMenu(0);
		} catch (NumberFormatException e) {

		} catch (IOException e) {

		}
	}

}
