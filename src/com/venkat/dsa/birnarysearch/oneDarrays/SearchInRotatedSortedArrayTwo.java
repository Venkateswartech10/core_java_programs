package com.venkat.dsa.birnarysearch.oneDarrays;

public class SearchInRotatedSortedArrayTwo {

	public static void main(String[] args) {
		// Sample rotated sorted array with duplicates
		int[] arr = { 7, 8, 1, 2, 3, 3, 3, 4, 5, 6 };
		int k = 3; // Target to search

		// Time Complexity: O(N), N = size of the given array.
		// Space Complexity: O(1), no extra space used.
		boolean ans = searchInARotatedSortedArrayBrute(arr, k);
		System.out.println(ans);
		
		// Time Complexity: O(logN) for the best and average case. O(N/2) for the worst case. Here, N = size of the given array
		// Space Complexity: O(1), no extra space used
		boolean ans1 = searchInARotatedSortedArrayOptimal(arr, k);
		System.out.println(ans1);
	}

	private static boolean searchInARotatedSortedArrayOptimal(int[] arr, int k) {
		int low = 0, high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			// If mid element is the target
			if (arr[mid] == k)
				return true;

			// Handle duplicates: cannot determine sorted side
			if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
				low++;
				high--;
				continue;
			}

			// Left half is sorted
			if (arr[low] <= arr[mid]) {
				if (arr[low] <= k && k <= arr[mid]) {
					high = mid - 1; // Search left
				} else {
					low = mid + 1; // Search right
				}
			}
			// Right half is sorted
			else {
				if (arr[mid] <= k && k <= arr[high]) {
					low = mid + 1; // Search right
				} else {
					high = mid - 1; // Search left
				}
			}
		}

		return false; // Not found
	}

	private static boolean searchInARotatedSortedArrayBrute(int[] arr, int k) {
		// Iterate through each element of the array
		for (int num : arr) {
			// If the target is found, return true
			if (num == k)
				return true;
		}
		// If loop completes and target not found, return false
		return false;
	}

}
