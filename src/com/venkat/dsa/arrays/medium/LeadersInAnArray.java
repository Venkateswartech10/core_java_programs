package com.venkat.dsa.arrays.medium;

import java.util.ArrayList;

public class LeadersInAnArray {

	public static void main(String[] args) {
		// Function to find leaders in an array.
		int[] nums = { 1, 2, 5, 3, 1, 2 };
		// Time Complexity: O(N2), where N is the size of the input array. This is because we have a nested loop where the outer loop runs N times and the inner loop runs up to N times in the worst case.
		// Space Complexity: O(1), as we are using only a constant amount of extra space for the answer array, which does not depend on the input size.
		leadersBrute(nums);

		// Time Complexity: O(N), where N is the size of the input array. This is because we traverse the array only once.
		// Space Complexity: O(1), as we are using only a constant amount of extra space.
		leadersOptimal(nums);
	}

	// Function to find the leaders in an array.
	private static void leadersOptimal(int[] nums) {
		ArrayList<Integer> ans = new ArrayList<>();
		// Last element of the array is always a leader
		int max = nums[nums.length - 1];
		ans.add(nums[nums.length - 1]);
		for (int i = nums.length - 2; i > 0; i--) {
			if (nums[i] > max) {
				ans.add(nums[i]);
				max = nums[i];
			}
			/*
			 * Reverse the list to match the required output order
			 */
			// Collections.reverse(ans);
		}
		System.out.println(ans);
	}

	private static void leadersBrute(int[] nums) {
		ArrayList<Integer> ans = new ArrayList<>();
		// Iterate through each element in nums
		for (int i = 0; i < nums.length; i++) {
			boolean leader = true;
			/*
			 * Check whether nums[i] is greater than all elements to its right
			 */
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] >= nums[i]) {
					/*
					 * If any element to the right is greater or equal, nums[i] is not a leader
					 */
					leader = false;
					break;
				}
			}
			// If nums[i] is a leader, add it to the ans list
			if (leader) {
				ans.add(i);
			}
		}
		// Return the leaders
		System.out.println(ans);
	}

}
