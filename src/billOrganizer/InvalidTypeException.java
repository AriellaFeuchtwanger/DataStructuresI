package billOrganizer;

public class InvalidTypeException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTypeException(){
		super("Invalid Type");
	}
}
