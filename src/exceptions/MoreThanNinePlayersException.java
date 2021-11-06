package exceptions;

public class MoreThanNinePlayersException extends Exception{

	private static final long serialVersionUID = 1L;

	public MoreThanNinePlayersException(){
		super("Players exceed the allowed limit");
	}

}
