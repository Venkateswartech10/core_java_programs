package com.venkat.dsa.binarysearch.oneDarrays;

public class FindPeakElementInArray {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 20, 4, 1, 0 };
		// Time Complexity: O(N), we traverse the entire array once to find peak element.
		// Space Complexity: O(1), constant additional space is used.
		int index = findPeakElementBrute(nums);
		System.out.println("Peak at index: " + index + " with value: " + nums[index]);

		// Time Complexity: O(log N), we reduce the search space to half at every step using binary search.
		// Space Complexity: O(1), constant additional space is used.
		int index1 = findPeakElementOptimal(nums);
		System.out.println("Peak at index: " + index1 + " with value: " + nums[index1]);
	}

	private static int findPeakElementOptimal(int[] nums) {
		// Set left and right bounds
		int low = 0, high = nums.length - 1;
		// Binary search loop
		while (low < high) {
			// Find mid point
			int mid = (low + high) / 2;
			// If mid element is greater than next
			if (nums[mid] > nums[mid + 1]) {
				// Move to left half
				high = mid;
			} else {
				// Move to right half
				low = mid + 1;
			}
		}
		// Return peak index
		return low;
	}

	private static int findPeakElementBrute(int[] nums) {
		int n = nums.length;
		// Traverse the array
		for (int i = 0; i < n; i++) {
			// Check left neighbor if exists
			boolean left = (i == 0) || (nums[i] >= nums[i - 1]);
			// Check right neighbor if exists
			boolean right = (i == n - 1) || (nums[i] >= nums[i + 1]);

			// If both conditions are true
			if (left && right)
				return i;
		}

		// In case no peak found
		return -1;
	}

}
