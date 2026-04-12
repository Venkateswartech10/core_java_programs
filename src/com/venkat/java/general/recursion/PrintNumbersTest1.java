package com.venkat.java.general.recursion;

// Print numbers from n to 1
public class PrintNumbersTest1 {

	public static void main(String[] args) {
		int num = 7;
		// Pass first param as max size & the second param as the number from it has to print
		printNumber(num, num);
	}

	private static void printNumber(int i, int num) {
		// Base condition where it has to break the loop
		if (i < 1) {
			return;
		}
		// Print the number
		System.out.println(i);
		// call the recursive method by decrementing by 1.
		printNumber(i - 1, num);
	}

}