package com.venkat.java.general.recursion;

// Find nth fibonacci number by using mutiple recursion calls
public class FibnocciTest {

	public static void main(String[] args) {
		int num = 4; // 0 1 1 2 3 - 0th fibonacci - 0 ,firstFibonacci - 1 , etc.
		// Call recursive method by passing num
		System.out.print(getFibonacciNumber(num));
	}

	private static int getFibonacciNumber(int num) {
		// Base condition to break the loop .
		if (num <= 1) {
			return num;
		}
		// Find previous fibonacci number by recursive call
		int last = getFibonacciNumber(num - 1);
		// Find previous fibonacci number by recursive call
		int secondLast = getFibonacciNumber(num - 2);
		// Add last and secondLast to get the nth fibonacci number
		return last + secondLast;
	}

}
