package model;

public class Board {

	private Node first;
	private Node last;
	
	private int numRow;
	private int numCol;
	
	private int num = 1;
	
	
	public Board() {
		first = new Node(0, 0);
	}

	public void createBoard(int r, int c) {
		numRow = r;
		numCol = c;
		
		createRows(0, 0, first);
		setNums(first, 0);
	}
	
	private void createRows(int i, int j, Node firstOfRow) {
		createCol(i, j+1, firstOfRow, firstOfRow.getDown());
		
		if(i+1 < numRow) {
			Node firstOfNextRow = new Node(i+1, j);
			firstOfRow.setUp(firstOfNextRow);
			firstOfNextRow.setDown(firstOfRow);
			
			createRows(i+1, j, firstOfNextRow); //Por razon que se desconoce el -1 corrige un bug que no he podido solucionar
		}
	}
	
	private void createCol(int i, int j, Node prevNode, Node down) {
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
			
			if((i+1) == numRow && (j+1) == numCol) {
				last = newNode;
			}
		}
	}
	
	
	private void setNums(Node n, int o) {
		if(o == 0) {
			if(n.getNext() != null) {
				n.setNumbNode(num);
				n = n.getNext();
				num++;
				setNums(n, o);
			} else {
				n.setNumbNode(num);
				num++;
				if(n.getUp() != null) {
					n = n.getUp();
					n.setNumbNode(num);
					n = n.getPrev();
					num++;
					setNums(n, 1);
				}
			}
		} else {
			if(n.getPrev() != null) {
				n.setNumbNode(num);
				n = n.getPrev();
				num++;
				setNums(n, o);
			} else {
				n.setNumbNode(num);
				num++;
				if(n.getUp() != null) {
					n = n.getUp();
					n.setNumbNode(num);
					n = n.getNext();
					num++;
					setNums(n, 0);
				}
			}
		}
	}
	
	private String toStringRow(Node firstRow) {
		String s = " | ";

		if(firstRow != null) {
			s += toStringCol(firstRow) + "\n";
			s += toStringRow(firstRow.getDown());
		}

		return s;
	}
	
	private String toStringCol(Node current) {
		String s = "";

		if(current != null) {
			s += current.toString();
			s += toStringCol(current.getNext());
		}
		
		return s;
	}
	
	private Node fakeLast(Node l, int c) {
		if(c > 1) {
			return fakeLast(l.getPrev(), c-1);
		} else {
			return l;
		}
	}
	
	public int numbNodes() {
		return numRow * numCol;
	}
	
	public String toString() {
		String s = "";
		Node n = fakeLast(last, numCol);
		s += toStringRow(n);
		
		return s;
	}
}
