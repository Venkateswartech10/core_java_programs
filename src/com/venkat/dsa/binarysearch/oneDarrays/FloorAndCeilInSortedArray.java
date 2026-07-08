package com.venkat.dsa.binarysearch.oneDarrays;

public class FloorAndCeilInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 4, 7, 8, 10 };
		int x = 5;
		// Time Complexity:O(logN), where N = size of the given array. We are using the Binary Search algorithm
		// Space Complexity: O(1). No extra space used
		int[] result = getFloorAndCeil(arr, x);
		System.out.println("The floor and ceil are: " + result[0] + " " + result[1]);
	}

	private static int[] getFloorAndCeil(int[] arr, int x) {
		int f = findFloor(arr, x);
		int c = findCeil(arr, x);
		return new int[] { f, c };
	}

	private static int findCeil(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
		int ans = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] >= x) {
				ans = arr[mid]; // Potential ceil
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static int findFloor(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
		int ans = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] <= x) {
				ans = arr[mid]; // Potential floor
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

}
