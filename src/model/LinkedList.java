package model;

public class LinkedList {

	private Node first;
	private int numRow;
	private int numCol;
	
	
	public LinkedList() {
		first = new Node(0, 0);
	}

	public void createMatrix(int r, int c) {
		numRow = r;
		numCol = c;
		createRows(0, 0, first);
	}
	
	public void createRows(int i, int j, Node firstOfRow) {
		System.out.println("Se crea la fila " + i);
		System.out.println("Se crea la columna " + j);
		//System.out.println("Este es el first que recibo de parametro: " + firstOfRow.toString());
		createCol(i, j+1, firstOfRow, firstOfRow.getDown());
		//System.out.println("Este es el row que trae: " + firstOfRow.toString());
		
		if(i+1 < numRow) {
			Node firstOfNextRow = new Node(i+1, j);
			firstOfRow.setUp(firstOfNextRow);
			firstOfNextRow.setDown(firstOfRow);
			System.out.println("Este es el que esta arriba: " + firstOfRow.getUp().toString());
			System.out.println("Este es el actual: " + firstOfRow.toString());
			if(firstOfRow.getDown() != null) {
				System.out.println("Este es el que esta abajo: " + firstOfRow.getDown().toString());
			} else {
				System.out.println("No hay nada abajo");
			}
			
			//System.out.println("Este es el nodo arriba del first" + first.getUp().toString());
			//System.out.println("Este es el first que mando de parametro: " + firstOfNextRow.toString());
			
			createRows(i+1, j, firstOfNextRow);
		}
	}
	
	public void createCol(int i, int j, Node prevNode, Node down) {
		if(j < numCol) {
			System.out.println("Se crea la columna " + j);
			Node newNode = new Node(i, j);
			prevNode.setNext(newNode);
			newNode.setPrev(prevNode);
			
			if(down != null) {
				down.setUp(newNode);
				newNode.setDown(down);
				down = down.getNext();
			}
			createCol(i, j+1, newNode, down);
		}
	}
	
	public String toStringRow(Node firstRow) {
		String s = "";

		if(firstRow != null) {
			s = toStringCol(firstRow) + "\n";
			s += toStringRow(firstRow.getUp());
		}

		return s;
	}
	
	public String toStringCol(Node current) {
		String s = "";
		
		if(current != null) {
			s += current.toString();
			s += toStringCol(current.getNext());
		}
		
		return s;
	}
	
	public String toString() {
		String s = "";
		s += toStringRow(first);
		
		return s;
	}
}
