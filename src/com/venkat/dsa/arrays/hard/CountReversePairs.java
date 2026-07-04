package com.venkat.dsa.arrays.hard;

import java.util.ArrayList;

public class CountReversePairs {

	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 3, 1 };
		// Time Complexity: O(N2), We are using nested loops here and those two loops roughly run for N times.
		// Space Complexity: O(1), as we are not using any extra space to solve this problem.
		int cnt = countReversePairsBrute(arr);
		System.out.println("The number of reverse pair is: " + cnt);
		// Time Complexity: O(2N*logN), Inside the mergeSort() we call merge() and countPairs() except mergeSort() itself. Now, inside the function countPairs(), though we are running a nested loop, we are actually iterating the left half once and the right half once in total. That is why, the time complexity is O(N). And the merge() function also takes O(N). The mergeSort() takes O(logN) time complexity. Therefore, the overall time complexity will be O(logN * (N+N)) = O(2N*logN).
		// Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in sorted order.
		int count = countReversePairsOptimal(arr);
		System.out.println("The number of reverse pair is: " + count);
	}

	private static int countReversePairsOptimal(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static int mergeSort(int[] arr, int low, int high) {
		int cnt = 0;
		if (low >= high)
			return cnt;
		int mid = (low + high) / 2;
		cnt += mergeSort(arr, low, mid); // left half
		cnt += mergeSort(arr, mid + 1, high); // right half
		cnt += countPairs(arr, low, mid, high); // Modification
		merge(arr, low, mid, high); // merging sorted halves
		return cnt;
	}

	public static int countPairs(int[] arr, int low, int mid, int high) {
		int right = mid + 1;
		int cnt = 0;
		for (int i = low; i <= mid; i++) {
			while (right <= high && arr[i] > 2 * arr[right])
				right++;
			cnt += (right - (mid + 1));
		}
		return cnt;
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		ArrayList<Integer> temp = new ArrayList<>(); // temporary array
		int left = low; // starting index of left half of arr
		int right = mid + 1; // starting index of right half of arr

		// storing elements in the temporary array in a sorted manner//

		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}

		// if elements on the left half are still left //

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		// if elements on the right half are still left //
		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		// transfering all elements from temporary to arr //
		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}
	}

	private static int countReversePairsBrute(int[] arr) {
		// Count the number of pairs:
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > 2 * arr[j])
					cnt++;
			}
		}
		return cnt;
	}

}
