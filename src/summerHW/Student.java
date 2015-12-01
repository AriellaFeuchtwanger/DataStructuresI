package summerHW;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person {
	private Major major;
	private LocalDate dateOfBirth;
	private LocalDate enrollDate;
	private String SSN;
	private ArrayList<CompletedCourse> coursesCompleted;
	private Double gpa;
	private Integer credits;

	public Student(Integer ID, String firstName, String lastName,
			String street, String city, String state, String zip,
			Character gender, Integer monthBirth, Integer dayBirth,
			Integer yearBirth, Integer monthEnroll, Integer dayEnroll,
			Integer yearEnroll, String SSN) {
		this(ID, firstName, lastName, null, street, city, state, zip, null,
				gender, null, monthBirth, dayBirth, yearBirth, monthEnroll,
				dayEnroll, yearEnroll, SSN);
	}

	public Student(Integer ID, String firstName, String lastName,
			Character midInitial, String street, String city, String state,
			String zip, String phone, Character gender, String major,
			Integer monthBirth, Integer dayBirth, Integer yearBirth,
			Integer monthEnroll, Integer dayEnroll, Integer yearEnroll,
			String SSN) {
		super(ID, firstName, lastName, midInitial, street, city, state, zip,
				phone, gender);

		if (monthBirth != null && dayBirth != null && yearBirth != null) {
			dateOfBirth = LocalDate.of(yearBirth, monthBirth, dayBirth);
		} else {
			throw new InvalidDataException();
		}

		if (monthEnroll != null && dayEnroll != null && yearEnroll != null) {
			enrollDate = LocalDate.of(yearEnroll, monthEnroll, dayEnroll);
		} else {
			throw new InvalidDataException();
		}

		this.major = findMajor(major);
		

		if (SSN.length() == 9) {
			this.SSN = SSN;
		} else {
			throw new InvalidDataException();
		}

		gpa = 0.0;
		credits = 0;
		coursesCompleted = new ArrayList<CompletedCourse>();
	}

	public void changeMajor(String major) {
		Major aMajor = findMajor(major);
		this.major = aMajor;
	}

	private void changeGPA() {
		double gpaPoints = 0.0;
		for(CompletedCourse c : coursesCompleted){
			gpaPoints += (c.getGrade() * c.getCredits());
		}
		double gpa = (gpaPoints)/credits;
		if (gpa < 0.0 || gpa > 4.0) {
			throw new InvalidDataException();
		}
		else{
			this.gpa = gpa;
		}
	}

	public void changeCreditsEarned(Integer credits) {
		if (credits < 1 || credits > 4) {
			throw new ModificationException();
		} else
			this.credits += credits;
	}

	public String getMajor() {
		return major.getMajor();
	}

	public LocalDate getEnrolledDate() {
		return enrollDate;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public Double getGPA() {
		return gpa;
	}

	public Integer getCredits() {
		return credits;
	}

	public String getSocial() {
		return SSN;
	}

	public ArrayList<CompletedCourse> getCourses() {
		ArrayList<CompletedCourse> coursesCopy = new ArrayList<CompletedCourse>();
		for (CompletedCourse aCourse : coursesCompleted) {
			coursesCopy.add(new CompletedCourse(aCourse.getCourseID(), aCourse
					.getDescription(), aCourse.getCredits(), aCourse
					.getDepartmentID(), aCourse.getStudent(), aCourse
					.getGrade(), aCourse.getCompletedDate().getMonthValue(),
					aCourse.getCompletedDate().getDayOfMonth(), aCourse
							.getCompletedDate().getYear()));
		}
		return coursesCopy;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("\nStudent ");
		buffer.append(super.toString());
		buffer.append(" Major: " + major.getMajor());
		buffer.append(" GPA: " + getGPA());
		buffer.append(" Credits Earned: " + getCredits());
		buffer.append(" Social Security Number: " + getSocial());
		buffer.append(" Date Enrolled: " + getEnrolledDate().toString());
		buffer.append(" Date of Birth: " + getDateOfBirth().toString());
		buffer.append(" Courses Completed: ");
		for (CompletedCourse a : coursesCompleted) {
			buffer.append(a.toString() + " ");
		}
		return buffer.toString();
	}

	public void completeCourse(Course c, Double grade, Integer month, Integer day, Integer year) {

		for (CompletedCourse aCourse : coursesCompleted) {
			if (aCourse.getCourseID().equals(c.getCourseID())) {
				if(aCourse.getGrade() > 1.7){//If a student failed, you
					//can allow him to take it again.
				throw new DuplicateDataException();
				}
			} 
		}
		coursesCompleted.add(new CompletedCourse(c.getCourseID(), c
				.getDescription(), c.getCredits(), c.getDepartmentID(),
				ID, grade, month, day, year));
		changeCreditsEarned(c.getCredits());
		changeGPA();
	}

	public CompletedCourse findCompletedCourse(String courseID) {
		for (CompletedCourse a : coursesCompleted) {
			if (a.getCourseID().equalsIgnoreCase(courseID)) {
				return a;
			}
		}
		return null;
	}

	public Double getGradeOfCourses(String courseID) {
		for (CompletedCourse a : coursesCompleted) {
			if (a.getCourseID().equalsIgnoreCase(courseID)) {
				return a.getGrade();
			}
		}
		return null;
	}

	public ArrayList<CompletedCourse> getCoursesByDepartment(
			String departmentID) {
		ArrayList<CompletedCourse> courses = new ArrayList<CompletedCourse>();
		for (CompletedCourse a : coursesCompleted) {
			if (a.getDepartmentID().equalsIgnoreCase(departmentID)) {
				courses.add(new CompletedCourse(a.getCourseID(), a
						.getDescription(), a.getCredits(), a
						.getDepartmentID(), ID, a.getGrade(), a
						.getCompletedDate().getMonthValue(), a.getCompletedDate().getDayOfMonth(), a.getCompletedDate().getYear()));
			}
		}
		return courses;
	}

	public ArrayList<CompletedCourse> getCoursesbyGrade(Double g) {
		ArrayList<CompletedCourse> courses = new ArrayList<CompletedCourse>();
		Grade aGrade = findGrade(g);
		for (CompletedCourse a : coursesCompleted) {
			if (a.getGrade() == aGrade.getGrade()) {
				courses.add(new CompletedCourse(a.getCourseID(), a
						.getDescription(), a.getCredits(), a
						.getDepartmentID(), ID, a.getGrade(), a
						.getCompletedDate().getMonthValue(), a.getCompletedDate().getDayOfMonth(), a.getCompletedDate().getYear()));
			}
		}
		return courses;
	}

	private Major findMajor(String major) {
		if (major != null) {
			for (Major aMajor : Major.values()) {
				if (aMajor.getMajor().equalsIgnoreCase(major)) {
					return aMajor;
				}
				if(aMajor.getMajorID().equalsIgnoreCase(major)){
					return aMajor;
				}
			}
		}
		return Major.UDCD;
	}

	private Grade findGrade(Double grade) {
		Double mark = 0.0;
		if (grade == 4.0) {
			mark = 4.00;
		} else if (grade < 4.0 && grade >= 3.7) {
			mark = 3.7;
		} else if (grade < 3.7 && grade >= 3.3) {
			mark = 3.3;
		} else if (grade < 3.3 && grade >= 3.0) {
			mark = 3.0;
		} else if (grade < 3.0 && grade >= 2.7) {
			mark = 2.7;
		} else if (grade < 2.7 && grade >= 2.3) {
			mark = 2.3;
		} else if (grade < 2.3 && grade >= 2.0) {
			mark = 2.0;
		} else if (grade < 2.0 && grade >= 1.7) {
			mark = 1.7;
		} else if (grade < 1.7 && grade >= 1.3) {
			mark = 1.3;
		} else if (grade >= 1.0) {
			mark = 1.0;
		} else if (grade >= 0.7) {
			mark = 0.7;
		} else
			mark = 0.0;

		for (Grade aGrade : Grade.values()) {
			if (mark == aGrade.getGrade())
				return aGrade;
		}
		return null;
	}
}