package decimalToBinary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
	private Stack<Integer> numStack;
	
	public DecimalToBinary(){
		numStack = new Stack<Integer>();
	}
	
	public Integer calculateBinary(Integer decimal){
		while(decimal != 0){
			numStack.push(decimal%2);
			decimal = decimal/2;
		}
		
		StringBuffer binary = new StringBuffer();
		
		while(!numStack.isEmpty()){
			binary.append(numStack.pop());
		}
		
		return Integer.parseInt(binary.toString());
	}
	
	public static void main(String[] args){
		DecimalToBinary d = new DecimalToBinary();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the integer you would like to calculate using "+
		"the decimal format: ");
		int decimal = keyboard.nextInt();
		int binary = d.calculateBinary(decimal);
		System.out.println("The binary value of " + decimal + " is " + binary);
	}
}
