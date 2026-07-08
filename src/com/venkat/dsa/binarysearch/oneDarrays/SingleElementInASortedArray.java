package com.venkat.dsa.binarysearch.oneDarrays;

public class SingleElementInASortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
		// Time Complexity: O(N), N = size of the given array.We are traversing the entire array.
		// Space Complexity: O(1) as we are not using any extra space.
		int ans = singleNonDuplicateBrute1(arr);
		System.out.println("The single element is: " + ans);

		// Time Complexity: O(N), N = size of the given array.We are traversing the entire array.
		// Space Complexity: O(1) as we are not using any extra space.
		int ans1 = singleNonDuplicateBrute2(arr);
		System.out.println("The single element is: " + ans1);

		// Time Complexity: O(logN), N = size of the given array ,as we are basically using the Binary Search algorithm.
		// Space Complexity: O(1) as we are not using any extra space.
		int ans2 = singleNonDuplicateOptimal(arr);
		System.out.println("The single element is: " + ans2);
	}

	private static int singleNonDuplicateOptimal(int[] arr) {
		int n = arr.length;
		// Edge case: only one element in the array
		if (n == 1)
			return arr[0];
		// Edge case: first element is the unique one
		if (arr[0] != arr[1])
			return arr[0];
		// Edge case: last element is the unique one
		if (arr[n - 1] != arr[n - 2])
			return arr[n - 1];
		// Initialize binary search bounds (exclude first and last index)
		int low = 1, high = n - 2;
		// Perform binary search
		while (low <= high) {
			// Calculate middle index
			int mid = (low + high) / 2;
			// Check if middle element is the unique one
			if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
				return arr[mid];
			}
			// If mid is in the left half (pairing is valid)
			if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
				// Move to the right half
				low = mid + 1;
			}
			// If mid is in the right half (pairing broken earlier)
			else {
				// Move to the left half
				high = mid - 1;
			}
		}

		// Dummy return (not reachable if input is valid)
		return -1;
	}

	private static int singleNonDuplicateBrute2(int[] arr) {
		int n = arr.length;
		// Initialize the result variable with 0
		int ans = 0;
		// Traverse the array and XOR all elements
		for (int i = 0; i < n; i++) {
			ans = ans ^ arr[i];
		}
		// Return the unique element found using XOR
		return ans;
	}

	private static int singleNonDuplicateBrute1(int[] arr) {
		int n = arr.length;
		// If array has only one element, return it
		if (n == 1)
			return arr[0];
		// Loop through the array
		for (int i = 0; i < n; i++) {
			// Check if it's the first element and not equal to the next
			if (i == 0) {
				if (arr[i] != arr[i + 1])
					return arr[i];
			}
			// Check if it's the last element and not equal to the previous
			else if (i == n - 1) {
				if (arr[i] != arr[i - 1])
					return arr[i];
			}
			// Check if the current element is not equal to both neighbors
			else {
				if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
					return arr[i];
			}
		}
		// Dummy return if no element found
		return -1;
	}

}
