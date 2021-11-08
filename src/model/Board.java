package model;

import exceptions.SLoutBoundsException;

public class Board {

	private Node first;
	private Node last;
	
	private int numRow;
	private int numCol;
	private char globalChar = 'A';
	private int globalInt = 1;

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
			createRows(i+1, j, firstOfNextRow); 
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


	private void setNums(Node n, int nb) {
		if(nb <= getNumbNodes()) {
			Node aux = moveRight(nb, n);
			if(aux != null) {
				nb++;
				aux.setNumbNode(nb);
				setNums(n, nb);
			}
		}
	}

	private Node fakeLast(Node l, int c) {
		if(c > 1) {
			return fakeLast(l.getPrev(), c-1);
		} else {
			return l;
		}
	}

	public void addSnakesAndLadders(int s, int l) throws SLoutBoundsException {
		if((2*s + 2*l) <= getNumbNodes()) {
			addSnakes(s);
			addLadders(l);
		} else {
			throw new SLoutBoundsException();
		}
	}	

	private void addSnakes(int s) {
		if(s > 0) {
			Dice dice = new Dice(0, getNumbNodes()-1);
			int i = dice.roll();
			Node head = searchNode(i);
			
			i = dice.roll();
			Node tail = searchNode(i);
			if(verifySnake(head, tail) == true) {
				head.setSnake(new Linked(globalChar, tail, head));
				tail.setSnake(new Linked(globalChar, tail, head));
				globalChar = (char)(globalChar + 1);
				addSnakes(s-1);
			} else {
				addSnakes(s);
			}
		}
	}
	
	private void addLadders(int l) {
		if(l > 0) {
			Dice dice = new Dice(1, getNumbNodes()-1);
			int i = dice.roll();
			Node start = searchNode(i);
			
			i = dice.roll();
			Node end = searchNode(i);
			if(verifyLadder(start, end) == true) {
				start.setLadder(new Linked(globalInt, start, end));
				end.setLadder(new Linked(globalInt, start, end));
				globalInt++;;
				addLadders(l-1);
			} else {
				addLadders(l);
			}
		}
	}
	
	public void addPlayers(String player[], int i) {
		if (i<player.length) {
			Player p = new Player((player[i].charAt(0)));
			first.addPlayerInNode(p);
			addPlayers(player, i+1);
		}
		
	}
	
	private Node searchPlayers(int p, int nb, Node n){
		if(n.iHaveYourPlayer(p) == true) {
			return n;
		} else {
			nb = (nb+1);
			Node aux = moveRight(nb, first);
			if(aux != null) {
				return searchPlayers(p, nb, aux);
			} else {
				return null;
			}
		}
	}
	
	private boolean verifySnake(Node h, Node t) {
		if(h != t) {
			if((h.getSnake() == null && h.getLadder() == null) && (t.getSnake() == null && t.getLadder() == null)) {
				if(h.getNumbNode() > t.getNumbNode()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private boolean verifyLadder(Node h, Node t) {
		if(h != t) {
			if((h.getSnake() == null && h.getLadder() == null) && (t.getSnake() == null && t.getLadder() == null)) {
				if(h.getNumbNode() < t.getNumbNode()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Node searchNode(int i) {
		return moveRight(i, first);
	}
	
	
	private Node moveLeft(int i, Node n) {
		if(i > 0) {
			if(n.getPrev() != null) {
				return moveLeft(i-1, n.getPrev());
			} else {
				if(n.getUp() != null) {
					return moveRight(i-1, n.getUp());
				} else {
					return null;
				}
			}
		} else {
			return n;
		}
	}

	private Node moveRight(int i, Node n) {
		if(i > 0) {
			if(n.getNext() != null) {
				return moveRight(i-1, n.getNext());
			} else {
				if(n.getUp() != null) {
					return moveLeft(i-1, n.getUp());
				} else {
					return null;
				}
			}
		} else {
			return n;
		}
	}
	
	//Getters & Setters
	public void setNumberPlayers() {
		first.setNumbersPlayer();
	}
	
	public Node searchPlayer(int p) {
		return searchPlayers(p, 0, first);
	}
	
	public int getNumbNodes() {
		return numRow * numCol;
	}
	
	public int getNumbersPlayers() {
		return first.getTotalPlayers();
	}
	
	public Node getLast() {
		return last;
	}
	
	//To strings
	private String toStringRow1(Node firstRow) {
		String s = " | ";

		if(firstRow != null) {
			s += toStringCol1(firstRow) + "\n";
			s += toStringRow1(firstRow.getDown());
		}

		return s;
	}

	private String toStringCol1(Node current) {
		String s = "";

		if(current != null) {
			s += current.simpleBoard();
			s += toStringCol1(current.getNext());
		}

		return s;
	}

	private String toStringRow2(Node firstRow) {
		String s = " | ";

		if(firstRow != null) {
			s += toStringCol2(firstRow) + "\n";
			s += toStringRow2(firstRow.getDown());
		}

		return s;
	}

	private String toStringCol2(Node current) {
		String s = "";

		if(current != null) {
			s += current.completeBoard();
			s += toStringCol2(current.getNext());
		}

		return s;
	}
		
	//To Strings for the Boards
	public String completeBoard() {
		String s = "";
		Node n = fakeLast(last, numCol);
		s += toStringRow2(n);

		return s;
	}
	
	public String simpleBoard() {
		String s = "";
		Node n = fakeLast(last, numCol);
		s += toStringRow1(n);

		return s;
	}
}
