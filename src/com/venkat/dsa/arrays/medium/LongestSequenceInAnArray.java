package com.venkat.dsa.arrays.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSequenceInAnArray {

	public static void main(String[] args) {
		int[] arr = { 100, 4, 200, 1, 3, 2 };

		// Time Complexity: O(n2), where n is the number of elements in the array. This is because for each element, we may need to perform a linear search through the entire array to find consecutive numbers.
		// Space Complexity: O(1), as we are using a constant amount of extra space for variables.
		// int longestConsecutiveCount = longestConsecutiveBrute(arr);
		// System.out.println(longestConsecutiveCount);

		// Time Complexity: O(n log n), where n is the number of elements in the array.This is due to the sorting step, which is the most time-consuming operation in this approach.
		// Space Complexity: O(1), as we are using only a constant amount of extra space.
		// int longestConsecutiveCount = longestConsecutiveBetter(arr);
		// System.out.println(longestConsecutiveCount);

		// Time Complexity: O(n), where n is the number of elements in the array. This is because we traverse each element once to build the set and then again to find the longest consecutive sequence.
		// Space Complexity: O(n), as we use a set to store the unique elements of the array, which in the worst case can be equal to the size of the input array.
		int longestConsecutiveCount = longestConsecutiveOptimal(arr);
		System.out.println(longestConsecutiveCount);

	}

	private static int longestConsecutiveOptimal(int[] arr) {
		// If the array is empty, no sequence exists
		if (arr.length == 0) {
			return 0;
		}
		// Variable to store the longest sequence length found
		int longest = 1;
		// HashSet to store unique elements for O(1) lookup
		Set<Integer> set = new HashSet<>();
		// Add all elements to the set to remove duplicates
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		/*
		 * Loop through each element in the set to find the starting point of
		 * consecutive sequences
		 */
		for (int element : set) {
			// If there is no number before 'it', it’s the start of a sequence
			if (!set.contains(element - 1)) {
				// Start the count for this sequence
				int count = 1;
				// Store the current number
				int x = element;
				// Keep checking for the next consecutive number
				while (set.contains(x + 1)) {
					// Move to the next number in sequence
					x = x + 1;
					// Increment the length of current sequence
					count = count + 1;

				}
				// Update the longest sequence length if needed
				longest = Math.max(longest, count);

			}
		}
		// Return the length of the longest sequence
		return longest;
	}

	private static int longestConsecutiveBetter(int[] arr) {
		// Return 0 if array is empty
		if (arr.length == 0) {
			return 0;
		}
		// Sort the array to bring consecutive numbers together
		Arrays.sort(arr);
		// Variable to track the last smaller element in sequence
		int lastSmaller = Integer.MIN_VALUE;
		// Variable to store the current sequence length
		int count = 0;
		// Variable to store the longest sequence length found
		int longest = 1;
		// Iterate through the sorted array
		for (int i = 0; i < arr.length; i++) {
			// Case 1: Current element is exactly one greater than lastSmaller → part of sequence
			if (arr[i] - 1 == lastSmaller) {
				// Increment the sequence length
				count++;
				// Update the last smaller element
				lastSmaller = arr[i];
			}
			// Case 2: Current element is not consecutive and not a duplicate
			else if (arr[i] != lastSmaller) {
				// Reset the sequence length count to 1
				count = 1;
				// Update the last smaller element
				lastSmaller = arr[i];
			}
			// Update the longest sequence length if the current sequence is longer
			longest = Math.max(longest, count);
		}
		// Return the length of the longest consecutive sequence
		return longest;
	}

	// Function to find the length of the longest consecutive sequence
	private static int longestConsecutiveBrute(int[] arr) {
		// If the array is empty, no sequence exists
		if (arr.length == 0) {
			return 0;
		}
		// Initialize the longest sequence length to 1 (minimum possible)
		int longest = 1;
		// Iterate over each element of the array
		for (int i = 0; i < arr.length; i++) {
			// Store the current number
			int element = arr[i];
			// Start sequence length count from 1
			int count = 1;
			// Search for consecutive numbers starting from x + 1
			while (linearSearch(arr, element + 1) == true) {
				// Move to the next consecutive number
				element++;
				// Increase the count of the current sequence
				count++;
			}
			// Update the longest sequence length if the current is longer
			longest = Math.max(longest, count);
		}
		// Return the longest consecutive sequence length found
		return longest;

	}

	// Function to search for a given number in the array
	private static boolean linearSearch(int[] arr, int element) {
		// Traverse through the array to check if the number exists
		for (int i = 0; i < arr.length; i++) {
			// If element matches the number, return true
			if (arr[i] == element) {
				return true;
			}
		}
		// Number not found
		return false;
	}

}
