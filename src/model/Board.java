package model;

import exceptions.SLoutBoundsException;

public class Board {

	private Node first;
	private Node last;
	
	private Node aux;
	
	private int numRow;
	private int numCol;
	private int num = 1;
	
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

	public int getNumbNodes() {
		return numRow * numCol;
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
			createLinked(i);
			Node head = aux;
			
			i = dice.roll();
			createLinked(i);
			Node tail = aux;
			if(verifySnake(head, tail) == true) {
				head.setSnake(new Linked(globalChar, head, tail));
				tail.setSnake(new Linked(globalChar, head, tail));
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
			createLinked(i);
			Node start = aux;
			
			i = dice.roll();
			createLinked(i);
			Node end = aux;
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
			System.out.println("este es el char " + i + p.get());
			addPlayers(player, i+1);
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
	
	private void createLinked(int i) {
		moveRight(i, first);
	}
	
	
	private void moveLeft(int i, Node n) {
		if(i > 0) {
			if(n.getPrev() != null) {
				moveLeft(i-1, n.getPrev());
			} else {
				if(n.getUp() != null) {
					moveRight(i-1, n.getUp());
				} else {
					aux = null;
				}
			}
		} else {
			aux = n;
		}
	}

	private void moveRight(int i, Node n) {
		if(i > 0) {
			if(n.getNext() != null) {
				moveRight(i-1, n.getNext());
			} else {
				if(n.getUp() != null) {
					moveLeft(i-1, n.getUp());
				} else {
					aux = null;
				}
			}
		} else {
			aux = n;
		}
	}

	public String toString() {
		String s = "";
		Node n = fakeLast(last, numCol);
		s += toStringRow(n);

		return s;
	}
}
