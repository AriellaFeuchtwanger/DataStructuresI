package summerHW;

public enum Grade {
	APLUS(4.0), A(4.0), AMINUS(3.7), BPLUS(3.3), B(3.0), BMINUS(2.7), CPLUS(2.3), C(
			2.0), CMINUS(1.7), DPLUS(1.3), D(1.0), DMINUS(0.7), F(0.0);

	private double grade;

	private Grade(double grade) {
		this.grade = grade;
	}

	public double getGrade() {
		return this.grade;
	}

}
