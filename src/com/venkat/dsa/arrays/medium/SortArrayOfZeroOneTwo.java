package com.venkat.dsa.arrays.medium;

import java.util.Arrays;

import com.venkat.dsa.sorting.SwapNumbersUtil;

public class SortArrayOfZeroOneTwo {

	public static void main(String[] args) {
		int[] nums = {1, 0, 2, 1, 0};
		// TC -> O(N log N)
		// sortAnArrayBrute(nums);
		
		// Time Complexity: O(n) + O(n)
		// Space Complexity:O(1)
		// sortAnArrayBetter(nums);
		
		// Time Complexity: O(n) The array is traversed only once using the `mid` pointer. Each element is checked at most once, and swaps are done in constant time.
		// Space Complexity: O(1) Only a few integer pointers (`low`, `mid`, `high`) are used. Sorting is done in-place, requiring no additional space.
		// Dutch National Flag algorithm
		sortAnArrayOptimal(nums);
	}

	// Function to sort array containing 0s, 1s, and 2s using Dutch National Flag Algorithm
	private static void sortAnArrayOptimal(int[] nums) {
		// Initialize three pointers: low and mid at 0, high at the end
		int low = 0, mid = 0, high = nums.length - 1;
		// Continue processing until mid crosses high
		while (mid <= high) {
			// If current element is 0, swap with low and move both low and mid forward
			if (nums[mid] == 0) {
				SwapNumbersUtil.swap(nums, mid, low);
				mid++;
				low++;
			}
			// If current element is 1, just move mid forward
			else if (nums[mid] == 1) {
				mid++;
			}
			// If current element is 2, swap with high and move only high backward
			else {
				SwapNumbersUtil.swap(nums, mid, high);
				high--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	// Function to sort an array containing only 0s, 1s, and 2s
	private static void sortAnArrayBetter(int[] nums) {
		// Count of 0s, 1s, and 2s
		int cnt0 = 0, cnt1 = 0, cnt2 = 0;
		// First pass: Count the number of 0s, 1s, and 2s
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				cnt0++;
			else if (nums[i] == 1)
				cnt1++;
			else
				cnt2++;
		}
		// Second pass: Fill the array with 0s, then 1s, then 2s
		
		// Fill the first 'cnt0' elements with 0
		for (int i = 0; i < cnt0; i++) {
			nums[i] = 0;
		}
		// Fill the next 'cnt1' elements with 1
		for (int i = cnt0; i < cnt0 + cnt1; i++) {
			nums[i] = 1;
		}
		// Fill the remaining elements with 2
		for (int i = cnt0+cnt1; i < cnt0 + cnt1 + cnt2; i++) {
			nums[i] = 2;
		}

		System.out.println(Arrays.toString(nums));
	}

	private static void sortAnArrayBrute(int[] nums) {
		Arrays.sort(nums);
		// Use any Sorting algorithm to sort an Array.
		System.out.println(Arrays.toString(nums));
	}

}
