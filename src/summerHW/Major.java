package summerHW;

public enum Major {
	ACCT("Accounting", "ACCT"), ART("Art", "ART"), BIOL("Biology", "BIOL"), CHEM("Chemistry", "CHEM"), CPSC(
			"Computer Science", "CPSC"), ECON("Economics", "ECON"), EDUC("Education", "EDUC"), ENGL(
			"English", "ENGL"), ENGR("Engineering", "ENGR"), FRCH("French", "FRCH"), GEOG("Geology", "GEOG"), GERM(
			"German", "GERM"), GREE("Greek", "GREE"), HIST("History", "HIST"), MATH("Math", "MATH"), MUSC(
			"Music", "MUSC"), NURS("Nursing", "NURS"), PHIL("Philosophy", "PHIL"), PE("Physical Ed", "PE"), PHY(
			"Physics", "PHYS"), POLS("Political Science", "POLS"), PSYC("Psychology", "PSYC"), RELI(
			"Religion", "RELI"), SOCI("Sociology", "SOCI"), SPEE("Speech", "SPEE"), UDCD("Undecided", "UDCD");

	private String major;
	private String majorID;

	private Major(String major, String majorID) {
		this.major = major;
		this.majorID = majorID;
	}

	public String getMajor() {
		return this.major;
	}
	
	public String getMajorID(){
		return this.majorID;
	}
}
