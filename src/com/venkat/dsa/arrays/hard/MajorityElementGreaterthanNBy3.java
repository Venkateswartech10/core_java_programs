package com.venkat.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementGreaterthanNBy3 {

	public static void main(String[] args) {
		int[] arr = {11, 33, 33, 11, 33, 11};
		// Time Complexity: O(N^2), where N is the size of the array. This is because for each element, we are traversing the entire array to count its occurrences.
		// Space Complexity: O(1), as we are using a constant amount of space for the result array, which can hold at most 2 elements.
		List<Integer> ans = majorityElementThreeBrute(arr);

        System.out.print("The majority elements are: ");
        for (int it : ans) {
            System.out.print(it + " ");
        }
        System.out.println();
        
        // Time Complexity: O(N * logN), where N is the size of the given array. For using a map data structure, where insertion in the map takes logN time, and we are doing it for N elements. So, it results in the first term O(N * logN). On using unordered_map instead, the first term will be O(N) for the best and average case, and for the worst case, it will be O(N2).
        // Space Complexity: O(N) for using a map data structure. A list that stores a maximum of 2 elements is also used, but that space used is so small that it can be considered constant.
        List<Integer> ans1 = majorityElementThreeBetter(arr);
        System.out.print("The majority elements are: ");
        for (int it : ans1) {
            System.out.print(it + " ");
        }
        System.out.println();
        
        // Time Complexity: O(N), where N is the size of the input array. We traverse the array twice: once to find potential candidates and once to validate them.
        // Space Complexity: O(1), as we are using a constant amount of space for the counters and candidate elements, regardless of the input size.
        List<Integer> ans2 = majorityElementThreeOptimal(arr);
        System.out.print("The majority elements are: ");
        for (int it : ans2) {
            System.out.print(it + " ");
        }
        System.out.println();
        
	}

	// Function to find majority elements in an array
	private static List<Integer> majorityElementThreeOptimal(int[] nums) {
		int n = nums.length;
		int cnt1 = 0, cnt2 = 0;
		int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) 	{
			if (cnt1 == 0 && el2 != nums[i]) {
				cnt1 = 1;
				el1 = nums[i];
			} else if (cnt2 == 0 && el1 != nums[i]) {
				cnt2 = 1;
				el2 = nums[i];
			} else if (nums[i] == el1) {
				cnt1++;
			} else if (nums[i] == el2) {
				cnt2++;
			} else {
				cnt1--;
				cnt2--;
			}
		}

		cnt1 = 0;
		cnt2 = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == el1)
				cnt1++;
			if (nums[i] == el2)
				cnt2++;
		}

		int mini = n / 3 + 1;
		List<Integer> result = new ArrayList<>();
		if (cnt1 >= mini)
			result.add(el1);
		if (cnt2 >= mini && el1 != el2)
			result.add(el2);

		return result;
	}

	// Function to find majority elements in an array
	private static List<Integer> majorityElementThreeBetter(int[] nums) {
		int n = nums.length;
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> mpp = new HashMap<>();
		int mini = n / 3 + 1;

		for (int i = 0; i < n; i++) {
			mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);

			// Add to result only when the count just reaches mini
			if (mpp.get(nums[i]) == mini) {
				result.add(nums[i]);
			}
			if (result.size() == 2)
				break;
		}
		return result;
	}

	// Function to find majority elements in an array
	private static List<Integer> majorityElementThreeBrute(int[] arr) {
		int n = arr.length;
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			// Check if nums[i] is not already part of the result
			if (result.size() == 0 || result.get(0) != arr[i] && (result.size() < 2 || result.get(1) != arr[i])) {
				int count = 0;
				for (int j = 0; j < n; j++) {
					if (arr[j] == arr[i]) {
						count++;
					}
				}
				if (count > n / 3) {
					result.add(arr[i]);
				}
			}

			if (result.size() == 2) {
				break;
			}
		}

		return result;
	}

}
