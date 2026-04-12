package com.venkat.java.general;

public class GCDTest {
	public static void main(String[] args) {
		int num1 = 9; // divisors of 9 - 1,3,9
		int num2 = 12;// divisors of 12 - 1,2,3,4,6,12
		// Common highest divisor is 3 ( GCD / HCF )
		gcdBruteForce(num1, num2);
		gcdInOptimized(num1, num2);
	}

	private static void gcdInOptimized(int num1, int num2) {
		// Euclidean algorithm - GCD(num1,num2) = gcd(num1%num2,num2)
		// greater%smaller - if one of them is zero then other one is GCD
		while (num1 > 0 && num2 > 0) {
			if (num1 > num2) {
				num1 = num1 % num2;
			} else {
				num2 = num2 % num1;
			}
		}
		if (num1 == 0) {
			System.out.println("GCD is :: " + num2);
		} else {
			System.out.println("GCD is :: " + num1);
		}

	}

	private static void gcdBruteForce(int num1, int num2) {
		int gcd = 1; // initialize gcd with 1 as any number will be divisible by 1
		for (int i = 1; i <= Math.min(num1, num2); i++) {
			// If a number is divisible by both the numbers then that will the gcd.
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		System.out.print("Greatest common factor is :: " + gcd);
	}

}
