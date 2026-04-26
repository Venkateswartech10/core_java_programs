package com.venkat.dsa.arrays;

import java.util.Arrays;

public class LeftRotateArrayOneElementDemo {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] rotatedArray = leftRotateOnePlace(nums);
		System.out.println(Arrays.toString(rotatedArray)); // [2, 3, 4, 5, 1]
	}

	private static int[] leftRotateOnePlace(int[] nums) {
		// Store first element in temp variable
		int temp = nums[0];
		// Start for loop from 1st index onwards till the array size
		for (int i = 1; i < nums.length; i++) {
			// move first index element to previous index & final element will be empty
			nums[i - 1] = nums[i];
		}
		// Put back first element in array at the end position after all elements filled
		nums[nums.length - 1] = temp;
		return nums;
	}

}
