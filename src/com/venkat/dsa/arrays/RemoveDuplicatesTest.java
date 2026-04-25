package com.venkat.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesTest {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 2, 3, 3 };
		// int noOfUniqueElements = removeDuplicatesBruteForce(nums);
		//System.out.print(noOfUniqueElements);
		int noOfUniqueElements = removeDuplicatesOptimal(nums);
		System.out.print(noOfUniqueElements);
	}

	private static int removeDuplicatesOptimal(int[] nums) {
		// 2 - Pointer approach
		// Initialize one pointer with zero index
		int i = 0;
		// Start for loop with second element & compare the second element with first
		// element
		// if not equal then move j pointer and i pointer . if equal to then move j
		// pointer alone
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				nums[i + 1] = nums[j];
				i++;
			}
		}
		// finally return index + 1 for no of unique elements
		return i + 1;
	}

	private static int removeDuplicatesBruteForce(int[] nums) {
		// Take Set Data structure and insert one by one element into set
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		// For loop to insert set elements into nums[] back
		int index = 0;
		for (Integer num : set) {
			nums[index] = num;
			index++;
		}
		return index + 1;
	}

}
