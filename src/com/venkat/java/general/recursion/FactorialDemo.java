package com.venkat.java.general.recursion;

public class FactorialDemo {

	public static void main(String[] args) {
		int num = 5;
		// Pass the first param as the number and second param as default sum
		int factorial = factorialByFunctional(num);
		System.out.print(factorial);
	}

	private static int factorialByFunctional(int num) {
		if (num == 0) {
			return 1;
		}
		return num * factorialByFunctional(num - 1);

	}

}
