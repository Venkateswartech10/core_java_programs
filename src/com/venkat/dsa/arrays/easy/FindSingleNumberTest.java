package com.venkat.dsa.arrays.easy;

public class FindSingleNumberTest {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 3, 4, 4 }; // ans - 2
		// TC - O(n2)
		// SC - O(1)
		// int singleElement = findSingleElementBruteForce(nums);
		// System.out.println(singleElement);
		
		int singleElement = findSingleElementBetter(nums);
		System.out.println(singleElement);
	}

	private static int findSingleElementBetter(int[] nums) {
		
		return 0;
	}

	private static int findSingleElementBruteForce(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int element = nums[i];
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == element) {
					count++;
				}
			}
			if (count == 1) {
				return i;
			}
		}
		return -1;
	}

}
