package com.venkat.java.general.recursion;

// Print numbers from 1 to n without using i+1 ( Back tracking )
public class PrintNumbersTest3 {

	public static void main(String[] args) {
		int num = 5;
		// Pass first param as max size & the second param as the number upto it has to print
		printNumber(num, num);
	}

	private static void printNumber(int i, int num) {
		// Base condition where it has to break the loop
		if (i < 1) {
			return;
		}
		// call the recursive method by decrementing by 1.
		printNumber(i - 1, num);
		// Print the number
		System.out.println(i);
	}

}
