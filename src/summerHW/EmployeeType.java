package summerHW;

public enum EmployeeType {
	ACCOUNTANT("Accountant"), CHAIRPERSON("Chairperson"), CLERK("Clerk"), DEAN(
			"Dean"), PROFESSOR("Professor"), INSTRUCTOR("Instructor"), MAINTENANCE(
			"Maintenance"), SECRETARY("Secretary");

	private String type;

	private EmployeeType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

}
