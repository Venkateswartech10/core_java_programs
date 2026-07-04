package com.venkat.dsa.arrays.hard;

public class FindMissingAndRepeatingNumber {

	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 5, 4, 6, 7, 5 };

		// Time Complexity: O(N2), where N is the size of the array. This is because we are iterating through the array for each integer from 1 to N, leading to a nested loop.
		// Space Complexity: O(1), as we are using a constant amount of space for the variables `repeating` and `missing`, regardless of the input size.
		int[] result = findMissingRepeatingNumbersBrute(nums);

		// Print the repeating and missing numbers found
		System.out.println("The repeating and missing numbers are: {" + result[0] + ", " + result[1] + "}");
		
		// Time Complexity: O(2*N), where N is the size of the array. This is because we are iterating through the array once to build the hash array and then iterating through the hash array to find the repeating and missing numbers.
		// Space Complexity: O(N), as we are using an additional hash array of size N+1 to store the frequency of each element.
		int[] result1 = findMissingRepeatingNumbersBetter(nums);

		// Print the repeating and missing numbers found
		System.out.println("The repeating and missing numbers are: {" + result1[0] + ", " + result1[1] + "}");
		
		// Time Complexity: O(N), where N is the size of the array. This is because we are iterating through the array to calculate the sums and sums of squares.
		// Space Complexity: O(1), as we are using a constant amount of space for variables, regardless of the input size.
		int[] result2 = findMissingRepeatingNumbersOptimal(nums);

		// Print the repeating and missing numbers found
		System.out.println("The repeating and missing numbers are: {" + result2[0] + ", " + result2[1] + "}");
	}

	private static int[] findMissingRepeatingNumbersOptimal(int[] nums) {
		// Size of the array
		long n = nums.length;

		// Sum of first n natural numbers
		long SN = (n * (n + 1)) / 2;

		// Sum of squares of first n natural numbers
		long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

		// Calculate actual sum (S) and sum of squares (S2) of array elements
		long S = 0, S2 = 0;
		for (int i = 0; i < n; i++) {
			S += nums[i];
			S2 += (long) nums[i] * (long) nums[i];
		}
		// Compute the difference values
		long val1 = S - SN; // X - Y

		// S2 - S2n = X^2 - Y^2
		long val2 = S2 - S2N;

		// Calculate X + Y
		val2 = val2 / val1;

		// Calculate X and Y
		long x = (val1 + val2) / 2; // repeating
		long y = x - val1; // missing
		return new int[] { (int) x, (int) y };
	}

	private static int[] findMissingRepeatingNumbersBetter(int[] nums) {
		// Size of the array
		int n = nums.length;

		// Hash array to count occurrences
		int[] hash = new int[n + 1];

		// Update the hash array:
		for (int i = 0; i < n; i++) {
			hash[nums[i]]++;
		}

		int repeating = -1, missing = -1;
		// Find the repeating and missing number:
		for (int i = 1; i <= n; i++) {
			if (hash[i] == 2) {
				repeating = i;
			} else if (hash[i] == 0) {
				missing = i;
			}

			// Stop early if both found
			if (repeating != -1 && missing != -1) {
				break;
			}
		}

		// Return [repeating, missing]
		return new int[] { repeating, missing };
	}

	private static int[] findMissingRepeatingNumbersBrute(int[] nums) {
		int n = nums.length; // Size of the array
		int repeating = -1, missing = -1;
		// Find the repeating and missing number:
		for (int i = 1; i <= n; i++) {
			// Count the occurrences:
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (nums[j] == i)
					cnt++;
			}

			// Check if i is repeating or missing
			if (cnt == 2)
				repeating = i;
			else if (cnt == 0)
				missing = i;

			// Stop early if both found
			if (repeating != -1 && missing != -1)
				break;
		}

		// Return {repeating, missing}
		return new int[] { repeating, missing };
	}

}
