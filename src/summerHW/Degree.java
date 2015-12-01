package summerHW;

public enum Degree {
	BA("BA"), BS("BS"), MA("MA"), MS("MS"), Phd("Phd"), CPA("CPA");
	
	private String degree;
	
	private Degree(String degree){
		this.degree = degree;
	}
	
	public String getDegree(){
		return this.degree;
	}

}
