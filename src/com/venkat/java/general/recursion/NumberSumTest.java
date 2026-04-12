package com.venkat.java.general.recursion;

// Print sum of given first n numbers using parameterized & functional approach
public class NumberSumTest {

	public static void main(String[] args) {
		int num = 5;
		// Pass the first param as the number and second param as default sum
		printSum(num, 0);
		// Pass the given number
		int sum = printSumByFunctional(num);
		System.out.println(sum);
	}

	private static int printSumByFunctional(int num) {
		if (num == 0) {
			return 0;
		}
		return num + printSumByFunctional(num - 1);

	}

	private static void printSum(int num, int sum) {
		// Base condition to break the loop
		if (num < 1) {
			// Print the sum when ever iteration comes to Zero and retun
			System.out.println(sum);
			return;
		}
		// Call the recursion function by decrementing number by 1
		printSum(num - 1, sum + num);

	}
}
