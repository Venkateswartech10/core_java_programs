package com.venkat.dsa.arrays.easy;

public class LongestSubArrayWithGivenSumPositives {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
		int sum = 3;
		// TC - O(N square)
		// int length = findLongestSubArrayWithGivenSumPositivesBrute(nums, sum);
		// System.out.print(length);

		int length = findLongestSubArrayWithGivenSumPositivesBetter(nums, sum);
		System.out.print(length);

		int length = findLongestSubArrayWithGivenSumPositivesOptimal(nums, sum);
		System.out.print(length);

	}

	private static int findLongestSubArrayWithGivenSumPositivesOptimal(int[] nums, int sum) {
		return 0;
	}

	private static int findLongestSubArrayWithGivenSumPositivesBetter(int[] nums, int sum) {
		return 0;
	}

	private static int findLongestSubArrayWithGivenSumPositivesBrute(int[] nums, int sum) {
		int maxLength = 0;
		// Outer Loop starts from 0 - > n , 1 - > n
		for (int i = 0; i < nums.length; i++) {
			int summ = 0;
			// Inner loop starts from i & find the sum
			for (int j = i; j < nums.length; j++) {
				summ = summ + nums[j];
				// If sum is matching with the given sum and find length from j to i
				if (summ == sum) {
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}
		}
		return maxLength;
	}

}
