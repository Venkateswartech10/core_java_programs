package com.venkat.dsa.arrays.easy;

public class FindMissingNumberDemo {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 5 }; // Output = 3
		// TC - O (n*n)
		// SC - O(1)
		// int missingNumber = findMissingNumberBruteForce(nums);
		// System.out.println(missingNumber);

		// TC - O(2N)
		// SC - O(N)
		// int missingNumber = findMissingNumberBetter(nums);
		// System.out.println(missingNumber);

		// we have 2 Optimal Approaches
		// TC - O(N)
		// SC - O(1)
		// int missingNumber = findMissingNumberOptimal1(nums);
		// System.out.println(missingNumber);

		int missingNumber1 = findMissingNumberOptimal2(nums);
		System.out.println(missingNumber1);

	}

	private static int findMissingNumberOptimal2(int[] nums) {
		// Using XOR - a ^ a = 0
		int xor1 = 0;
		int xor2 = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			xor2 = xor2 ^ nums[i];
			xor1 = xor1 ^ (i + 1);
		}

		xor1 = xor1 ^ nums.length;
		return xor1 ^ xor2;
	}

	private static int findMissingNumberOptimal1(int[] nums) {
		// Sum Approach
		int n = nums.length + 1;
		int sum = n * (n + 1) / 2;
		int sumOfGivenArray = 0;
		for (int i = 0; i < nums.length; i++) {
			sumOfGivenArray = sumOfGivenArray + nums[i];
		}
		return sum - sumOfGivenArray;
	}

	private static int findMissingNumberBetter(int[] nums) {
		// Use hashing - Create hash array with the same size of actual array + 1
		int[] hash = new int[nums.length + 1];
		// Loop from 0 to n-1 to mark hash array . If element found mark as 1
		for (int i = 0; i < nums.length - 1; i++) {
			hash[nums[i]] = 1;
		}

		// Loop hash array from 1 to n and check which is not marked as 1 & return that
		// element as missing number
		for (int i = 1; i < nums.length; i++) {
			if (hash[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	private static int findMissingNumberBruteForce(int[] nums) {
		// Take first n natural numbers . Loop all the numbers and check the array
		// element exists or not
		for (int i = 1; i <= nums.length; i++) {
			int flag = 0;
			// if exist set the flag as 1
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == i) {
					flag = 1;
					break;
				}
			}
			// After the loop if flag is zero return that number
			if (flag == 0) {
				return i;
			}
		}
		return -1;
	}

}
