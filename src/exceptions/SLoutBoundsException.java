package exceptions;

public class SLoutBoundsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public SLoutBoundsException() {
		super("Snakes and Ladders exceed the allowed limit");
	}

}
