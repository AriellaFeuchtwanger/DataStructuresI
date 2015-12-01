package pharmaceuticals;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class PharmaceuticalCo {

	private String companyCode;
	private String companyName;
	private String phoneNumber;

	public PharmaceuticalCo(String companyCode, String companyName, String phone) {
		if (companyCode != null)
			this.companyCode = companyCode;
		else
			throw new InvalidDataException();

		if (companyName != null)
			this.companyName = companyName;
		else
			throw new InvalidDataException();

		if (phone != null) {
			if (phone.length() < 9 || phone.length() > 10)
				throw new InvalidDataException();
			else
				this.phoneNumber = phone;
		} else
			throw new InvalidDataException();

		phoneNumber = phone;
	}

	public PharmaceuticalCo(Scanner fileName) {
		if (fileName != null) {
			this.companyCode = fileName.next();
			this.phoneNumber = fileName.next();
			this.companyName = fileName.nextLine();
			// Use nextLine() so that you read
			// in everything, including the spaces.
		} else
			throw new InvalidDataException();
	}

	public PharmaceuticalCo(RandomAccessFile raFile, Long location)
			throws IOException {
		raFile.seek(location);

		this.companyCode = raFile.readUTF();
		this.phoneNumber = raFile.readUTF();
		this.companyName = raFile.readUTF();
	}

	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber != null) {
			if (phoneNumber.length() < 9 || phoneNumber.length() > 10)
				throw new InvalidDataException();
			else
				this.phoneNumber = phoneNumber;
		} else
			throw new InvalidDataException();
	}

	public void writeToFile(RandomAccessFile raFile, Long location)
			throws IOException {
		raFile.seek(location);

		raFile.writeUTF(String.format("%-4s", this.companyCode));
		raFile.writeUTF(String.format("%-25s", this.companyName));
		raFile.writeUTF(String.format("%-10s", this.phoneNumber));
	}

	public int compareTo(PharmaceuticalCo other) {
		return companyCode.compareTo(other.getCompanyCode());
	}

	public boolean equals(Object obj) {
		return false;
	}

	public String toString() {
		StringBuffer b = new StringBuffer();

		b.append("\nCompany Code: " + getCompanyCode());
		b.append(" Company Name: " + getCompanyName());
		b.append(" Phone Number: " + getPhone());
		return b.toString();
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public String getPhone() {
		return phoneNumber;
	}

	public String getCompanyName() {
		return companyName;
	}
}
