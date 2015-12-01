package summerHW;

import java.time.LocalDate;

public class Employee extends Person {
	private LocalDate hireDate;
	private LocalDate dateOfBirth;
	private EmployeeType employeeType;
	private Major major;

	public Employee(Integer ID, String firstName, String lastName,
			String street, String city, String state, String zip,
			Character gender, Integer monthBirth, Integer dayBirth,
			Integer yearBirth, Integer monthHire, Integer dayHire,
			Integer yearHire, String employeeType) {
		this(ID, firstName, lastName, null, street, city, state, zip, null,
				gender, monthBirth, dayBirth, yearBirth, monthHire, dayHire,
				yearHire, employeeType, null);
	}

	public Employee(Integer ID, String firstName, String lastName,
			Character midInitial, String street, String city, String state,
			String zip, String phone, Character gender, Integer monthBirth,
			Integer dayBirth, Integer yearBirth, Integer monthHire,
			Integer dayHire, Integer yearHire, String employeeType, String major) {
		super(ID, firstName, lastName, midInitial, street, city, state, zip,
				phone, gender);

		if (monthBirth != null && dayBirth != null && yearBirth != null) {
			dateOfBirth = LocalDate.of(yearBirth, monthBirth, dayBirth);
		} else {
			throw new InvalidDataException();
		}

		if (monthHire != null && dayHire != null && yearHire != null) {
			hireDate = LocalDate.of(yearHire, monthHire, dayHire);
		} else {
			throw new InvalidDataException();
		}

		EmployeeType aType = findEmployeeType(employeeType);
		if (aType == null) {
			throw new InvalidDataException();
		} else
			this.employeeType = aType;

		this.major = findMajor(major);
	}

	public LocalDate getHireDate() {
		return LocalDate.of(hireDate.getYear(), hireDate.getMonth(),
				hireDate.getDayOfMonth());
	}

	public LocalDate getDateOfBirth() {
		return LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonth(),
				dateOfBirth.getDayOfMonth());
	}

	public Major getMajor() {
		String majorName = major.getMajor();
		return findMajor(majorName);
	}

	public EmployeeType getEmployeeType() {
		String employeeTypeID = employeeType.getType();
		return findEmployeeType(employeeTypeID);
	}

	public void setEmployeeType(String employeeTypeID) {
		if (employeeTypeID != null) {
			EmployeeType aType = findEmployeeType(employeeTypeID);
			if (aType != null) {
				this.employeeType = aType;
			} else
				throw new InvalidDataException();
		} else
			throw new InvalidDataException();
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(super.toString());
		buffer.append(" Date of Birth: " + getDateOfBirth().toString());
		buffer.append(" Date of Hire: " + getHireDate().toString());
		if (major != null) {
			buffer.append(" Major: " + major.getMajor());
		}
		return buffer.toString();
	}

	private static EmployeeType findEmployeeType(String employeeTypeID) {
		for (EmployeeType a : EmployeeType.values()) {
			if (a.getType().equalsIgnoreCase(employeeTypeID)) {
				return a;
			}
		}
		return null;
	}

	protected static Major findMajor(String majorID) {
		for (Major aMajor : Major.values()) {
			if (aMajor.getMajor().equalsIgnoreCase(majorID)) {
				return aMajor;
			}
			if(aMajor.getMajorID().equalsIgnoreCase(majorID)){
				return aMajor;
			}
		}
		return Major.UDCD;
	}
}
