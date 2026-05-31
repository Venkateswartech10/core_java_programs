package com.venkat.dsa.arrays.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementGreaterthanNBy2 {

	public static void main(String[] args) {
		int[] arr = {2, 2, 1, 1, 1, 2, 2};
		// Time Complexity: O(N^2), where N is the size of the input array. This is because we are using a nested loop to count the occurrences of each element.
		// Space Complexity: O(1), as we are using a constant amount of space for the counters and indices.
		// int majorityElement = majorityElementBrute(arr);
		// System.out.println(majorityElement);
		
		// Time Complexity: O(N log N), where N is the size of the input array. This is because we are iterating through the array once to count occurrences and then iterating through the hashmap to find the majority element.
		// Space Complexity: O(N), as we are using a hashmap to store the counts of each element, which can take up to N space in the worst case.
		// int majorityElement = majorityElementBetter(arr);
		// System.out.println(majorityElement);
		
		// Moore’s Voting Algorithm
		// Time Complexity: O(N), where N is the size of the input array. This is because we are iterating through the array once to find the potential majority element and then again to verify it.
		// Space Complexity: O(1), as we are using only a constant amount of extra space.
		int majorityElement = majorityElementOptimal(arr);
		System.out.println(majorityElement);
	}

	private static int majorityElementOptimal(int[] arr) {
		// Candidate element
		int element = 0;
		// Count variable
		int count = 0;
		// Step 1: Find the potential majority element
		for (int i = 0; i < arr.length; i++) {
			if (count == 0) {
				count = 1;
				element = arr[i];
			} else if (arr[i] == element) {
				count++;
			} else {
				count--;
			}
		}
		// Step 2: Verify the candidate
		int cnt1 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == element) {
				cnt1++;
			}
		}

		// Return the element if it's a majority
		if (cnt1 > (arr.length / 2)) {
			return element;
		}
		// No majority found
		return -1;
	}

	// Function to find the majority element in an array
	private static int majorityElementBetter(int[] arr) {
		// Hash map to store element counts
		HashMap<Integer,Integer> map = new HashMap<>();
		// Count occurrences of each element
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		/* Iterate through the map to
        find the majority element */
		for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
			if(entry.getValue() > arr.length/2) {
				return entry.getKey();
			}
		}
		// Return -1 if no majority element is found
		return -1;
	}

	// Function to find the majority element in an array
	private static int majorityElementBrute(int[] arr) {
		// Iterate through each element of the array
		for (int i = 0; i < arr.length; i++) {
			// Counter to count occurrences of nums[i]
			int count = 0;
			// Count the frequency of nums[i] in the array
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			// Check if frequency of nums[i] is greater than n/2
			if (count > arr.length / 2) {
				// Return the majority element
				return arr[i];
			}
		}
		// Return -1 if no majority element is found
		return -1;
	}

}
