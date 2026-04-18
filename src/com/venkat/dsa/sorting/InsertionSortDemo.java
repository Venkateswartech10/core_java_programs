package com.venkat.dsa.sorting;

import java.util.Arrays;

// Takes an element and place it in correct position - Algorithm
public class InsertionSortDemo {

	public static void main(String[] args) {
		int[] nums = { 13, 46, 24, 52, 20, 9 };
		insertionSort(nums);
	}

	private static void insertionSort(int[] nums) {
		// Start the loop from first element and go till last element
		for (int i = 0; i < nums.length; i++) {
			int j = i; // Keep i value in j
			// Continue to check previous element to move until first element
			// We are comparing with previous element so we have to check the condition j > 0 to prevent Index out bounds exception
			while (j > 0 && nums[j - 1] > nums[j]) {
				// Swap the elements
				SwapNumbersUtil.swap(nums, j - 1, j);
				// Decrement the counter to go the loop upto first element
				j--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

}
