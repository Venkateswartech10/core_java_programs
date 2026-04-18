package com.venkat.dsa.sorting;

import java.util.Arrays;

// Select minimums & Swap - Algorithm
public class SelectionSortDemo {

	public static void main(String[] args) {
		int[] nums = { 13, 46, 24, 52, 20, 9 };
		// Outer loop to iterate all the elements . Last index always sorted so we will stop the loop lenght -1
		for (int i = 0; i < nums.length - 1; i++) {
			// Assume minimum index is first index value . So initialize it with i
			int minimumIndex = i;
			// Inner loop to find minimum value index
			for (int j = i; j < nums.length; j++) {
				// Compare first number with all other elements.
				if (nums[minimumIndex] > nums[j]) {
					// If we found minimum update the minimum index with small value
					minimumIndex = j;
				}
				// Swap the minimum value & the starting of the array
				SwapNumbersUtil.swap(nums, minimumIndex, i);
			}
		}
		System.out.println(Arrays.toString(nums));
	}

}
