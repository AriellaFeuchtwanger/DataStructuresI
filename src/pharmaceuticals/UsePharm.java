package pharmaceuticals;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class UsePharm {

	public static void main(String[] args) throws IOException {
		PharmacyList pharmacy = new PharmacyList();
		Scanner input = new Scanner(new File("pharmacyCompanies.txt"));
		Scanner keyboard = new Scanner(System.in);
		String code, name, phone;
		while (input.hasNext()) {
			code = input.next();
			phone = input.next();
			name = input.nextLine();
			
			pharmacy.addCompany(code, name, phone);
		}

		int choice = menu();

		do {
			switch (choice) {
			case 1:
				System.out.println("Enter company code: ");
				code = keyboard.next();
				System.out.println("Enter phone number: ");
				phone = keyboard.next();
				System.out.println("Enter company name: ");
				keyboard.nextLine();
				name = keyboard.nextLine(); // In case of a multi-word name

				try {
					addCompany(pharmacy, code, name, phone);
				} catch (DuplicateDataException e) {
					System.out
							.println("Sorry, that data is already in the system.");
				} catch (InvalidDataException e2) {
					System.out
							.println("Sorry, some of the data you entered is invalid.");
				}
				break;
			case 2:
				System.out.println("Enter company code: ");
				code = keyboard.next();
				try {
					removeCompany(pharmacy, code);
				} catch (NotFoundException e1) {
					System.out
							.println("Sorry, that company is not in the system.");
				}
				break;
			case 3:
				System.out.println("Enter company code: ");
				code = keyboard.next();
				System.out.println("Enter new phone number: ");
				phone = keyboard.next();

				try{
				modifyPhoneNumber(pharmacy, code, phone);
				}
				catch(NotFoundException e1){
					System.out.println("Sorry, that company is not in the system.");
				}
				catch(InvalidDataException e2){
					System.out.println("Sorry, that phone number is invalid.");
				}
				break;
			case 4:
				System.out.println("Enter company code: ");
				code = keyboard.next();
				PharmaceuticalCo company;
				try{
				company = displayInfoFromCode(pharmacy, code);

				System.out.println(company.toString());
				}
				catch(NotFoundException e1){
					System.out.println("Sorry, that company is not in the system.");
				}
				break;
			case 5:
				System.out.println("Enter company name: ");
				name = keyboard.next();
				try{
				company = displayInfoFromName(pharmacy, name);

				System.out.println(company.toString());
				}
				catch(NotFoundException e1){
					System.out.println("Sorry, that company is not in the system.");
				}
				break;
			case 6:
				RandomAccessFile raFile = pharmacy.getRAF();
				ArrayList<CompanyCodeIndex> codes = pharmacy.getCompanies();
				Long location;
				System.out.println("Pharmaceutical Companies: ");
				for (CompanyCodeIndex c : codes) {
					if (c.getStatus() == true) {
						location = c.getLocation();
						raFile.seek(location);
						company = new PharmaceuticalCo(raFile.readUTF(),
								raFile.readUTF(), raFile.readUTF());
						System.out.println(company.toString());
					}
				}
				break;
			}
			choice = menu();
		} while (choice != 0);

		System.out.println("Have a great day!");
		input.close();
		keyboard.close();
	}

	public static int menu() {
		Scanner keyboard = new Scanner(System.in);
		int choice;

		do {
			System.out.println("Menu");
			System.out
					.println("1. Add a pharmaceutical company \n2. Remove a pharmaceutical company"
							+ "\n3. Modify company phone number\n4. Display company information (using the code)"
							+ "\n5. Display company information (using the name)\n6. List information about each company"
							+ "\n0. Exit application");
			choice = keyboard.nextInt();
		} while (choice > 10 || choice < 0);

		return choice;
	}

	public static void addCompany(PharmacyList pharm, String code, String name,
			String phone) throws IOException {
		pharm.addCompany(code, name, phone);
	}

	public static void removeCompany(PharmacyList pharm, String code) {
		pharm.removeCompany(code);
	}

	public static void modifyPhoneNumber(PharmacyList pharm, String code,
			String phone) throws IOException {
		pharm.modifyCompanyPhone(code, phone);
	}

	public static PharmaceuticalCo displayInfoFromName(PharmacyList pharm,
			String name) throws IOException {
		return pharm.findCompanyName(name);
	}

	public static PharmaceuticalCo displayInfoFromCode(PharmacyList pharm,
			String code) throws IOException {
		return pharm.findCompanyCode(code);
	}
}
