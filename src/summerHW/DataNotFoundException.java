package summerHW;

public class DataNotFoundException extends RuntimeException{
	public DataNotFoundException(){
		super("data not found");
	}
}
