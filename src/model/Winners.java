package model;


/**
 * This class contains attributes, relationships, and methods of a winner.
 * @version 1
 * @author Juan Felipe Castillo Gomez, https://github.com/JuanFCast
 */
public class Winners extends Player{
	private String namePlayer;
	private Double score;
	private int position;

	//BST
	private Winners parent;
	private Winners left;
	private Winners right;


	public Winners(int position, String namePlayer, Double score, char symbol) {
		super(symbol);
		this.position=position;
		this.namePlayer=namePlayer;
		this.score=score;

	}

	public static void calculateScore() {

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



	/**
	 * This method produces a String with all the information about Winner. <br>
	 * <b>name</b>: toString.<br>
	 * <b>post</b>: All the information of a Winner was returned. <br>
	 * @return out in a <code> String </code> variable all the information about a Winner.
	 */ 
	public String toString() {
		return " | " + position + " | " + namePlayer + " | " + get() + " | "  + score + " | ";
	}




}
