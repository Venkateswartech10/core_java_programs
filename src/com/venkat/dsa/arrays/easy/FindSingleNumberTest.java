package com.venkat.dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class FindSingleNumberTest {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 3, 3, 4, 4 }; // ans - 2
		// TC - O(n2)
		// SC - O(1)
		// int singleElement = findSingleElementBruteForce(nums);
		// System.out.println(singleElement);

		// Use Hashing
		// TC - O(3N)
		// SC - O(maximum num)
		// int singleElement = findSingleElementBetter(nums);
		// System.out.println(singleElement);

		// If array has negatives Use map
		// TC - O(N Log M) + O(N/2+1)
		// SC - O(N/2+1)
		// int singleElement = findSingleElementBetter1(nums);
		// System.out.println(singleElement);

		// Using XOR
		// TC - O(N)
		// SC - O(1)
		int singleElement = findSingleElementOptimal(nums);
		System.out.println(singleElement);

	}

	private static int findSingleElementOptimal(int[] nums) {
		// Iniitialize xor with 0 . 1^1 = 0 , 1^0 = 1
		// Loop all the elements in the array and do the xor of all elements
		int xor = 0;
		for ( int i =0;i<nums.length;i++) {
			xor = xor^nums[i];
		}
		return xor ;
	}

	private static int findSingleElementBetter1(int[] nums) {
		Map<Integer, Integer> map = new HashMap();
		// Loop all the elements in array and keep them in map with its frequency
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		System.out.println(map);
		// Loop all entries in map & check if the value is 1 then return that
		// corresponding value
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}

	private static int findSingleElementBetter(int[] nums) {
		// find maximum number in the array & create hash[] with maximum number + 1 size
		int maxNum = nums[0];
		for (int i = 0; i < nums.length; i++) {
			maxNum = Math.max(maxNum, nums[i]);
		}

		// Loop all nums in given array and increment the count for the corresponding
		// element in hash array
		int[] hash = new int[maxNum + 1];
		for (int i = 0; i < nums.length; i++) {
			hash[nums[i]]++;
		}

		// Loop all hash array find which element has exactly once in the hash array &
		// return its index
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] == 1) {
				return i;
			}
		}

		// If no element found then return -1
		return -1;
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
