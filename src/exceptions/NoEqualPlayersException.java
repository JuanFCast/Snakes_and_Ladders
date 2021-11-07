package exceptions;

public class NoEqualPlayersException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoEqualPlayersException() {
		super("Players cannot have the same symbol");
	}
}
