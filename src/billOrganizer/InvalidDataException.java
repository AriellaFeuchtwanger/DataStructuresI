package billOrganizer;

public class InvalidDataException extends RuntimeException{
	public InvalidDataException(){
		super("Invalid data");
	}
}
