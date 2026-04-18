package com.venkat.dsa.sorting;

import java.util.Arrays;

//push the maximum to the last by adjacent swaps - Algorithm
public class BubbleSortDemo {

	public static void main(String[] args) {
		int[] nums = { 13, 46, 24, 52, 20, 9 };
		bubbleSort(nums);
	}

	private static void bubbleSort(int[] nums) {
		// Outer Loop starts from last to till second element as first element always sorted
		for (int i = nums.length - 1; i >= 1; i--) {
			// Inner loop starts from 0 & ends maximum lengh - 1 . Bcause last element already sorted
			for (int j = 0; j <= i-1; j++) {
				// Compare adjacent elements and if first element is greater than second element then Swap the elements
				if (nums[j] > nums[j + 1]) {
					SwapNumbersUtil.swap(nums, j, j+1);
				}
			}
		}
		System.out.println(Arrays.toString(nums)); // [9, 13, 20, 24, 46, 52]
	}
}
