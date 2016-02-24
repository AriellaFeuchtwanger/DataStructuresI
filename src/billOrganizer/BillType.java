package billOrganizer;

public enum BillType {
	CLOTHING("Clothing"), EDUCATION("Education"), FOOD("Food"),
	GROCERIES("Groceries"), PHONE("Phone"), TRAVEL("Travel"), UTILITIES("Utilities");
	
	private String name;
	
	private BillType(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
