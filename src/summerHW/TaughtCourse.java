package summerHW;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class TaughtCourse extends Course {
	private Integer teacherID;
	private Integer year;
	private Semester semester;
	private Section section;

	public TaughtCourse(String courseID, String description, Integer credits,
			String deptID, Integer teacherID, Integer year, String semesterID,
			String sectionID) {
		super(courseID, description, credits, deptID);
		if (teacherID == null) {
			throw new InvalidDataException();
		} else
			this.teacherID = teacherID;
		// Assume that you're not backdating past Y2K
		if (year < 2000 || year > LocalDate.now().getYear()) {
			throw new InvalidDataException();
		} else
			this.year = year;

		this.semester = checkSemesterID(semesterID);
		if (this.semester == null) {
			throw new InvalidDataException();
		}

		this.section = checkSectionID(sectionID);
		if (this.section == null) {
			throw new InvalidDataException();
		}
	}
	/*
	public TaughtCourse(Course c, Integer teacherID, Integer year, String semester, String section){
		
	}
*/
	public Integer getTeacherID() {
		return teacherID;
	}

	public Integer getYear() {
		return year;
	}

	public String getSemester() {
		return semester.getSemester();
	}

	public String getSection() {
		return section.getSection();
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("\nTaught Course");
		buffer.append(super.toString());
		buffer.append(" Taught by: " + getTeacherID());
		buffer.append(" Semester taught: " + getSemester());
		buffer.append(" Course Section: " + getSection());

		return buffer.toString();
	}

	public Semester checkSemesterID(String semesterID) {
		for (Semester aSemester : Semester.values()) {
			if (aSemester.getSemester().equalsIgnoreCase(semesterID)) {
				return aSemester;
			}
		}

		return null;
	}

	public Section checkSectionID(String sectionID) {
		for (Section aSection : Section.values()) {
			if (aSection.getSection().equalsIgnoreCase(sectionID)) {
				return aSection;
			}
		}

		return null;
	}
}
