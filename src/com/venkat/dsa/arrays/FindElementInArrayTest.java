package com.venkat.dsa.arrays;

public class FindElementInArrayTest {

	public static void main(String[] args) {
		int[] nums = { 6, 7, 8, 4, 1 };
		int findIndexOfNum = 4;
		int index = findNumberIndex(nums, findIndexOfNum);
		System.out.println("Index of the given number : " + index); // 3
	}

	private static int findNumberIndex(int[] nums, int findIndexOfNum) {
		// first occurence of a given num
		int index = -1;
		// Start the loop from starting to ending
		for (int i = 0; i < nums.length; i++) {
			// Check if the given number found in the array & return the index
			if (nums[i] == findIndexOfNum) {
				return i;
			}
		}
		return index;
	}
}
