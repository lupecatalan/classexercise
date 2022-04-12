package com.hcl.calculatormaven;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// banner
		printSplashBanner();
		
		// scanner
		Scanner input = new Scanner(System.in);
		
		while (true) {
			
			// create a BinaryOperation class 
			BinaryOperation binaryOperation = getAllInputs(input);

			// switch cases dependent on operation chosen
			switch (binaryOperation.operation) {
			case '*':
				multiply(binaryOperation.num1, binaryOperation.num2);
				break;
			case '+':
				add(binaryOperation.num1, binaryOperation.num2);
				break;
			case '-':
				substract(binaryOperation.num1, binaryOperation.num2);
				break;
			case '/':
				divide(binaryOperation.num1, binaryOperation.num2);
				break;
			case '^':
				power(binaryOperation.num1, binaryOperation.num2);
				break;
			case '%':
				mod(binaryOperation.num1, binaryOperation.num2);
				break;
			default:
				invalidOperator();
				break;
			}

			// footer to exit
			if(footer(input)) 
			{
				break;
			}

		}
	}
	
	private static BinaryOperation getAllInputs(Scanner input) 
	{
		double num1 = 0,
			   num2 = 0;
		
		BinaryOperation binaryOperation = new BinaryOperation();

		try {
			
			System.out.print("\n~~~~~~~~~~~ New Operation ~~~~~~~~~~~~~ \n");
			System.out.print("\nEnter Number 1: ");
			num1 = input.nextDouble();
	
			System.out.print("\nEnter Number 2: ");
			num2 = input.nextDouble();
			
			System.out.print("\nChoose an Operation:  +, -, *, /, ^ , or % : ");
			char operator = input.next().charAt(0);

			System.out.print("\nResult: ");
			
			binaryOperation.operation = operator;
			binaryOperation.num1 = num1;
			binaryOperation.num2 = num2;
						
		} catch (InputMismatchException exception) {
			
			System.out.println("Sorry please enter a valid number, try again.");
			
		}
		
		return binaryOperation;
	}
	
	private static void invalidOperator() 
	{
		System.out.println("Invalid Operator!");
	}
	
	// footer
	private static boolean footer(Scanner input) 
	{
		System.out.print("\nWould you like to continue? (Y/N): ");
		char doneKey = input.next().charAt(0);

		if (doneKey == 'N' || doneKey == 'n') 
		{
			System.out.println("  ____________________________________  ");
			System.out.println("*                                      *");
			System.out.println("* Thank you for using Java Calculator! *");
			System.out.println("* ____________________________________ *");

			return true;
		}
		
		return false;
	}
	
	// methods based on operators
	private static void add(double num1, double num2) 
	{
		double result = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + result);
	}
	
	private static void substract(double num1, double num2) 
	{
		double result = num1 - num2;
		System.out.println(num1 + " - " + num2 + " = " + result);
	}

	private static void multiply(double num1, double num2) 
	{
		double result = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + result);
	}
	
	private static void divide(double num1, double num2) 
	{
		double result = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + result);
	}
	
	private static void mod(double num1, double num2) 
	{
		double result = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + result);
	}

	private static void power(double num1, double num2) 
	{
		double result = Math.pow(num1, num2);
		System.out.println(num1 + " ^ " + num2 + " = " + result);
	}

	// intro banner
	private static void printSplashBanner() 
	{
		System.out.println("  ___________________________  ");
		System.out.println("*                             *");
		System.out.println("* Welcome to Java Calculator! *");
		System.out.println("* ___________________________ *");
	}
}

class BinaryOperation {
	char operation;
	double num1;
	double num2;
}
