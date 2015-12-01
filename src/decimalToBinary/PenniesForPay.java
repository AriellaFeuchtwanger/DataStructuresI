package decimalToBinary;

//Lauren Drebin

import java.util.Scanner;

public class PenniesForPay {
	public static void main(String args[]) {
		Scanner money = new Scanner(System.in);

		int day;
		System.out.println("Enter the number of days you worked");
		day = money.nextInt();

		double salary;
		double total = 0.0;
		salary = 0.01;

		for (int i = 0; i < day; i++) {
			salary = salary * 2;
			total += salary;
			System.out.println("Your salary is " + salary);
		}

		System.out.println("Total: " + total);
	}

}
