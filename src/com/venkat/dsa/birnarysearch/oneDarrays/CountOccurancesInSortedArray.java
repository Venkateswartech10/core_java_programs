package com.venkat.dsa.birnarysearch.oneDarrays;

public class CountOccurancesInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
		int n = 8, target = 8;
		// Time Complexity: O(N), We are traversing the whole array.
		// Space Complexity: O(1), as we are not using any extra space
		int ans = countOccurancesBrute(arr, n, target);
		System.out.println("The number of occurrences is: " + ans);

		// Time Complexity: O(2*logN), We are basically using the binary search algorithm twice.
		// Space Complexity: O(1), as we are using no extra space.
		int ans1 = countLenghtOfOccurancesOptimal(arr, n, target);
		System.out.println("The number of occurrences is: " + ans1);
	}

	private static int countLenghtOfOccurancesOptimal(int arr[], int n, int x) {
		int[] ans = firstAndLastPosition(arr, n, x);
		if (ans[0] == -1)
			return 0;
		return (ans[1] - ans[0] + 1);
	}

	public static int[] firstAndLastPosition(int[] arr, int n, int k) {
		int first = firstOccurrence(arr, n, k);
		if (first == -1)
			return new int[] { -1, -1 };
		int last = lastOccurrence(arr, n, k);
		return new int[] { first, last };
	}

	private static int firstOccurrence(int[] arr, int n, int k) {
		int low = 0, high = n - 1;
		int first = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			// maybe an answer
			if (arr[mid] == k) {
				first = mid;
				// look for smaller index on the left
				high = mid - 1;
			} else if (arr[mid] < k) {
				low = mid + 1; // look on the right
			} else {
				high = mid - 1; // look on the left
			}
		}
		return first;
	}

	private static int lastOccurrence(int[] arr, int n, int target) {
		int low = 0, high = n - 1;
		int last = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			// maybe an answer
			if (arr[mid] == target) {
				last = mid;
				// look for larger index on the right
				low = mid + 1;
			} else if (arr[mid] < target) {
				low = mid + 1; // look on the right
			} else {
				high = mid - 1; // look on the left
			}
		}
		return last;
	}

	private static int countOccurancesBrute(int[] arr, int n, int target) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			// counting the occurrences:
			if (arr[i] == target)
				cnt++;
		}
		return cnt;
	}

}
