package com.venkat.java.general.recursion;

// Print numbers from n to 1 without using i-1 ( Back tracking )
public class PrintNumbersTest4 {

	public static void main(String[] args) {
		int num = 5;
		// Pass first param as initial value & the second param as the number from it has to print
		printNumber(1, num);
	}

	private static void printNumber(int i, int num) {
		// Base condition where it has to break the loop
		if (i > num) {
			return;
		}
		// call the recursive method by incrementing by 1.
		printNumber(i + 1, num);
		// Print the number
		System.out.println(i);
	}

}
