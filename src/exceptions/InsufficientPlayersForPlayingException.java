package exceptions;

public class InsufficientPlayersForPlayingException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientPlayersForPlayingException() {
		super("Insufficient players to start the game");
	}
	
}
