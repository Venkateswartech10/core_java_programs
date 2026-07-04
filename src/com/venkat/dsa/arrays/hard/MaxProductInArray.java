package com.venkat.dsa.arrays.hard;

public class MaxProductInArray {

	public static void main(String[] args) {
		int[] nums = { 2, 3, -2, 4 };
		// Print the result
		// Time Complexity: O(N^2), we check the product of all possible subarrays using two nested loops.
		// Space Complexity: O(1), No extra space is used.
		System.out.println(maxProductBrute(nums));

		// Time Complexity: O(N), every element of array is visited once.
		// Space Complexity: O(1), constant number of variables are used.
		System.out.println(maxProductOptimal(nums));
	}

	private static int maxProductOptimal(int[] nums) {
		// Get the length of the array
		int n = nums.length;

		// Initialize prefix and suffix product
		int pre = 1, suff = 1;

		// Initialize answer with smallest integer
		int ans = Integer.MIN_VALUE;

		// Traverse from both left and right
		for (int i = 0; i < n; i++) {
			// Reset prefix if zero
			if (pre == 0)
				pre = 1;

			// Reset suffix if zero
			if (suff == 0)
				suff = 1;

			// Multiply prefix with current element from front
			pre *= nums[i];

			// Multiply suffix with current element from back
			suff *= nums[n - i - 1];

			// Update maximum value so far
			ans = Math.max(ans, Math.max(pre, suff));
		}

		// Return the final result
		return ans;
	}

	private static int maxProductBrute(int[] nums) {
		// Initialize the answer with the first element
		int maxProd = nums[0];

		// Outer loop picks the starting index
		for (int i = 0; i < nums.length; i++) {
			// Initialize current product to 1
			int prod = 1;

			// Inner loop picks the ending index
			for (int j = i; j < nums.length; j++) {
				// Multiply current number to product
				prod *= nums[j];

				// Update maximum product if needed
				maxProd = Math.max(maxProd, prod);
			}
		}

		// Return the result
		return maxProd;
	}

}
