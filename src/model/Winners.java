package model;

public class Winners extends Player{
	private String namePlayer;
	private Double score;
	private int position;

	//BST
	private Winners parent;
	private Winners left;
	private Winners right;


	public Winners( char symbol, int position, String namePlayer, Double score) {
		super(symbol);
		this.position=position;
		this.namePlayer=namePlayer;
		this.score=score;

	}
	
	public Winners(char symbol) {
		super(symbol);
	}

	public void calculateScore(int numbNodes) {
		score = (double) getNumbMovements() * numbNodes;
	}


	//Getters and Setters
	public String getNamePlayer() {
		return namePlayer;
	}

	public Double getScore() {
		return score;
	}

	public int getPosition() {
		return position;
	}



	//Getters and Setters of the BST
	public Winners getParent() {
		return parent;
	}

	public void setParent(Winners parent) {
		this.parent = parent;
	}

	public Winners getLeft() {
		return left;
	}

	public void setLeft(Winners left) {
		this.left = left;
	}

	public Winners getRight() {
		return right;
	}

	public void setRight(Winners right) {
		this.right = right;
	}

	public String toString() {
		return " | " + position + " | " + namePlayer + " | " + get() + " | "  + score + " | ";
	}
}
