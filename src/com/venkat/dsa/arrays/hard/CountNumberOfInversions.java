package com.venkat.dsa.arrays.hard;

public class CountNumberOfInversions {

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 2, 1 };
		// Time Complexity: O(N2), as every pair is checked.
		// Space Complexity: O(1), since no extra space is used apart from variables.
		int inversions = numberOfInversionsBrute(arr);
		System.out.println("The number of inversions is: " + inversions);

		// Time Complexity: O(N log N), since it is based on merge sort.
		// Space Complexity: O(N), for the temporary array used during merging.
		int inversions1 = numberOfInversionsOptimal(arr);
		System.out.println("The number of inversions is: " + inversions1);
	}

	// Function to get number of inversions
	public static int numberOfInversionsOptimal(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	// Merge sort function
	public static int mergeSort(int[] arr, int low, int high) {
		int cnt = 0;

		if (low >= high)
			return cnt;

		int mid = (low + high) / 2;

		// Count inversions in left half
		cnt += mergeSort(arr, low, mid);
		// Count inversions in right half
		cnt += mergeSort(arr, mid + 1, high);
		// Count inversions during merge
		cnt += merge(arr, low, mid, high);

		return cnt;
	}

	// Function to merge two halves and count inversions
	public static int merge(int[] arr, int low, int mid, int high) {
		// Temporary array
		int[] temp = new int[high - low + 1];

		// Starting indices of left and right halves
		int left = low;
		int right = mid + 1;
		int k = 0;

		// Variable to count inversions
		int cnt = 0;

		// Merge elements in sorted order
		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp[k++] = arr[left++];
			} else {
				temp[k++] = arr[right++];
				cnt += (mid - left + 1); // Count inversions
			}
		}

		// Copy remaining elements of left half
		while (left <= mid) {
			temp[k++] = arr[left++];
		}

		// Copy remaining elements of right half
		while (right <= high) {
			temp[k++] = arr[right++];
		}

		// Copy back to original array
		for (int i = low; i <= high; i++) {
			arr[i] = temp[i - low];
		}

		return cnt;
	}

	private static int numberOfInversionsBrute(int[] arr) {
		int cnt = 0; // Initialize count
		int n = arr.length;
		// Check all pairs
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j])
					cnt++; // Increment if inversion found
			}
		}
		return cnt; // Return total inversions
	}

}
