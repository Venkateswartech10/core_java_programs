package com.venkat.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Variety -1 : negatives and positives are equal size
public class ReArrangeElementsBySignElementsAreEqual {

	public static void main(String[] args) {
		//int[] arr = { 3, 1, -2, -5, 2, -4 };
		int[] arr = { 28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31 };
		// Time Complexity: O(N+N/2) { O(N) for traversing the array once for segregating positives and negatives and another O(N/2) for adding those elements alternatively to the array, where N = size of the array A}.
		// Space Complexity: O(N/2 + N/2) = O(N) { N/2 space required for each of the positive and negative element arrays, where N = size of the array A}.
		// reArrangeElementsBrute(arr);
		
		// Time Complexity: O(N) { O(N) for traversing the array once and substituting positives and negatives simultaneously using pointers, where N = size of the array A}.
		// Space Complexity: O(N)
		reArrangeElementsOptimal(arr);
	}

	private static void reArrangeElementsOptimal(int[] arr) {
		// Create an array with same size to store the result
		int[] ans = new int[arr.length];
		// posIndex for even indices (positive), negIndex for odd (negative)
		int postiveIndex = 0, negativeIndex = 1;
		 // Traverse input array
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				// Place positive number at even index
				ans[postiveIndex] = arr[i];
				postiveIndex = postiveIndex + 2;
			} else {
				// Place negative number at odd index
				ans[negativeIndex] = arr[i];
				negativeIndex = negativeIndex + 2;
			}
		}
		System.out.println(Arrays.toString(ans));
	}

	private static void reArrangeElementsBrute(int[] arr) {
		// Create 2 lists to store +ves and -ves
		List<Integer> negativeList = new ArrayList<>();
		List<Integer> postiveList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				negativeList.add(arr[i]);
			} else {
				postiveList.add(arr[i]);
			}
		}

		// Loop only n/2 elements and move indexes based on position

		for (int i = 0; i < arr.length / 2; i++) {
			arr[2 * i] = postiveList.get(i);
			arr[2 * i + 1] = negativeList.get(i);
		}

		System.out.print(Arrays.toString(arr));
	}
}
