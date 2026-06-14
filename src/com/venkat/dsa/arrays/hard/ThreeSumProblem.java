package com.venkat.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblem {

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		int n = arr.length;
		// Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.
		// Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
		// Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
		List<List<Integer>> res = threeSumBrute(arr, n);

		for (List<Integer> triplet : res) {
			for (int num : triplet)
				System.out.print(num + " ");
			System.out.println();
		}
		
		System.out.println("############");
		// Time Complexity: O(N2 * log(no. of unique triplets)), as we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
		// Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.
		List<List<Integer>> resBetter = threeSumBetter(arr, n);

		for (List<Integer> triplet : resBetter) {
			for (int num : triplet)
				System.out.print(num + " ");
			System.out.println();
		}
		
		System.out.println("############");
		// Time Complexity: O(NlogN)+O(N2), as The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 
		// Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).
		List<List<Integer>> resOptimal = threeSumOptimal(arr, n);

		for (List<Integer> triplet : resOptimal) {
			for (int num : triplet)
				System.out.print(num + " ");
			System.out.println();
		}
	}
	
	// Function to find triplets with sum zero
	private static List<List<Integer>> threeSumOptimal(int[] arr, int n) {
		// Sort the array
		Arrays.sort(arr);
		// Store final result
		List<List<Integer>> ans = new ArrayList<>();

		// First loop for first element
		for (int i = 0; i < n; i++) {
			// Skip duplicates for first element
			if (i > 0 && arr[i] == arr[i - 1])
				continue;

			// Two pointers
			int left = i + 1, right = n - 1;

			// Find pairs for current arr[i]
			while (left < right) {
				int sum = arr[i] + arr[left] + arr[right];

				if (sum == 0) {
					ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
					left++;
					right--;

					// Skip duplicates for left
					while (left < right && arr[left] == arr[left - 1])
						left++;
					// Skip duplicates for right
					while (left < right && arr[right] == arr[right + 1])
						right--;
				} else if (sum < 0)
					left++;
				else
					right--;
			}
		}
		return ans;
	}


	// Function to find triplets with sum zero
	private static List<List<Integer>> threeSumBetter(int[] arr, int n) {

		// Store unique triplets
		Set<List<Integer>> ans = new HashSet<>();

		// First loop for first element
		for (int i = 0; i < n; i++) {
			// Set to store elements seen in this iteration
			Set<Integer> hashset = new HashSet<>();

			// Second loop for second element
			for (int j = i + 1; j < n; j++) {
				// Calculate third element needed
				int third = -(arr[i] + arr[j]);

				// If third already in set, we found a triplet
				if (hashset.contains(third)) {
					List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
					Collections.sort(temp);
					ans.add(temp);
				}

				// Add current element to set
				hashset.add(arr[j]);
			}
		}

		// Convert set to list
		return new ArrayList<>(ans);
	}
	

	// Function to find triplets with sum zero
	private static List<List<Integer>> threeSumBrute(int[] arr, int n) {
		// Store unique triplets
		Set<List<Integer>> st = new HashSet<>();

		// First loop for first element
		for (int i = 0; i < n; i++) {
			// Second loop for second element
			for (int j = i + 1; j < n; j++) {
				// Third loop for third element
				for (int k = j + 1; k < n; k++) {
					// If triplet sum is zero
					if (arr[i] + arr[j] + arr[k] == 0) {
						// Store sorted triplet to avoid duplicates
						List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
						Collections.sort(temp);
						st.add(temp);
					}
				}
			}
		}

		// Convert set to list
		return new ArrayList<>(st);
	}

}
