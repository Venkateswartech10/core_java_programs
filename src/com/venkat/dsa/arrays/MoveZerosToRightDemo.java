package com.venkat.dsa.arrays;

import java.util.Arrays;

import com.venkat.dsa.sorting.SwapNumbersUtil;

public class MoveZerosToRightDemo {

	public static void main(String[] args) {
		int[] nums = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
		// int[] movedArray = moveZerosRightBruteForce(nums);
		// System.out.println(Arrays.toString(movedArray)); // [1, 2, 3, 2, 4, 5, 1, 0,
		// 0, 0]

		int[] movedArray = moveZerosRightOptimal(nums);
		System.out.println(Arrays.toString(movedArray)); // [1, 2, 3, 2, 4, 5, 1, 0, 0, 0]
	}

	private static int[] moveZerosRightOptimal(int[] nums) {
		// 2 - Pointer Approach
		// First identify zero element position
		int j = -1;
		// Loop is to find first zero element position
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				j = i;
				break;
			}
		}
		// Next loop to start from jth element till last
		for (int i = j + 1; i < nums.length; i++) {
			// Check if the ith position element is non zero the swap and increment j by 1
			if (nums[i] != 0) {
				SwapNumbersUtil.swap(nums, i, j);
				j++;
			}
		}
		return nums;
	}

	private static int[] moveZerosRightBruteForce(int[] nums) {
		// Create temp list to store the elements
		int[] temp = new int[nums.length];
		// Loop all the elements and put non zero elements into temp
		int tempIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				temp[tempIndex] = nums[i];
				tempIndex++;
			}
		}
		System.out.println(Arrays.toString(temp)); // [1, 2, 3, 2, 4, 5, 1, 0, 0, 0]

		// copy back temp array to actual array
		for (int i = 0; i < nums.length; i++) {
			nums[i] = temp[i];
		}

		return nums;
	}

}
