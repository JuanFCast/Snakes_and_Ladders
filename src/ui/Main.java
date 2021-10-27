package ui;

import model.LinkedList;

public class Main {

	private LinkedList lm;

	public Main() {
		lm = new LinkedList();
	}

	public static void main(String [] team) {
		Main main = new Main();
		main.lm.createMatrix(2, 2);
		System.out.println(main.lm);
	}
	
}
