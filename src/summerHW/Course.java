package summerHW;

public class Course implements Comparable {
	private String courseID;
	private String description;
	private Integer credits;
	private String deptID;

	public Course(String courseID, String description, Integer credits,
			String deptID) {
		if (courseID == null) {
			throw new InvalidDataException();
		} else
			this.courseID = courseID;

		if (description == null)
			throw new InvalidDataException();
		else
			this.description = description;

		if (credits < 0 || credits > 4) {
			throw new InvalidDataException();
		} else
			this.credits = credits;

		if (deptID == null)
			throw new InvalidDataException();
		else
			this.deptID = deptID;
	}

	// Getters
	public String getCourseID() {
		return this.courseID;
	}

	public String getDescription() {
		return this.description;
	}

	public Integer getCredits() {
		return this.credits;
	}

	public String getDepartmentID() {
		return this.deptID;
	}

	// toString
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Course: " + getCourseID() + " ");
		buffer.append(getDescription() + " ");
		buffer.append(" Number of Credits: " + credits);
		buffer.append(" DepartmentID: " + getDepartmentID());

		return buffer.toString();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (other.getCourseID().compareTo(courseID) == 0) {
			return true;
		} else
			return false;
	}

	@Override
	public int compareTo(Object o) {
		Course other = (Course) o;
		return other.getCourseID().compareTo(getCourseID());
	}
}
