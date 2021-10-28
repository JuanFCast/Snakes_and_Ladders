package model;

public class LinkedList {

	private Node first;
	private int numRow;
	private int numCol;
	
	private int num = 0;
	
	
	public LinkedList() {
		first = new Node(0, 0);
	}

	public void createMatrix(int r, int c) {
		numRow = r;
		numCol = c;
		
		createRows(0, 0, first);
		System.out.println("Este esta arriba del first: " + first.getNext().getUp());
		setNums(first, 0);
		System.out.println(first.getUp().getUp().getUp());
	}
	
	public void createRows(int i, int j, Node firstOfRow) {
		createCol(i, j+1, firstOfRow, firstOfRow.getDown());
		System.out.println("Este es el J de arriba = " + j);
		
		if(i+1 < numRow) {
			Node firstOfNextRow = new Node(i+1, j);
			firstOfRow.setUp(firstOfNextRow);
			firstOfNextRow.setDown(firstOfRow);
			//System.out.println("Este es el J de abajo = " + j);
			
			createRows(i+1, j, firstOfNextRow); //Por razon que se desconoce el -1 corrige un bug que no he podido solucionar
		}
	}
	
	public void createCol(int i, int j, Node prevNode, Node down) {
		if(j < numCol) {
			Node newNode = new Node(i, j);
			prevNode.setNext(newNode);
			newNode.setPrev(prevNode);
			
			if(down != null) {
				down = down.getNext();
				down.setUp(newNode);
				newNode.setDown(down);
			}
			createCol(i, j+1, newNode, down);
		}
	}
	
	
	public void setNums(Node n, int o) {
		if(n != null) {
			num++;
			if(o == 1) {
				if(n.getNext() != null) {
					n.setNumbNode(num);
					n = n.getNext();
					setNums(n, o);
				} else {
					o = 0;
					n.setNumbNode(num);
					n = n.getUp();
					num = num+1;
					n.setNumbNode(num);
					setNums(n, o);
				}
			} else {
				if(n.getPrev() != null) {
					n = n.getPrev();
					num = num+1;
					n.setNumbNode(num);
					setNums(n, o);
				} else {
					n.setNumbNode(num);
					n = n.getUp();
					//n.setNumbNode(num);
					o = 1;
					setNums(n, o);
				}
			}
		}
	}
	
	public Node moveLeft(Node n) {
		return n.getPrev();
	}
	
	public Node moveRight(Node n) {
		return n.getNext();
	}
	
	public Node moveUp(Node n) {
		return n.getUp();
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
