package com.venkat.java.general;

public class PrimeNumberTest {
	public static void main(String[] args) {
		int num = 19;
		primeNumberCheck(num);
		primeNumberCheckInOptimized(num);
	}

	private static void primeNumberCheckInOptimized(int num) {
		// initialize counter
		int counter = 0;
		// i*i <= num
		// 6*6 <=36 - true
		// 7*7 <=36 - false . Loop will stop execution
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				// One factor is i if the number is divisible by i & the other factor is num / i
				// If num is divisible by i , increase the counter
				counter++;
				// As we already added 1 disisor in list . To avoid duplicate insertion we have if condition
				if (i != num / i) {
					counter++;
				}
			}
		}
		// At the end of the loop if we have counter 2 then it means exactly we have 2
		// divisors.
		if (counter == 2) {
			System.out.println("Given Number is Prime");
		} else {
			System.out.println("Given number is not a prime number");
		}
	}

	private static void primeNumberCheck(int num) {
		// initialize counter
		int counter = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				// If num is divisible by i , increase the counter
				counter++;
			}
		}
		// At the end of the loop if we have counter 2 then it means exactly we have 2
		// divisors.
		if (counter == 2) {
			System.out.println("Given Number is Prime");
		} else {
			System.out.println("Given number is not a prime number");
		}

	}

}
