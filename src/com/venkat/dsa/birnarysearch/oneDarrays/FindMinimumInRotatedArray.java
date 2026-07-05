package com.venkat.dsa.birnarysearch.oneDarrays;

public class FindMinimumInRotatedArray {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		// Time Complexity: O(N), we check every element once.
		// Space Complexity: O(1), constant additional space is used.
		int result = findMinBrute(nums);
		System.out.println("Minimum element is " + result);

		// Time Complexity: O(logN), at every step the search space is reduced to half using binary search.
		// Space Complexity: O(1), constant additional space is used.
		int result1 = findMinOptimal(nums);
		System.out.println("Minimum element is " + result1);
	}

	private static int findMinOptimal(int[] nums) {
		// Initialize low and high pointers
		int low = 0, high = nums.length - 1;

		// Binary search loop
		while (low < high) {
			// Calculate mid index
			int mid = low + (high - low) / 2;
			// Check which half to discard
			if (nums[mid] > nums[high]) {
				// Minimum lies in right half
				low = mid + 1;

			} else {
				// Minimum lies in left half (including mid)
				high = mid;
			}
		}

		// Return the minimum element
		return nums[low];
	}

	private static int findMinBrute(int[] nums) {
		// Initialize answer with a large number
		int minVal = Integer.MAX_VALUE;
		// Traverse each element
		for (int i = 0; i < nums.length; i++) {
			// Update minimum value
			minVal = Math.min(minVal, nums[i]);
		}
		// Return the result
		return minVal;
	}

}
