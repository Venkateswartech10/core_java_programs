package com.venkat.dsa.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {

	public static void main(String[] args) {
		int[] arr = { 2, 6, 5, 8, 11 };
		int target = 14;
		// Bruteforce Approach
		// Time Complexity: O(N²) because we use two nested loops to check every possible pair of elements in the array, where N is the size of the array.
		// Space Complexity: O(1) as we use a constant amount of extra space regardless
		// of input size.
		// Variant 1
		// System.out.println(twoSumExistsBrute(arr, target));
		// Variant 2
		// int[] res = twoSumIndicesBrute(arr, target);
		// System.out.println("[" + res[0] + ", " + res[1] + "]");

		// Better Approach
		// Time Complexity: O(N) because we traverse the array only once, and each lookup or insertion in the hash map takes O(1) on average, where N is the size of the array.
		// Space Complexity: O(N) since in the worst case we may store all elements of the array in the hash map.
		// Variant 1
		//System.out.println(twoSumExistsBetter(arr, target));
		// Variant 2
		// int[] res = twoSumIndicesBetter(arr, target);
		// System.out.println("[" + res[0] + ", " + res[1] + "]");
		
		// Optimal Approach
		// Time Complexity: O(N log N) due to sorting the array initially, where N is the number of elements. The two-pointer traversal runs in O(N).
		// Space Complexity: O(N) because we store the array elements along with their original indices in a separate list or vector for sorting, maintaining original positions.
		// Variant 1	
		System.out.println(twoSumExistsOptimal(arr, target));
		// Variant 2
		int[] res = twoSumIndicesOptimal(arr, target);
		System.out.println("[" + res[0] + ", " + res[1] + "]");

	}

	// Variant 2: Return indices of two numbers that sum to target
	private static int[] twoSumIndicesOptimal(int[] arr, int target) {
		int[][] numsWithIndex = new int[arr.length][2];
		// Store element with original index
		for (int i = 0; i < arr.length; i++) {
			numsWithIndex[i][0] = arr[i];
			numsWithIndex[i][1] = i;
		}
		// Sort by the value to apply two-pointer
		Arrays.sort(numsWithIndex,(a, b) -> Integer.compare(a[0], b[0]));
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
			if (sum == target) {
				// Return original indices of the two numbers found
				return new int[] { numsWithIndex[left][1], numsWithIndex[right][1] };
			} else if (sum < target) {
				// Increase sum by moving left pointer forward
				left++;
			} else {
				// Decrease sum by moving right pointer backward
				right--;
			}
		}

		// No pair found
		return new int[] { -1, -1 };
	}
	
	// Variant 1: Check if two numbers sum to target using two-pointer approach
	private static String twoSumExistsOptimal(int[] arr, int target) {
		// Sort an array by using any of the sorting algorithms
		Arrays.sort(arr);
		// Initialize two pointers: one at start, one at end
		int left = 0, right = arr.length - 1;
		// Run loop until pointers cross
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == target) {
				// Found the pair, return "YES"
				return "Yes";
			} else if (sum < target) {
				// Sum is less than target, so move left pointer right to increase sum
				left++;
			} else {
				// Sum is greater than target, so move right pointer left to decrease sum
				right--;
			}
		}
		// If loop ends without returning, no pair found
		return "No";
	}
	// Variant 2: Return indices of two numbers that sum to target using hashing
	private static int[] twoSumIndicesBetter(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			// If complement found, return indices
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			// Store current element and index
			map.put(arr[i], i);
		}
		// No pair found
		return new int[] { -1, -1 };
	}

	// Variant 1: Check if two numbers sum to target using hashing
	private static String twoSumExistsBetter(int[] arr, int target) {
		// Create hashmap to put element and its index
		HashMap<Integer, Integer> map = new HashMap<>();
		// Iterate over all elements
		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			// Check if complement exists in map
			if(map.containsKey(complement)) {
				return "Yes"; // Pair found
			}
			// Store current element and its index
			map.put(arr[i], i);
		}
		// No pair found
		return "No";
	}

	// Function to return indices of two numbers that sum to target (variant 2)
	private static int[] twoSumIndicesBrute(int[] arr, int target) {
		// Outer loop picks one element at a time
		for (int i = 0; i < arr.length; i++) {
			// Inner loop searches for another element that complements arr[i]
			for (int j = i + 1; j < arr.length; j++) {
				// If sum equals target, return the pair of indices
				if (arr[i] + arr[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		// No such pair found
		return new int[] { -1, -1 };
	}

	// Function to check if any two numbers sum up to target (variant 1)
	private static String twoSumExistsBrute(int[] arr, int target) {
		// Outer loop picks one element at a time
		for (int i = 0; i < arr.length; i++) {
			// Inner loop searches for another element that complements arr[i]
			for (int j = i + 1; j < arr.length; j++) {
				// If sum equals target, return "YES"
				if (arr[i] + arr[j] == target) {
					return "Yes";
				}
			}
		}
		// No pair found that sums to target
		return "No";
	}

}
