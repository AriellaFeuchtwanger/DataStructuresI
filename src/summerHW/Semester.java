package summerHW;

public enum Semester {
	FALL("Fall"), SPRING("Spring"), SUMMER1("Summer 1"), SUMMER2("Summer 2");

	private String semester;

	private Semester(String semester) {
		this.semester = semester;
	}

	public String getSemester() {
		return this.semester;
	}
}
