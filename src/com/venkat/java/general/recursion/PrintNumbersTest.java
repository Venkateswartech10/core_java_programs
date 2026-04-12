package com.venkat.java.general.recursion;

//Print linearly 1 to n
public class PrintNumbersTest {

	public static void main(String[] args) {
		int num = 5;
		// pass initial value & number of times function should execute
		printNumber(1, num); // Time complexity - O(n) . Space complexity is also - O(n)
	}

	private static void printNumber(int i, int num) {
		// Base condition where loop should terminate and return back
		if (i > num) {
			return;
		}
		// Print the i value
		System.out.println(i);
		// Call the recursive function by increasing initial value
		printNumber(i + 1, num);
	}
}
