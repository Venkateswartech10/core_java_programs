package com.venkat.dsa.arrays;

import java.util.Arrays;

public class LeftRotateArrayByDPlacesDemo {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 4, 5, 6, 7 }; // d = 3
		int d = 3;
		// int[] rotatedArray = leftRotateArrayDPlacesBruteForce(nums, d);
		// System.out.println(Arrays.toString(rotatedArray)); // [4, 5, 6, 7, 1, 2, 3]

		int[] rotatedArray = leftRotateArrayDPlacesOptimal(nums, d);
		System.out.println(Arrays.toString(rotatedArray)); // [4, 5, 6, 7, 1, 2, 3]
	}

	private static int[] leftRotateArrayDPlacesOptimal(int[] nums, int d) {
		// Find d places if d is greater than size of the array
		// if d given as 9 then d = 9 % 7 = 2 places
		d = d % nums.length;
		// reverse first d elements
		reverse(nums, 0, d - 1);
		System.out.println(Arrays.toString(nums));
		// reverse from d to last element
		reverse(nums, d, nums.length - 1);
		System.out.println(Arrays.toString(nums));
		// reverse the total array
		reverse(nums, 0, nums.length - 1);
		return nums;
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	private static int[] leftRotateArrayDPlacesBruteForce(int[] nums, int d) {
		// Find d places if d is greater than size of the array
		// if d given as 9 then d = 9 % 7 = 2 places
		d = d % nums.length;
		// Create temp array & keep the first left rotated elements into sub array
		int[] temp = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = nums[i];
		}
		System.out.println(Arrays.toString(temp)); // [1, 2, 3]
		// Move from d+1 elements to starting index
		for (int i = d; i < nums.length; i++) {
			nums[i - d] = nums[i];
		}
		System.out.println(Arrays.toString(nums));
		// Put back temp array at the last places
		// int j = 0;
		for (int i = nums.length - d; i < nums.length; i++) {
			nums[i] = temp[i - (nums.length - d)];
			// j++;
		}
		return nums;
	}

}
