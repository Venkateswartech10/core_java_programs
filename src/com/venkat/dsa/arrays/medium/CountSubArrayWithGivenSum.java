package com.venkat.dsa.arrays.medium;

import java.util.HashMap;

public class CountSubArrayWithGivenSum {

	public static void main(String[] args) {
		 // Input array
        int[] arr = {3, 1, 2, 4};

        // Target sum
        int k = 6;
        // Call function and store result
        // Time Complexity: O(N3), where N = size of the array.We are using three nested loops here. Though all are not running for exactly N times, the time complexity will be approximately O(N3)
        // Space Complexity: O(1) as we are not using any extra space.
        int result = subArraySumBrute(arr, k);

        // Print the count of subarrays
        System.out.println("The number of subarrays is: " + result);
        
        // Time Complexity: O(n²),We use two nested loops to check all subarrays, where n is the size of the array.
        // Space Complexity: O(1),Only a few extra variables are used, so constant extra space regardless of input size.
        int result1 = subArraySumBetter(arr, k);

        // Print the count of subarrays
        System.out.println("The number of subarrays is: " + result1);
        
        
        // Time Complexity: O(n) We traverse the array once, where n is the size of the array. Each prefix sum operation and hashmap lookup is O(1) on average.
        // Space Complexity: O(n) In the worst case, all prefix sums are distinct and stored in the hashmap, so space grows linearly with input size.
        int result2 = subArraySumOptimal(arr, k);

        // Print the count of subarrays
        System.out.println("The number of subarrays is: " + result1);
	}

	// Function to find count of subarrays with sum equal to k using prefix sums and hashmap
	private static int subArraySumOptimal(int[] arr, int k) {
		// Size of the array
		int n = arr.length;

		// Map to store frequency of prefix sums
		HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
		// Initialize prefix sum and count of subarrays
		int prefixSum = 0;
		int count = 0;

		// Base case: prefix sum 0 has occurred once
		prefixSumCount.put(0, 1);

		// Traverse through the array
		for (int i = 0; i < n; i++) {
			// Add current element to prefix sum
			prefixSum += arr[i];

			// Calculate the prefix sum that needs to be removed
			int remove = prefixSum - k;

			// If this prefix sum has been seen before,
			// add its count to the result
			if (prefixSumCount.containsKey(remove)) {
				count += prefixSumCount.get(remove);
			}

			// Update the frequency of the current prefix sum
			prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
		}
		// Return the total count of subarrays
		return count;
	}

	// Function to find count of subarrays with sum equal to k
	private static int subArraySumBetter(int[] arr, int k) {
		// Size of the array
		int n = arr.length;

		// Initialize count of subarrays
		int count = 0;

		// Traverse all possible start indices
		for (int i = 0; i < n; i++) {
			// Initialize sum for current subarray
			int sum = 0;

			// Traverse all possible end indices from start
			for (int j = i; j < n; j++) {
				// Add current element to sum
				sum += arr[j];

				// If sum equals k, increment count
				if (sum == k) {
					count++;
				}
			}
		}
		// Return total count of subarrays
		return count;
	}

	// Function to find count of subarrays with sum equal to k
	private static int subArraySumBrute(int[] arr, int k) {
		// Size of the array
		int n = arr.length;
		// Initialize count of subarrays
		int count = 0;

		// Traverse all possible start indices
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				// Initialize sum for current subarray
				int sum = 0;
				// Calculate sum of subarray from i to j
				for (int m = i; m <= j; m++) {
					sum += arr[m];
				}

				// If sum equals k, increment count
				if (sum == k) {
					count++;
				}
			}
		}
		// Return total count of subarrays
		return count;

	}

}
