package summerHW;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class School {
	private String name;
	private Address address;
	private String phone;
	private ArrayList<Person> people = new ArrayList<Person>();
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Department> departments = new ArrayList<Department>();

	public School(String name, Address address, String phone)
			throws IOException {
		this(name, address, phone, null, null, null, null);
	}

	public School(String name, Address address, String phone,
			String teachFileName, String deptFileName, String studentFileName,
			String courseFileName) throws IOException {
		if (name != null) {
			this.name = name;
		} else {
			throw new InvalidDataException();
		}

		if (address != null) {
			this.address = address;
		} else {
			throw new InvalidDataException();
		}

		if (phone != null) {
			if (phone.length() == 9 || phone.length() == 10) {
				this.phone = phone;
			} else {
				throw new InvalidDataException();
			}
		} else {
			throw new InvalidDataException();
		}

		if (teachFileName != null) {
			Scanner input = new Scanner(new File(teachFileName));

			do {
				Integer teacherID = input.nextInt();
				String firstName = input.next();
				String lastName = input.next();
				input.nextLine();
				String street = input.nextLine();
				String cityState = input.nextLine();
				String[] cityAndState = cityState.split(",");
				String zip = input.next();
				String phoneNum = input.next();
				Character gender = input.next().charAt(0);
				String hireDate = input.next();
				String[] hireDateArray = hireDate.split("/");
				String dateOfBirth = input.next();
				String[] dateOfBirthArray = dateOfBirth.split("/");
				String employeeType = input.next();
				String deptID = input.next();
				String SSN = input.next();
				String degree = input.next();
				String major = input.next();
				Double salary = input.nextDouble();

				people.add(new Teacher(teacherID, firstName, lastName, null,
						street, cityAndState[0], cityAndState[1], zip,
						phoneNum, gender,
						Integer.parseInt(dateOfBirthArray[0]), Integer
								.parseInt(dateOfBirthArray[1]), Integer
								.parseInt(dateOfBirthArray[2]), Integer
								.parseInt(hireDateArray[0]), Integer
								.parseInt(hireDateArray[1]), Integer
								.parseInt(hireDateArray[2]), employeeType,
						major, deptID, SSN, degree, salary, null));

			} while (input.hasNext());
			// input.close();
		} else {
			throw new InvalidDataException();
		}

		if (studentFileName != null) {
			Scanner input = new Scanner(new File(studentFileName));
			do {
				Integer ID = input.nextInt();
				String lastName = input.next();
				String firstName = input.next();
				Character midInitial = input.next().charAt(0);
				input.nextLine();
				String street = input.nextLine();
				String cityState = input.nextLine();
				String[] cityAndState = cityState.split(",");
				String zip = input.next();
				String phoneNum = input.next();
				Character gender = input.next().charAt(0);
				String major = input.next();
				String dateOfBirth = input.next();
				String[] dateOfBirthArray = dateOfBirth.split("/");
				String enrollDate = input.next();
				String[] enrollDateArray = enrollDate.split("/");
				String SSN = input.next();
				String city = cityAndState[0];
				String state = cityAndState[1];

				people.add(new Student(ID, firstName, lastName, midInitial,
						street, city, state, zip, phoneNum, gender, major,
						Integer.parseInt(dateOfBirthArray[0]), Integer
								.parseInt(dateOfBirthArray[1]), Integer
								.parseInt(dateOfBirthArray[2]), Integer
								.parseInt(enrollDateArray[0]), Integer
								.parseInt(enrollDateArray[1]), Integer
								.parseInt(enrollDateArray[2]), SSN));

			} while (input.hasNext());
			// input.close();
		} else {
			throw new InvalidDataException();
		}

		if (courseFileName != null) {
			Scanner input = new Scanner(new File(courseFileName));

			do {
				String[] info = input.nextLine().split(";");
				courses.add(new Course(info[0], info[1], Integer
						.parseInt(info[3]), info[2]));
			} while (input.hasNext());
			// input.close();
		} else {
			throw new InvalidDataException();
		}

		if (deptFileName != null) {
			Scanner input = new Scanner(new File(deptFileName));

			do {
				String[] info = input.nextLine().split(";");
				departments.add(new Department(info[0], info[1], info[2],
						info[3], info[4], Integer.parseInt(info[5])));
			} while (input.hasNext());
			// input.close();
		} else {
			throw new InvalidDataException();
		}
	}

	public void setPhoneNumber(String phone) {
		if (phone == null)
			throw new InvalidDataException();
		else {
			if (phone.length() > 10 || phone.length() < 9)
				throw new ModificationException();
			else
				this.phone = phone;
		}
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return new Address(address.getStreet(), address.getCity(),
				address.getState(), address.getZip());
	}

	public String getPhoneNumber() {
		return phone;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("\nSchool Name: " + getName());
		buffer.append(" Address: " + getAddress().toString());
		buffer.append(" Phone Number: " + getPhoneNumber());
		buffer.append(" Teachers: ");
		for (Person aPerson : people) {
			if (aPerson instanceof Teacher) {
				Teacher aTeacher = (Teacher) aPerson;
				buffer.append(aTeacher.toString() + " ");
			}
		}
		buffer.append(" Students: ");
		for (Person aPerson : people) {
			if (aPerson instanceof Student) {
				Student aStudent = (Student) aPerson;
				buffer.append(aStudent.toString() + " ");
			}
		}

		buffer.append(" Courses Offered: ");
		for (Course aCourse : courses) {
			buffer.append(aCourse.toString() + " ");
		}

		buffer.append(" Departments: ");
		for (Department aDept : departments) {
			buffer.append(aDept.toString() + " ");
		}

		return buffer.toString();
	}

	public void addTeacher(Integer ID, String firstName, String lastName,
			Character midInitial, String street, String city, String state,
			String zip, String phone, Character gender, Integer monthBirth,
			Integer dayBirth, Integer yearBirth, Integer monthHire,
			Integer dayHire, Integer yearHire, String employeeType,
			String major, String deptID, String SSN, String degree,
			Double salary) {
		for (Person p : people) {
			if (p.getID().equals(ID)) {
				throw new DuplicateDataException();
			}
		}
		people.add(new Teacher(ID, firstName, lastName, midInitial, street,
				city, state, zip, phone, gender, monthBirth, dayBirth,
				yearBirth, monthHire, dayHire, yearHire, employeeType, major,
				deptID, SSN, degree, salary, null));

	}

	public void addStudent(Integer ID, String firstName, String lastName,
			Character midInitial, String street, String city, String state,
			String zip, String phone, Character gender, String major,
			Integer monthBirth, Integer dayBirth, Integer yearBirth,
			Integer monthEnroll, Integer dayEnroll, Integer yearEnroll,
			String SSN) {
		for (Person p : people) {
			if (p.getID().equals(ID)) {
				throw new DuplicateDataException();
			}
		}
		people.add(new Student(ID, firstName, lastName, midInitial, street,
				city, state, zip, phone, gender, major, monthBirth, dayBirth,
				yearBirth, monthEnroll, dayEnroll, yearEnroll, SSN));
	}

	public void addCourse(String ID, String name, Integer credits, String deptID) {
		for (Course c : courses) {
			if (c.getCourseID().equalsIgnoreCase(ID)) {
				throw new DuplicateDataException();
			}
		}
		courses.add(new Course(ID, name, credits, deptID));
	}

	public void addDept(String ID, String name, String location, String phone,
			String fax, Integer chairperson) {
		for (Department d : departments) {
			if (d.getDepartmentID().equalsIgnoreCase(ID)) {
				throw new DuplicateDataException();
			}
		}
		departments.add(new Department(ID, name, location, phone, fax,
				chairperson));
	}

	public void removeTeacher(Integer ID) {
		for (Person p : people) {
			if (p.getID().equals(ID)) {
				people.remove(p);
				return;
			}
		}
		throw new DataNotFoundException();
	}

	public void removeStudent(Integer ID) {
		for (Person p : people) {
			if (p.getID().equals(ID)) {
				people.remove(p);
				return;
			}
		}
		throw new DataNotFoundException();
	}

	public void removeCourse(String ID) {
		for (Course c : courses) {
			if (c.getCourseID().equalsIgnoreCase(ID)) {
				courses.remove(c);
				return;
			}
		}
		throw new DataNotFoundException();
	}

	public void modifyTeacherLastName(Integer ID, String lastName) {
		for (Person p : people) {
			if (p.getID().equals(ID)) {
				p.changeLastName(lastName);
				return;
			}
		}
		throw new DataNotFoundException();
	}

	public void modifyTeacherAddress(Integer ID, String street, String city,
			String state, String zip) {
		for (Person p : people) {
			if (p.getID().equals(ID)) {
				p.changeAddress(street, city, state, zip);
				return;
			}
		}
		throw new DataNotFoundException();
	}

	public void modifyTeacherDegree(Integer ID, String degree) {
		for (Person p : people) {
			if (p instanceof Teacher) {
				Teacher t = (Teacher) p;
				if (t.getID().equals(ID)) {
					t.changeDegree(degree);
					return;
				}
			}
		}
		throw new DataNotFoundException();
	}

	public void giveTeacherRaisePercent(Integer ID, Double percent) {
		for (Person p : people) {
			if (p instanceof Teacher) {
				Teacher t = (Teacher) p;
				if (t.getID().equals(ID)) {
					t.applyRaise(percent);
					return;
				}
			}
		}
		throw new DataNotFoundException();
	}

	public void giveTeacherRaise(Integer ID, Double amount) {
		for (Person p : people) {
			if (p instanceof Teacher) {
				Teacher t = (Teacher) p;
				if (t.getID().equals(ID)) {
					t.raiseSalary(amount);
					return;
				}
			}
		}
		throw new DataNotFoundException();
	}

	public void modifyStudentLastName(Integer ID, String name) {
		for (Person aPerson : people) {
			if (aPerson.getID().equals(ID)) {
				aPerson.changeLastName(name);
				return;
			}
		}
		throw new DataNotFoundException();
	}

	public void modifyStudentPhoneNumber(Integer ID, String phoneNumber) {
		for (Person aPerson : people) {
			if (aPerson.getID().equals(ID)) {
				aPerson.changePhoneNumber(phoneNumber);
				return;
			}
		}
		throw new DataNotFoundException();
	}

	public void addCompletedCourse(Integer ID, String courseID, double grade, Integer month, Integer day, Integer year) {
		for (Course a : courses) {
			if (a.getCourseID().equalsIgnoreCase(courseID)) {
				for (Person aPerson : people) {
					if (aPerson.getID().equals(ID)) {
						Student s = (Student) aPerson;
						try{
						s.completeCourse(a, grade, month, day, year);
						}
						catch(InvalidDataException e){
							throw new InvalidDataException();
						}
						return;
					}
				}
			}
		}
		throw new DataNotFoundException();
	}

	public Double getStudentGPA(Integer ID) {
		for (Person aPerson : people) {
			if (aPerson.getID().equals(ID)) {
				Student s = (Student) aPerson;
				return s.getGPA();
			}
		}
		throw new DataNotFoundException();
	}

	public Double getGradeOfCourse(Integer ID, String courseID) {
		for (Person aPerson : people) {
			if (aPerson.getID().equals(ID)) {
				Student s = (Student) aPerson;
				return s.getGradeOfCourses(courseID);
			}
		}
		throw new DataNotFoundException();
	}

	public ArrayList<CompletedCourse> getCoursesbyDepartment(Integer studentID,
			String departmentID) {
		for (Person aPerson : people) {
			if (aPerson.getID().equals(studentID)) {
				Student s = (Student) aPerson;
				return s.getCoursesByDepartment(departmentID);
			}
		}
		throw new DataNotFoundException();
	}

	public ArrayList<CompletedCourse> getCoursesbyGrade(Integer studentID,
			Double g) {
		for (Person aPerson : people) {
			if (aPerson.getID().equals(studentID)) {
				Student s = (Student) aPerson;
				return s.getCoursesbyGrade(g);
			}
		}
		throw new DataNotFoundException();
	}

	public ArrayList<Teacher> getTeachersSortedbyName() {
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		for (Person aPerson : people) {
			if (aPerson instanceof Teacher) {
				Teacher t = (Teacher) aPerson;
				teachers.add(new Teacher(t.getID(), t.getFirstName(), t
						.getLastName(), null, t.getAddress().getStreet(), t
						.getAddress().getCity(), t.getAddress().getState(), t
						.getAddress().getZip(), t.getPhoneNumber(), t
						.getGender(), t.getHireDate().getMonthValue(), t
						.getHireDate().getDayOfMonth(), t.getHireDate()
						.getYear(), t.getDateOfBirth().getMonthValue(), t
						.getDateOfBirth().getDayOfMonth(), t.getDateOfBirth()
						.getYear(), t.getEmployeeType().getType(), t.getMajor()
						.getMajor(), t.getDepartmentID(), t.getSSN(), t
						.getDegree().getDegree(), t.getSalary(), t.getCourses()));
			}

		}
		Collections.sort(teachers, new Comparator<Person>() {
			public int compare(Person t1, Person t2) {
				return t1.getLastName().compareTo(t2.getLastName());
			}
		});
		return teachers;
	}

	public ArrayList<Teacher> getTeachersByID() {
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		for (Person aPerson : people) {
			if (aPerson instanceof Teacher) {
				Teacher t = (Teacher) aPerson;
				teachers.add(t);
			}
		}
		teachers.sort(null);
		return teachers; // Sorted using the compareTo method, which sorts based
							// on IDs
	}

	public ArrayList<Student> getStudentsSortedbyName() {
		ArrayList<Student> students = new ArrayList<Student>();
		for (Person aPerson : people) {
			if (aPerson instanceof Student) {
				Student s = (Student) aPerson;
				students.add(s);
			}
		}

		Collections.sort(students, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		return students;
	}

	public ArrayList<Student> getStudentsByID() {
		ArrayList<Student> students = new ArrayList<Student>();
		for (Person aPerson : people) {
			if (aPerson instanceof Student) {
				Student s = (Student) aPerson;
				students.add(s);
			}
		}
		students.sort(null);

		return students;
	}

	public void addTaughtCourse(Integer ID, String courseID, Integer year,
			String semester, String section) {
		for (Person aPerson : people) {
			if (aPerson.getID().equals(ID)) {
				for (Course a : courses) {
					if (a.getCourseID().equalsIgnoreCase(courseID)) {
						Teacher t = (Teacher) aPerson;
						t.addTaughtCourse(courseID, a.getDescription(),
								a.getCredits(), a.getDepartmentID(), year,
								semester, section);
						return;
					}
				}
			}
		}
		throw new DataNotFoundException();
	}

	public Integer howManyCoursesPerSemester(Integer ID, Integer year,
			String semester) {
		for (Person aPerson : people) {
			if (aPerson.getID().equals(ID)) {
				Teacher t = (Teacher) aPerson;
				return t.howManyCoursesPerSemester(year, semester);
			}
		}
		throw new DataNotFoundException();
	}

	public ArrayList<Course> getCourseList() {
		return courses;
	}
}
