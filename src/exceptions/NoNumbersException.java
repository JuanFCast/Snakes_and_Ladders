package exceptions;

public class NoNumbersException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoNumbersException() {
		super("The players should be chars");
	}
	
}
