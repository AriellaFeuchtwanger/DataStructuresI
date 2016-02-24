package billOrganizer;

public class NotFoundException extends RuntimeException{
	
	public NotFoundException(){
		super("Data not found");
	}

}
