package billOrganizer;

public enum BillCriteria {
	BILLDUEDATE("DueDate"), BILLAMOUNT("Amount"), BILLTYPE("Type");
	
	private String criteria;
	
	private BillCriteria(String criteria){
		this.criteria = criteria;
	}
	
	public String getCriteria(){
		return criteria;
	}
}
