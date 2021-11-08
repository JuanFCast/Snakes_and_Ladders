package model;

public class Node {

	private int row;
	private int col;

	private int numbNode;
	private Player players;
	private Linked snake;
	private Linked ladder;
	
	private int totalPlayers = 0;

	//Nodes around
	private Node next;
	private Node prev;
	private Node up;
	private Node down;

	public Node(int r, int c) {
		row = r;
		col = c;
	}

	
	public void addPlayerInNode(Player p){
        if(players==null) {
        	players = p;
        }else {
        	addPlayerInNode(players, p);
        }
    }

    private void addPlayerInNode(Player current, Player p) {
        if(current.getNext() ==  null) {
            current.setNext(p);
        }else {
        	addPlayerInNode(current.getNext(),p);
        }
    }
    
    public Player moveThisPlayer(int p) {
    	if(players.getNumPlayer() == p) {
    		Player pl = players;
    		players = players.getNext();
    		
    		pl.setNext(null);
    		
    		return pl;
    	} else {
    		return moveThisPlayer(p, players);
    	}
    }
    
    private Player moveThisPlayer(int n, Player p) {
    	if(p.getNext() != null) {
    		if(p.getNext().getNumPlayer() == n) {
    			Player pl = p.getNext();
    			p.setNext(p.getNext().getNext());
    			
    			return pl;
    		} else {
    			return moveThisPlayer(n, p.getNext());
    		}
    	} else {
    		if(p.getNumPlayer() == n) {
    			Player pl = p;
    			p = null;
    			return pl;
    		} else {
    			return null;
    		}
    	}
    }
    
    public void setNumbersPlayer() {
    	setNumbersPlayer(players, 1);
    }
    
    private void setNumbersPlayer(Player p, int i) {
    	if(p != null) {
    		p.setNumPlayer(i);
    		setNumbersPlayer(p.getNext(), i+1);
    	}
    }
    
    public int getTotalPlayers() {
		getTotalPlayers(players);
		return totalPlayers;
	}
	
	private void getTotalPlayers(Player p) {
		if(p == null) {
			totalPlayers+=0;
		} else {
			totalPlayers++;
			getTotalPlayers(p.getNext());
		}
	}
	
	public boolean iHaveYourPlayer(int p) {
		return iHaveYourPlayer(p, players);
	}

	private boolean iHaveYourPlayer(int n, Player p) {
		if(p == null) {
			return false;
		} else {
			if(p.getNumPlayer() == n) {
				return true;
			} else {
				return iHaveYourPlayer(n, p.getNext());
			}
		}
	}
	
    
	//Getters and Setters
	public int getNumbNode() {
		return numbNode;
	}

	public void setNumbNode(int numbNode) {
		this.numbNode = numbNode;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}


	//of Nodes
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getUp() {
		return up;
	}

	public void setUp(Node up) {
		this.up = up;
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
	}
	
	public Player getPlayers() {
		return players;
	}

	//For Snakes and Ladders
	public Linked getSnake() {
		return snake;
	}

	public Linked getLadder() {
		return ladder;
	}

	public void setSnake(Linked snake) {
		this.snake = snake;
	}

	public void setLadder(Linked ladder) {
		this.ladder = ladder;
	}

	//ToString Players in Node
	private String toStringPlayers(Player p) {
		String s = "";
		if(p != null) {
			s += p.toString();
			s += toStringPlayers(p.getNext());
		}

		return s;
	}

	//To String snakes and ladders
	private String toStringSnakesAndLadders(Linked s) {
		String m = "";
		if(s != null) {
			m += s.toString();
		}

		return m;
	}


	//ToString Node
	public String simpleBoard() {
		String s = toStringSnakesAndLadders(snake);
		String l = toStringSnakesAndLadders(ladder);
		String t = " ";

		if(numbNode >= 10) {
			t += numbNode;
		} else {
			t += " " + numbNode;
		}
		if(s.equals("")) {
			t = " " + t;
		} else {
			t += s;
		}
		if(l.equals("")) {
			t = " " + t;
		} else {
			t += l;
		}
		t+= "  ";
		
		return "[ " + t + "]";
	}
	
	
	
	public String completeBoard() {
		String s = toStringSnakesAndLadders(snake);
		String l = toStringSnakesAndLadders(ladder);
		String p = toStringPlayers(players);
		String t = " ";

		if(s.equals("")) {
			t = " " + t;
		} else {
			t += s;
		}
		if(l.equals("")) {
			t = " " + t;
		} else {
			t += l;
		}
		if(p.equals("")) {
			t = " " + t;
		} else {
			t += p;
		}
		
		return "[ " + t + "]";
	}
}
