package com.venkat.dsa.arrays;

import java.util.Arrays;

public class LargestElementTest {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 2 };
		// int largestNumBurute = bruteForceApproach(nums);
		// System.out.println(largestNumBurute);
		int largestNumOptimal = optimalApproach(nums);
		System.out.println(largestNumOptimal);
	}

	private static int optimalApproach(int[] nums) {
		// intialize the first element as largest
		int largest = nums[0];
		// Loop all elements and check if largest element is smaller . If smaller then update largest value
		for (int i = 0; i < nums.length; i++) {  // TC -> O(N)
			if (largest < nums[i]) {
				largest = nums[i];
			}
		}
		// finally return largest value
		return largest;
	}

	private static int bruteForceApproach(int[] nums) {
		// Use any Sorting technique of an array and print last index value
		Arrays.sort(nums); // TC to sort an array is - O(N log N)
		return nums[nums.length - 1];
	}

}
