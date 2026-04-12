package com.venkat.java.general.recursion;

//Print name 5 times by using recursion
public class PrintNameTest {

	public static void main(String[] args) {
		int num = 5;
		// pass initial value & number of times function should execute
		printName(1, num); // Time complexity - O(n) . Space complexity is also - O(n)
	}

	private static void printName(int i, int num) {
		// Base condition where loop should terminate and return back
		if (i > num) {
			return;
		}
		// Print the name
		System.out.println("Venkat");
		// Call the recursive function by increasing initial value
		printName(i + 1, num);
	}
}
