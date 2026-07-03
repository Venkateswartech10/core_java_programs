package com.venkat.dsa.arrays.hard;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysXOR {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 2, 6, 4 };
		// Target xor
		int target = 6;
		// Time Complexity: O(N^2), we generate all possible subarrays to check their XOR.
		// Space Complexity: O(1) , constant amount of extra space is used.
		System.out.println(countSubarraysXORBrute(arr, target));
		
		// Time Complexity: O(N), we traverse the entire array once to calculate prefix XOR and subarrays with given XOR.
		// Space Complexity: O(N) , additional amount of extra space is used to store frequencies of prefix XOR in hash map.
		System.out.println(countSubarraysXOROptimal(arr, target));
	}

	// Function to count subarrays with given XOR
	private static int countSubarraysXOROptimal(int[] arr, int target) {
		// Store frequency of prefix XORs
		Map<Integer, Integer> freq = new HashMap<>();
		// Initialize with prefix XOR 0
		freq.put(0, 1);

		// Current prefix XOR
		int prefixXor = 0;
		// Answer count
		int count = 0;

		// Traverse array
		for (int num : arr) {
			// Update prefix XOR
			prefixXor ^= num;

			// Compute required XOR
			int required = prefixXor ^ target;

			// If required exists in map, add its frequency
			if (freq.containsKey(required)) {
				count += freq.get(required);
			}

			// Store current prefix XOR in map
			freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
		}
		return count;
	}

	// Function to count subarrays with XOR equal to target
	private static int countSubarraysXORBrute(int[] arr, int target) {
		// Initialize count of valid subarrays
		int count = 0;
		// Traverse all starting points
		for (int i = 0; i < arr.length; i++) {
			// Maintain xor of current subarray
			int xorVal = 0;
			// Extend subarray till end
			for (int j = i; j < arr.length; j++) {
				// Update xor
				xorVal ^= arr[j];
				// If xor equals target, increment count
				if (xorVal == target) {
					count++;
				}
			}
		}
		return count;
	}

}
