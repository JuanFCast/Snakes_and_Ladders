package exceptions;

public class NoEqualPlayersException extends Exception{
	private static final long serialVersionUID = 1L;

	public NoEqualPlayersException() {
		super("Los jugadores no pueden tener el mismo simbolo");
	}
}
