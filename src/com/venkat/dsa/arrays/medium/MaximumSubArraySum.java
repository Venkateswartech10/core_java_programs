package com.venkat.dsa.arrays.medium;

public class MaximumSubArraySum {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		// Time Complexity: O(N^3), where N is the size of the array. This is because we have three nested loops: one for the starting index, one for the ending index, and one for calculating the sum of the subarray
		// Space Complexity: O(1), as we are using a constant amount of space for variables, regardless of the input size.
		// int maxSum = maximumSubArraySumBrute(arr);
		// System.out.println(maxSum);
		
		// Time Complexity: O(N^2), where N is the size of the array. This is because we have two nested loops: one for the starting index and one for the ending index of the subarray.
		// Space Complexity: O(1), as we are using a constant amount of space for variables, regardless of the input size.
		// int maxSum = maximumSubArraySumBetter(arr);
		// System.out.println(maxSum);
		
		// Kadane's Algorithm
		// Time Complexity: O(n), where n is the number of elements in the array. We traverse the array only once.
		// Space Complexity: O(1). We use a constant amount of space for variables.
		// int maxSum = maximumSubArraySumOptimal(arr);
		// System.out.println(maxSum);
		
		// Print max sub array Elements
		printMaxSubArrayElements(arr);
	}

	// Function to find maximum sum of subarrays and print the subarray having
	// maximum sum
	private static void printMaxSubArrayElements(int[] arr) {
		// Maximum sum
		int maxSum = Integer.MIN_VALUE;
		// Current sum of subarray
		int sum = 0;

		// Starting index of current subarray
		int start = 0;

		// Indices of the maximum sum subarray
		int ansStart = -1, ansEnd = -1;

		// Iterate through the array
		for (int i = 0; i < arr.length; i++) {
			// Update starting index if sum is reset
			if (sum == 0) {
				start = i;
			}

			// Add current element to the sum
			sum += arr[i];

			// Update maxi and subarray indices if current sum is greater
			if (sum > maxSum) {
				maxSum = sum;
				ansStart = start;
				ansEnd = i;
			}

			// Reset sum to 0 if it becomes negative
			if (sum < 0) {
				sum = 0;
			}
		}

		// Printing the subarray
		System.out.print("The subarray is: [");
		for (int j = ansStart; j <= ansEnd; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println("]");

	}

	// Function to find maximum sum of subarrays
	private static int maximumSubArraySumOptimal(int[] arr) {
		// Maximum sum
		int maxSum = Integer.MIN_VALUE;
		// Current sum of subarray
		int sum = 0;
		// Iterate through the array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to the sum
			sum = sum + arr[i];
			// Update maxi if current sum is greater
			if (sum > maxSum) {	
				maxSum = sum;
			}
			// Reset sum to 0 if it becomes negative
			if (sum < 0) {
				sum = 0;
			}
		}
		// Return the maximum subarray sum found
		return maxSum;
	}

	// Function to find maximum sum of subarrays
	private static int maximumSubArraySumBetter(int[] arr) {
		 /* Initialize maximum sum with
        the smallest possible integer */
		int maxSum = Integer.MIN_VALUE;
		// Iterate over each starting index of subarrays
		for (int i = 0; i < arr.length; i++) {
			/* Variable to store the sum
            of the current subarray */
			int sum = 0;
			/* Iterate over each ending index
            of subarrays starting from i */
			for (int j = i; j < arr.length; j++) {
				/* Add the current element nums[j] to
                the sum i.e. sum of nums[i...j-1] */
				sum = sum + arr[j];
				/* Update max sum with the maximum of its current
                value and the sum of the current subarray */
				maxSum = Math.max(maxSum, j);
			}
		}
		// Return the maximum subarray sum found
		return maxSum;
	}

	// Function to find maximum sum of subarrays
	private static int maximumSubArraySumBrute(int[] arr) {
		// Initialize maximum sum with the smallest possible integer
		int maxSum = Integer.MIN_VALUE;
		// Iterate over each starting index of subarrays
		for (int i = 0; i < arr.length; i++) {
			/*
			 * Iterate over each ending index of subarrays starting from i
			 */
			for (int j = i; j < arr.length; j++) {
				/*
				 * Variable to store the sum of the current subarray
				 */
				int sum = 0;
				// Calculate the sum of subarray nums[i...j]
				for (int k = i; k <= j; k++) {
					sum = sum + arr[k];
					/* Update max sum with the maximum of its current value and the sum of the
					current subarray */
					maxSum = Math.max(maxSum, sum);
				}

			}
		}
		// Return the maximum subarray sum found
		return maxSum;
	}

}
