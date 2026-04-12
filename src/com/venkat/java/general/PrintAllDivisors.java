package com.venkat.java.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintAllDivisors {

	public static void main(String[] args) {
		int num = 17;
		// Bruteforce approach - Time complexity is O(n)
		//printDivisors(num);
		printDivisorsInOptimized(num);
	}

	private static void printDivisorsInOptimized(int num) {
		// Take Arraylist to keep all divisors in list to order them in Ascending
		List list = new ArrayList();
		// Only Loop the sqrt of number so we will get all divisors . Math.sqrt(num) or
		// i*i <= num
		// 6*6 <=36 - true
		// 7*7 <=36 - false . Loop will stop execution
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				// One factor is i if the number is divisible by i & the other factor is num / i
				// System.out.print(i);
				list.add(i);
				// As we already added 1 disisor in list . To avoid duplicate insertion we have if condition
				if (i != num / i) {
					list.add(num / i);
					// System.out.print(num / i);
				}
			}
		}
		// Sort the list & Print
		Collections.sort(list);
		System.out.println(list); // [1, 2, 3, 4, 6, 9, 12, 18, 36]
	}

	private static void printDivisors(int num) {
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.println(i);
			}
		}

	}

}
