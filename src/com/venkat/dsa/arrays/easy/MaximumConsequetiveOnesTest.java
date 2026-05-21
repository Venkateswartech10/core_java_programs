package com.venkat.dsa.arrays.easy;

public class MaximumConsequetiveOnesTest {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 1, 1, 1, 0, 1, 1 };
		int maxConsequetive = findMaxConsequetive(nums);
		System.out.println(maxConsequetive); // 3
	}

	private static int findMaxConsequetive(int[] nums) {
		// initialize count & maxConsequetive to 0
		int count = 0;
		int maxConsequetive = 0;
		// Loop all the elements and increment count else reset to 0 as the count
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				count++;
				// find maxConsequetive by max of count and maxConsequetive
				maxConsequetive = Math.max(count, maxConsequetive);
			} else {
				count = 0;
			}
		}
		return maxConsequetive;
	}

}
