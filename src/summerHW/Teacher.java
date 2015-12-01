package summerHW;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Teacher extends Employee {
	private String deptID;
	private String SSN;
	private Degree degree;
	private Major major;
	private Double salary;
	ArrayList<TaughtCourse> courses = new ArrayList<TaughtCourse>();

	public Teacher(Integer ID, String firstName, String lastName,
			String street, String city, String state, String zip,
			Character gender, Integer monthBirth, Integer dayBirth,
			Integer yearBirth, Integer monthHire, Integer dayHire,
			Integer yearHire, String employeeTypeID, String majorID,
			String departmentID, String socialSecurityNum, String degreeID,
			Double salary) {
		this(ID, firstName, lastName, null, street, city, state, zip, null,
				gender, monthBirth, dayBirth, yearBirth, monthHire, dayHire,
				yearHire, employeeTypeID, majorID, departmentID,
				socialSecurityNum, degreeID, salary, null);

	}

	public Teacher(Integer ID, String firstName, String lastName,
			Character midInitial, String street, String city, String state,
			String zip, String phoneNumber, Character gender,
			Integer monthBirth, Integer dayBirth, Integer yearBirth,
			Integer monthHire, Integer dayHire, Integer yearHire,
			String employeeTypeID, String majorID, String departmentID,
			String socialSecurityNum, String degreeID, Double salary, ArrayList<TaughtCourse> courses) {
		super(ID, firstName, lastName, midInitial, street, city, state, zip,
				phoneNumber, gender, monthBirth, dayBirth, yearBirth,
				monthHire, dayHire, yearHire, employeeTypeID, majorID);

		Degree test = findDegree(degreeID);
		if (test == null)
			throw new InvalidDataException();
		else
			this.degree = test;

		if (salary <= 0.0) {
			throw new InvalidDataException();
		} else {
			if (salary < 10000 || salary > 100000) {
				throw new InvalidDataException();
			} else
				this.salary = salary;
		}

		if (departmentID != null) {
			this.deptID = departmentID;
		} else {
			throw new InvalidDataException();
		}
		
		if(socialSecurityNum.length() == 9){
			SSN = socialSecurityNum;
		}
		else{
			throw new InvalidDataException();
		}
		
		if(courses != null){
			for(TaughtCourse t : courses){
				this.courses.add(new TaughtCourse(t.getCourseID(), t.getDescription(),
								t.getCredits(), t.getDepartmentID(), this.ID, t.getYear(),
								t.getSemester(), t.getSection()));
			}
		}
	}

	public String getSSN() {
		return SSN;
	}
	
	public Degree getDegree() {
		String degreeID = degree.getDegree();
		return findDegree(degreeID); // If degree isn't null (which it shouldn't
										// be)
		// this will return a copy of the same degree;
	}

	public Double getSalary() {
		return salary;
	}

	public String getDepartmentID() {
		return deptID;
	}

	public ArrayList<TaughtCourse> getCourses(){
		ArrayList<TaughtCourse> courses = new ArrayList<TaughtCourse>();
		if(this.courses != null){
			for(TaughtCourse t : this.courses){
				courses.add(new TaughtCourse(t.getCourseID(), t.getDescription(),
								t.getCredits(), t.getDepartmentID(), this.ID, t.getYear(),
								t.getSemester(), t.getSection()));
			}
		}
		return courses;
	}
	public void changeDegree(String degreeID) {
		Degree test = findDegree(degreeID);
		if (test == null) {
			throw new ModificationException();
		} else
			this.degree = test;
	}

	public void changeMajor(String majorID) {
		Major test = findMajor(majorID);
		if (test == null) {
			throw new ModificationException(); // A teacher can't have
			// an undecided major
		} else
			this.major = test;
	}

	public void raiseSalary(Double amount) {
		if (amount > 0 && amount <= 10000) {
			this.salary += amount;
		} else
			throw new InvalidDataException();
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(super.toString());
		buffer.append(" Degree Obtained: " + degree.getDegree());
		if (major != null)
			buffer.append(" Major: " + major.getMajor());
		//buffer.append(" Taught Courses: " + getCourses().toString());
		
		if(getCourses() != null){
			for(TaughtCourse t : courses){
				buffer.append(t.toString());
			}
		}
		else{
			buffer.append("None ");
		}
		DecimalFormat formatter = new DecimalFormat("$#.00");
		buffer.append(" Salary: $" + formatter.format(getSalary()));

		return buffer.toString();
	}

	public void applyRaise(Double percent) {
		if (percent > 5 || percent < 0)
			throw new InvalidDataException();
		else
			salary = (salary * percent) + salary;
	}

	public void addTaughtCourse(String courseID, String description,
			Integer numCredits, String departmentID, Integer year,
			String semesterID, String sectionID) {
		TaughtCourse t = new TaughtCourse(courseID, description, numCredits,
				departmentID, ID, year, semesterID, sectionID);
		for (TaughtCourse course : this.courses) {
			if (t.equals(course)) {
				throw new DuplicateDataException();
			}
		}
		courses.add(t);
	}

	public int howManyCoursesPerSemester(Integer year, String semesterID) {
		int number = 0;
		for (TaughtCourse aCourse : courses) {
			if (aCourse.getYear() == year) {
				if (aCourse.getSemester().equalsIgnoreCase(semesterID)) {
					number++;
				}
			}
		}
		return number;
	}

	public int howManyDifferentCourses() {
		int number = 0;
		ArrayList<Integer> courseID = new ArrayList<Integer>();
		// holds an array of the course IDs
		for (TaughtCourse t : courses) {
			for (Integer i : courseID) {
				if (!t.getCourseID().equals(i)) {
					courseID.add(i);
					number++;
				}
			}
		}
		return number;
	}

	private static Degree findDegree(String degreeID) {
		for (Degree aDegree : Degree.values()) {
			if (aDegree.getDegree().equalsIgnoreCase(degreeID))
				return aDegree;
		}
		return null;
	}

}
