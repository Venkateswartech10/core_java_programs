package com.venkat.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Divide & merge - Algorithm
public class MergeSortDemo {

	public static void main(String[] args) {
		int[] nums = { 13, 46, 24, 52, 20, 9 };
		// Pass given array , initial value & last element size to call the method recursively
		mergeSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private static void mergeSort(int[] nums, int lowIndex, int highIndex) {
		// Base condition where loop breaks
		if (lowIndex >= highIndex) {
			return;
		}
		// find mid index to divide the array into equal sub arrays
		int midIndex = (lowIndex + highIndex) / 2;
		// Recursive call from low to mid of first sub array
		mergeSort(nums, lowIndex, midIndex);
		// Recursive call from mid+1 to last index of second sub array
		mergeSort(nums, midIndex + 1, highIndex);
		// merge both sub arrays
		merge(nums, lowIndex, midIndex, highIndex);
	}

	private static void merge(int[] nums, int lowIndex, int midIndex, int highIndex) {
		// Create temp list to keep the values
		List<Integer> temp = new ArrayList();
		// create left and right variables with starting points of 2 sub arrays
		int left = lowIndex;
		int right = midIndex + 1;
		// Loop until the any one sub array completes
		while (left <= midIndex && right <= highIndex) {
			// Compare left sub array value with right sub array value & add into the temp array / List
			if (nums[left] <= nums[right]) {
				temp.add(nums[left]);
				// Move left pointer towards right
				left++;
			} else {
				temp.add(nums[right]);
				// Move right pointer towards right
				right++;
			}
		}

		// check if we met left pointer till midIndex / last element of first sub array
		// . If not add them
		while (left <= midIndex) {
			temp.add(nums[left]);
			left++;
		}
		// check if we met right pointer till highIndex / last element of second sub array . If not add them
		while (right <= highIndex) {
			temp.add(nums[right]);
			right++;
		}

		// Loop & add temp values to original Array.
		for (int i = lowIndex; i <= highIndex; i++) {
			// To get first element of temp we use i- lowIndex
			nums[i] = temp.get(i - lowIndex);
		}
	}

}
