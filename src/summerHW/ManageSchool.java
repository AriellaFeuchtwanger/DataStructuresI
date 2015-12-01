package summerHW;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageSchool {
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		System.out
				.println("Welcome to your new school! First, let's collect some information.");
		System.out.println("First, what is the name of your school?");
		String schoolName = keyboard.next();
		keyboard.nextLine();
		System.out
				.println("Please enter the number and street of your school.");
		String street = keyboard.nextLine();
		System.out.println("What city is your school located in?");
		String city = keyboard.next();
		keyboard.nextLine();
		System.out.println("What state is your school located in?");
		String state = keyboard.nextLine();
		System.out.println("What is the zip code for your area?");
		String zip = keyboard.next();
		Address theAddress = new Address(street, city, state, zip);
		System.out.println("What is the school phone number?");
		String phoneNumber = keyboard.next();
		// System.out.println("What is the name of the file for the teacher information?");
		String teachFile = "./teachers.txt";
		// System.out.println("What is the name of the file for the student information?");
		String studentFile = "./students.txt";
		// System.out.println("What is the name of the file for the department information?");
		String deptFile = "./departments.txt";
		// System.out.println("What is the name of the file for the course information?");
		String courseFile = "./courses.txt";

		School yourSchool = new School(schoolName, theAddress, phoneNumber,
				teachFile, deptFile, studentFile, courseFile);

		Character midInitial;
		ArrayList<CompletedCourse>courses;
		Integer choice = menu();
		do {
			switch (choice) {
			case 1:
				System.out.println("Enter ID number: ");
				Integer ID = keyboard.nextInt();
				System.out.println("Enter first name: ");
				String firstName = keyboard.next();
				System.out.println("Enter last name:");
				String lastName = keyboard.next();
				System.out
						.println("If you have a middle initial, please enter Y. If not, enter N.");
				char answer = keyboard.next().charAt(0);
				if (answer == 'Y' || answer == 'y') {
					System.out.println("Enter the middle initial now.");
					midInitial = keyboard.next().charAt(0);
				} else
					midInitial = null;
				keyboard.nextLine();
				System.out.println("Enter the number and street: ");
				street = keyboard.nextLine();
				System.out.println("Enter the city: ");
				city = keyboard.nextLine();
				System.out.println("Enter the state: ");
				state = keyboard.nextLine();
				System.out.println("Enter the zip: ");
				zip = keyboard.next();
				System.out.println("Enter the gender: ");
				Character gender = keyboard.next().charAt(0);
				System.out
						.println("Enter the department ID of the department the teacher is part of: ");
				String deptID = keyboard.next();
				System.out
						.println("Enter the date the teacher was hired in MM/DD/YYYY format: ");
				String hireDate1 = keyboard.next();
				String[] hireDate2 = hireDate1.split("/");
				System.out
						.println("Enter the teacher's date of birth in MM/DD/YYYY format: ");
				String birthDate = keyboard.next();
				String[] birthDate2 = birthDate.split("/");
				System.out
						.println("Choose an employee type : Professor, Instructor, or Chairperson");
				String employeeTypeID = keyboard.next();
				System.out.println("Enter the social security number: ");
				String SSN = keyboard.next();
				System.out.println("Enter the degree ID: ");
				String degreeID = keyboard.next();
				System.out.println("Enter the major ID: ");
				String majorID = keyboard.nextLine();
				System.out.println("Enter the teacher's salary: ");
				Double salary = keyboard.nextDouble();
				System.out.println("Enter phone number: ");
				phoneNumber = keyboard.next();

				try {
					addTeacher(yourSchool, ID, firstName, lastName, midInitial,
							street, city, state, zip, phoneNumber, gender,
							Integer.parseInt(birthDate2[0]),
							Integer.parseInt(birthDate2[1]),
							Integer.parseInt(birthDate2[2]),
							Integer.parseInt(hireDate2[0]),
							Integer.parseInt(hireDate2[1]),
							Integer.parseInt(hireDate2[2]), employeeTypeID,
							deptID, SSN, degreeID, majorID, salary);
				} catch (DuplicateDataException e) {
					System.out
							.println("There is already a teacher with this ID in the school. "
									+ "Please enter a new ID number for this teacher.");
				} catch (InvalidDataException e1) {
					System.out
							.println("Some of the information you entered was "
									+ "incorrect. Please try entering the information again.");
				}
				break;
			case 2:
				System.out.println("Enter ID number: ");
				ID = keyboard.nextInt();
				System.out.println("Enter first name: ");
				firstName = keyboard.next();
				System.out.println("Enter last name:");
				lastName = keyboard.next();
				System.out
						.println("If you have a middle initial, please enter Y. If not, enter N.");
				answer = keyboard.next().charAt(0);
				if (answer == 'Y' || answer == 'y') {
					System.out.println("Enter the middle initial now.");
					midInitial = keyboard.next().charAt(0);
				} else
					midInitial = null;
				keyboard.nextLine();
				System.out.println("Enter the number and street: ");
				street = keyboard.nextLine();
				System.out.println("Enter the city: ");
				city = keyboard.nextLine();
				System.out.println("Enter the state: ");
				state = keyboard.nextLine();
				System.out.println("Enter the zip: ");
				zip = keyboard.next();
				System.out.println("Enter the gender: ");
				gender = keyboard.next().charAt(0);
				System.out
						.println("Enter the date the student enrolled in MM/DD/YYYY format: ");
				String enrollDate1 = keyboard.next();
				String[] enrollDate2 = enrollDate1.split("/");
				System.out
						.println("Enter the student's date of birth in MM/DD/YYYY format: ");
				birthDate = keyboard.next();
				birthDate2 = birthDate.split("/");
				System.out.println("Enter the social security number: ");
				SSN = keyboard.next();
				System.out
						.println("Enter the major ID. If the student is undecided, put in 'undecided'.");
				majorID = keyboard.nextLine();
				System.out.println("Enter phone number: ");
				phoneNumber = keyboard.next();
				try {
					addStudent(yourSchool, ID, firstName, lastName, midInitial,
							street, city, state, zip, phoneNumber, gender, majorID,
							Integer.parseInt(enrollDate2[0]),
							Integer.parseInt(enrollDate2[1]),
							Integer.parseInt(enrollDate2[2]), Integer.parseInt(birthDate2[0]),
							Integer.parseInt(birthDate2[1]),
							Integer.parseInt(birthDate2[2]), SSN);
				} catch (DuplicateDataException e) {
					System.out
							.println("There is already a student with this ID in the school. "
									+ "Please enter a new ID number for this student.");
				} catch (InvalidDataException e1) {
					System.out
							.println("Some of the information you entered was "
									+ "incorrect. Please try entering the information again.");
				}
				break;
			case 3:
				System.out.println("What is the ID number for the course?");
				String courseID = keyboard.next();
				keyboard.nextLine();
				System.out.println("Enter the name of the course: ");
				String name = keyboard.nextLine(); // Using the nextLine() as
				// opposed to next() because a course could have a multi-word
				// name;
				System.out
						.println("Enter the number of credits this course is worth: ");
				Integer credits = keyboard.nextInt();
				System.out
						.println("Enter the ID of the department this course is part of: ");
				deptID = keyboard.next();
				try {
					addCourse(yourSchool, courseID, name, credits, deptID);
				} catch (DuplicateDataException e) {
					System.out.println("This course is already in the school.");
				} catch (InvalidDataException e1) {
					System.out
							.println("Some of the information you entered was "
									+ "incorrect. Please try entering the information again.");
				}
				break;
			case 4:
				System.out.println("What is the department ID?");
				deptID = keyboard.next();
				keyboard.nextLine();
				System.out.println("What is the department name?");
				name = keyboard.nextLine();
				System.out.println("Where is the department located?");
				String location = keyboard.nextLine();
				System.out.println("Phone Number: ");
				phoneNumber = keyboard.next();
				System.out.println("Fax Number: ");
				String fax = keyboard.next();
				System.out
						.println("What is the ID of the department chairperson?");
				Integer chairperson = keyboard.nextInt();

				try {
					addDepartment(yourSchool, deptID, name, location, phoneNumber,
							fax, chairperson);
				} catch (DuplicateDataException e) {
					System.out.println("This department is already in the school.");
				} catch (InvalidDataException e1) {
					System.out
							.println("Some of the information you entered was "
									+ "incorrect. Please try entering the information again.");
				}
				break;
			case 5:
				System.out
						.println("Please enter the ID of the teacher you would like removed.");
				ID = keyboard.nextInt();
				try {
					removeTeacher(yourSchool, ID);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Teacher was not found and could not be removed.");
				}
				break;
			case 6:
				System.out
						.println("Please enter the ID of the student you would like removed");
				ID = keyboard.nextInt();
				try {
					removeStudent(yourSchool, ID);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Student was not found and could not be removed.");
				}
				break;
			case 7:
				System.out
						.println("Please enter the ID of the course you wish removed.");
				courseID = keyboard.next();
				try {
					removeCourse(yourSchool, courseID);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Course was not found and could not be removed.");
				}
				break;
			case 8:
				System.out.println("Enter the ID of the teacher: ");
				ID = keyboard.nextInt();
				System.out.println("Enter the new last name of the teacher: ");
				lastName = keyboard.next();
				try {
					modifyTeacherLastName(yourSchool, ID, lastName);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Teacher was not found and the last name could not be changed.");
				} catch (ModificationException e2) {
					System.out
							.println("The last name you have entered is invalid.");
				}
				break;
			case 9:
				System.out.println("Enter the ID of the teacher: ");
				ID = keyboard.nextInt();
				keyboard.nextLine();
				System.out.println("City: ");
				city = keyboard.nextLine();
				System.out.println("State: ");
				state = keyboard.nextLine();
				System.out.println("Zip Code: ");
				zip = keyboard.next();
				keyboard.nextLine();
				System.out.println("Number and Street: ");
				street = keyboard.nextLine();

				try {
					modifyTeacherAddress(yourSchool, ID, city, state, street,
							zip);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Teacher could not be found and address was not changed.");
				} catch (ModificationException e2) {
					System.out
							.println("The information you typed in had a problem and the address could not be changed.");
				} catch(InvalidDataException e3){
					System.out.println("The state was invalid and the address could not be changed.");
				}
				break;
			case 10:
				System.out.println("Enter the ID of the teacher: ");
				ID = keyboard.nextInt();
				System.out.println("Enter the new degree: ");
				degreeID = keyboard.next();
				try {
					modifyTeacherDegree(yourSchool, ID, degreeID);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Teacher was not found and degree could not be modified.");
				} catch (ModificationException e2) {
					System.out
							.println("The degree you have entered is invalid.");
				}
				break;
			case 11:
				System.out.println("Enter teacher ID: ");
				ID = keyboard.nextInt();
				System.out
						.println("Enter the amount you would like to raise the teacher's salary by: ");
				Double amount = keyboard.nextDouble();
				try {
					giveTeacherRaiseAmount(yourSchool, ID, amount);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Teacher could not be found and raise could not be applied");
				} catch (InvalidDataException e2) {
					System.out
							.println("The raise you are giving the teacher is out of bound."
									+ " Please go back and try a new amount.");
				
				}
				break;
			case 12:
				System.out.println("Enter teacher ID: ");
				ID = keyboard.nextInt();
				System.out
						.println("Enter the percent you would like to raise the teacher's salary by: ");
				amount = keyboard.nextDouble();
				try {
					giveTeacherRaisePercent(yourSchool, ID, amount);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Teacher could not be found and raise could not be applied");
				} catch (InvalidDataException e2) {
					System.out
							.println("The raise you are giving the teacher is out of bound."
									+ " Please go back and try a new amount.");
				}
				break;
			case 13:
				System.out.println("Enter student ID: ");
				ID = keyboard.nextInt();
				System.out.println("Enter the new last name: ");
				lastName = keyboard.next();
				try {
					modifyStudentLastName(yourSchool, ID, lastName);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Student could not be found and last name could not be modified.");
				} catch (ModificationException e2) {
					System.out
							.println("There was a problem with the data you entered.");
				}
				break;
			case 14:
				System.out.println("Enter student ID: ");
				ID = keyboard.nextInt();
				System.out.println("Enter the new phone number: ");
				phoneNumber = keyboard.next();
				try {
					modifyStudentLastName(yourSchool, ID, phoneNumber);
				} catch (DataNotFoundException e1) {
					System.out
							.println("Student could not be found and last name could not be modified.");
				} catch (ModificationException e2) {
					System.out
							.println("There was a problem with the data you entered.");
				}
				break;
			case 15:
				System.out.println("Enter the student ID: ");
				ID = keyboard.nextInt();
				System.out
						.println("Enter the ID of the course you would like to add: ");
				courseID = keyboard.next();
				System.out.println("Enter the numerical grade of the course: ");
				Double grade = keyboard.nextDouble();
				System.out.println("Enter the date the course was completed in MM/DD/YY format");
				String date = keyboard.next();
				String[] completion = date.split("/");
				try {
					addCompletedCourse(yourSchool, ID, courseID, grade, Integer.parseInt(completion[0]), Integer.parseInt(completion[1]), Integer.parseInt(completion[2]));
				} catch (DataNotFoundException e1) {
					System.out
							.println("The student or course could not be found and the course was not added.");
				} catch (InvalidDataException e2) {
					System.out
							.println("There was a problem with the information you entered and the course was not added.");
				} catch (DuplicateDataException e3){
					System.out.println("The student has already taken this course.");
				}
				break;
			case 16:
				System.out.println("Enter student ID: ");
				ID = keyboard.nextInt();
				try {
					Double gpa = getStudentGPA(yourSchool, ID);
					DecimalFormat formatter = new DecimalFormat("#.00");
					System.out.println("GPA: " + formatter.format(gpa));
				} catch (DataNotFoundException e1) {
					System.out.println("Student could not be found.");
				}
				break;
			case 17:
				System.out.println("Enter student ID: ");
				ID = keyboard.nextInt();
				System.out.println("Enter course ID: ");
				courseID = keyboard.next();
				try {
					grade = getGradeOfCourse(yourSchool, ID, courseID);
					DecimalFormat formatter = new DecimalFormat("#.00");
					System.out.println("Grade of course: " + formatter.format(grade));
				} catch (DataNotFoundException e1) {
					System.out.println("Student or course could not be found.");
				}
				break;
			case 18:
				System.out.println("Enter student ID: ");
				ID = keyboard.nextInt();
				System.out.println("Enter department ID: ");
				deptID = keyboard.next();
				try {
					courses = getCoursesByDept(yourSchool, ID, deptID);
					System.out.println("Courses: ");
					for (CompletedCourse a : courses) {
						System.out.println(a.toString());
					}
				} catch (DataNotFoundException e1) {
					System.out.println("Student could not be found.");
				}
				break;
			case 19:
				System.out.println("Enter student ID: ");
				ID = keyboard.nextInt();
				System.out.println("Enter the grade you would like: ");
				grade = keyboard.nextDouble();
				try {
					courses = getCoursesByGrade(yourSchool, ID, grade);
					System.out.println("Courses by Grade: ");
					for (CompletedCourse a : courses) {
						System.out.println(a.toString());
					}
				} catch (DataNotFoundException e1) {
					System.out.println("Student could not be found.");
				}
				break;
			case 20:
				ArrayList<Teacher> teachers = getTeachers(yourSchool);
				System.out.println("Teachers (by ID) : ");
				for (Teacher t : teachers) {
					System.out.println(t.toString());
				}
				break;
			case 21:
				teachers = getTeachersSortedByName(yourSchool);
				System.out.println("Teachers (by name): ");
				for (Teacher t : teachers) {
					System.out.println(t.toString());
				}
				break;
			case 22:
				ArrayList<Student> students = getStudents(yourSchool);
				System.out.println("Students (by ID): ");
				for (Student s : students) {
					System.out.println(s.toString());
				}
				break;
			case 23:
				students = getStudentsSortedByName(yourSchool);
				System.out.println("Students (by name): ");
				for (Student s : students) {
					System.out.println(s.toString());
				}
				break;
			case 24:
				System.out.println("Enter teacher ID: ");
				ID = keyboard.nextInt();
				System.out.println("Enter course ID: ");
				courseID = keyboard.next();
				System.out.println("Enter the year: ");
				Integer year = keyboard.nextInt();
				System.out.println("Enter the semester: ");
				String semester = keyboard.next();
				System.out.println("Enter the section: ");
				String section = keyboard.next();
				try {
					addTaughtCourse(yourSchool, ID, courseID, year, semester,
							section);
				} catch (DataNotFoundException e1) {
					System.out.println("Teacher or course could not be found.");
				} catch (ModificationException e2) {
					System.out.println("Whoops! Looks like there was a problem with the info you put in.");
				} 
				break;
			case 25:
				System.out.println("Enter teacher ID: ");
				ID = keyboard.nextInt();
				System.out.println("Enter year: ");
				year = keyboard.nextInt();
				System.out.println("Enter semester: ");
				semester = keyboard.next();
				try {
					Integer courseAmount = howManyCoursesPerSemester(yourSchool, ID, year,
							semester);
					System.out.println("Number of courses for " + semester
							+ " " + year + ": " + courseAmount);
				} catch (DataNotFoundException e1) {
					System.out.println("Data could not be found.");
				} catch (ModificationException e2) {
					System.out.println("Invalid semester");
				}
				break;
			case 26:
				System.out.println(yourSchool.toString());
			}
			choice = menu();
		} while (choice != 0);
		System.out.println("Have a good day!");
	}

	public static Integer menu() {
		Scanner keyboard = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Menu");
			System.out
					.println("1. Add teacher\n2. Add student\n3. Add course"
							+ "\n4. Add department\n5. Remove teacher\n6. Remove student\n7. Remove course"
							+ "\n8. Modify Teacher Last Name\n9. Modify Teacher Address"
							+ "\n10. Modify Teacher Degree\n11. Give teacher raise - amount\n12. Give teacher raise"
							+ " - percent\n13. Modify student's last name\n14. Modify student's phone number"
							+ "\n15. Add completed course for student\n16. Get student GPA\n17. Get grade of course"
							+ "\n18. Get Courses by Department\n19. Get student's courses by grade"
							+ "\n20. Get teachers sorted by ID\n21. Get teachers sorted alphabetically"
							+ "\n22. Get students sorted by ID\n23. Get students sorted alphabetically"
							+ "\n24. Add taught course for teacher\n25. Find the number of courses taught "
							+ "by a teacher in a specific semester\n26. View school info\n0. Exit School");
			choice = keyboard.nextInt();
		} while (choice > 26 || choice < 0);
		return choice;
	}

	public static void addTeacher(School yourSchool, Integer ID,
			String firstName, String lastName, Character midInitial,
			String street, String city, String state, String zip,
			String phoneNumber, Character gender, Integer monthBirth,
			Integer dayBirth, Integer yearBirth, Integer monthHire,
			Integer dayHire, Integer yearHire, String employeeTypeID,
			String deptID, String SSN, String degreeID, String majorID,
			Double salary) {
		yourSchool.addTeacher(ID, firstName, lastName, midInitial, street,
				city, state, zip, phoneNumber, gender, monthBirth, dayBirth,
				yearBirth, monthHire, dayHire, yearHire, employeeTypeID,
				majorID, deptID, SSN, degreeID, salary);
	}

	public static void addStudent(School yourSchool, Integer ID,
			String firstName, String lastName, Character midInitial,
			String street, String city, String state, String zip,
			String phoneNumber, Character gender, String majorID,
			Integer monthBirth, Integer dayBirth, Integer yearBirth,
			Integer monthEnroll, Integer dayEnroll, Integer yearEnroll,
			String SSN) {
		yourSchool.addStudent(ID, firstName, lastName, midInitial, street,
				city, state, zip, phoneNumber, gender, majorID, monthBirth,
				dayBirth, yearBirth, monthEnroll, dayEnroll, yearEnroll, SSN);
	}

	public static void addCourse(School yourSchool, String ID, String name,
			Integer credits, String deptID) {
		yourSchool.addCourse(ID, name, credits, deptID);
	}

	public static void addDepartment(School yourSchool, String ID, String name,
			String location, String phone, String fax, Integer chairperson) {
		yourSchool.addDept(ID, name, location, phone, fax, chairperson);
	}

	public static void removeTeacher(School yourSchool, Integer ID) {
		yourSchool.removeTeacher(ID);
	}

	public static void removeStudent(School yourSchool, Integer ID) {
		yourSchool.removeStudent(ID);
	}

	public static void removeCourse(School yourSchool, String ID) {
		yourSchool.removeCourse(ID);
	}

	public static void modifyTeacherLastName(School yourSchool, Integer ID,
			String lastName) {
		yourSchool.modifyTeacherLastName(ID, lastName);
	}

	public static void modifyTeacherAddress(School yourSchool, Integer ID,
			String city, String state, String street, String zip) {
		yourSchool.modifyTeacherAddress(ID, street, city, state, zip);
	}

	public static void modifyTeacherDegree(School yourSchool, Integer ID,
			String degree) {
		yourSchool.modifyTeacherDegree(ID, degree);
	}

	public static void giveTeacherRaisePercent(School yourSchool, Integer ID,
			Double percent) {
		yourSchool.giveTeacherRaisePercent(ID, percent);
	}

	public static void giveTeacherRaiseAmount(School yourSchool, Integer ID,
			Double amount) {
		yourSchool.giveTeacherRaise(ID, amount);
	}

	public static void modifyStudentLastName(School yourSchool, Integer ID,
			String lastName) {
		yourSchool.modifyStudentLastName(ID, lastName);
	}

	public static void modifyStudentPhoneNumber(School yourSchool, Integer ID,
			String phone) {
		yourSchool.modifyStudentPhoneNumber(ID, phone);
	}

	public static void addCompletedCourse(School yourSchool, Integer ID,
			String courseID, double grade, Integer month, Integer day, Integer year) {
		yourSchool.addCompletedCourse(ID, courseID, grade, month, day, year);
	}

	public static Double getStudentGPA(School yourSchool, Integer ID) {
		Double gpa = yourSchool.getStudentGPA(ID);
		return gpa;
	}

	public static Double getGradeOfCourse(School yourSchool, Integer ID,
			String courseID) {
		return yourSchool.getGradeOfCourse(ID, courseID);
	}

	public static ArrayList<CompletedCourse> getCoursesByDept(
			School yourSchool, Integer ID, String deptID) {
		return yourSchool.getCoursesbyDepartment(ID, deptID);
	}

	public static ArrayList<CompletedCourse> getCoursesByGrade(
			School yourSchool, Integer ID, Double grade) {
		return yourSchool.getCoursesbyGrade(ID, grade);
	}

	public static ArrayList<Teacher> getTeachers(School yourSchool) {
		return yourSchool.getTeachersByID();
	}

	public static ArrayList<Teacher> getTeachersSortedByName(School yourSchool) {
		return yourSchool.getTeachersSortedbyName();
	}

	public static ArrayList<Student> getStudents(School yourSchool) {
		return yourSchool.getStudentsByID();
	}

	public static ArrayList<Student> getStudentsSortedByName(School yourSchool) {
		return yourSchool.getStudentsSortedbyName();
	}

	public static void addTaughtCourse(School yourSchool, Integer ID,
			String courseID, Integer year, String semester, String section) {
		yourSchool.addTaughtCourse(ID, courseID, year, semester, section);
	}

	public static Integer howManyCoursesPerSemester(School yourSchool,
			Integer ID, Integer year, String semester) {
		return yourSchool.howManyCoursesPerSemester(ID, year, semester);
	}
}
