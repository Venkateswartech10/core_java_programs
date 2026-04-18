package com.venkat.dsa.sorting;

import java.util.Arrays;

// Divide & conquer
// 1. Pick a pivot and place it in it's correct place in the sorted array  - Algorithm
// 2. Smaller on the left and larger on the right  - Algorithm
public class QuickSortDemo {

	public static void main(String[] args) {
		int[] nums = { 13, 46, 24, 52, 20, 9 };
		// Pass Array and initial index & max index to call recursive function
		quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private static void quickSort(int[] nums, int lowIndex, int highIndex) {
		// Base condition to break the loop
		if (lowIndex < highIndex) {
			int pivotIndex = findPivot(nums, lowIndex, highIndex);
			// From pivot index , left side sub array & call recursion for sort
			quickSort(nums, lowIndex, pivotIndex - 1);
			// From Pivot index , right side sub array & call recursion for sort
			quickSort(nums, pivotIndex + 1, highIndex);
		}
	}

	private static int findPivot(int[] nums, int lowIndex, int highIndex) {
		// Assume first element as pivot
		int pivot = nums[lowIndex];
		int i = lowIndex;
		int j = highIndex;
		// Loop until low index reaches highIndex
		while (i < j) {
			// If Pivot is less than left value & low index not reaches end index . Move left pointer towards right
			while (nums[i] <= pivot && i <= highIndex - 1) {
				i++;
			}
			// If Pivot is greater than right value & low index not reaches start index . Move right pointer towards left
			while (nums[j] > pivot && j >= lowIndex + 1) {
				j--;
			}
			// If left pointer is not crossed then swap the left pointer value to right pointer value
			if (i < j)
				SwapNumbersUtil.swap(nums, i, j);
		}
		// Swap first element to correct position at right pointer  & return that pointer.
		SwapNumbersUtil.swap(nums, lowIndex, j);
		return j;
	}

}
