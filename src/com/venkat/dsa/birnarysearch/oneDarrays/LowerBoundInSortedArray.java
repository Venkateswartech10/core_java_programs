package com.venkat.dsa.birnarysearch.oneDarrays;

public class LowerBoundInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 3, 5, 8, 15, 19 };
		int x = 9;
		// Time Complexity: O(N), where N = size of the given array.
		// Space Complexity: O(1), no extra space used.
		int index = lowerBoundBrute(arr, x);
		System.out.println(index);

		// Time Complexity: O(logn), used for typical binary search
		// Space Complexity: O(1), no extra space used
		int index1 = lowerBoundOptimal(arr, x);
		System.out.println(index1);

	}

	private static int lowerBoundOptimal(int[] arr, int x) {
		int low = 0; // Start index
		int high = arr.length - 1; // End index
		int ans = arr.length; // Default value if not found

		while (low <= high) {
			int mid = (low + high) / 2; // Find mid index

			if (arr[mid] >= x) {
				ans = mid; // Store possible answer
				high = mid - 1; // Move left
			} else {
				low = mid + 1; // Move right
			}
		}
		return ans; // Return the lower bound index
	}

	private static int lowerBoundBrute(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= x) {
				return i; // First index where element >= x
			}

		}
		return arr.length; // If x is greater than all elements
	}
}
