package com.venkat.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumProblem {

	public static void main(String[] args) {
		int[] arr = {1, 0, -1, 0, -2, 2};
		// Target sum
        int target = 0;
		// Time Complexity: O(N3 * log(no. of unique triplets)), where N = size of the array.
		// Reason: Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.
		// Space Complexity: O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
		List<List<Integer>> res = fourSumBrute(arr, target);

		// Print result
        for (List<Integer> quad : res) {
            System.out.println(quad);
        }
		
		System.out.println("############");
		// Time Complexity: O(N3*log(M)), as we are mainly using 3 nested loops, and inside the loops there are some operations on the set data structure which take log(M) time complexity.
		// Space Complexity: O(2 * no. of the quadruplets)+O(N), as we are using a set data structure and a list to store the quads. This results in the first term. And the second space is taken by the set data structure we are using to store the array elements. At most, the set can contain approximately all the array elements and so the space complexity is O(N).
		List<List<Integer>> resBetter = fourSumBetter(arr, target);

		for (List<Integer> quad : resBetter) {
			System.out.println(quad);
		}
		
		System.out.println("############");
		// Time Complexity: O(N3), as Each of the pointers i and j, is running for approximately N times. And both the pointers k and l combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N3). 
		// Space Complexity: O(no. of quadruplets), as This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).
		List<List<Integer>> resOptimal = fourSumOptimal(arr, target);

		for (List<Integer> quad : resOptimal) {
            System.out.println(quad);
        }
	}

	private static List<List<Integer>> fourSumOptimal(int[] arr, int target) {
		int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Step 1: Sort array
        Arrays.sort(arr);

        // Step 2: First loop for first number
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            // Step 3: Second loop for second number
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;

                // Step 4: Two pointers
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] +
                               arr[left] + arr[right];

                    if (sum == target) {
                        ans.add(Arrays.asList(arr[i], arr[j],
                                              arr[left], arr[right]));

                        while (left < right && arr[left] == arr[left + 1]) left++;
                        while (left < right && arr[right] == arr[right - 1]) right--;

                        left++;
                        right--;
                    }
                    else if (sum < target) left++;
                    else right--;
                }
            }
        }
        return ans;
	}

	// Function to find all unique quadruplets
	private static List<List<Integer>> fourSumBetter(int[] arr, int target) {
		int n = arr.length;
		Set<List<Integer>> set = new HashSet<>();

		// First loop - pick first number
		for (int i = 0; i < n; i++) {
			// Second loop - pick second number
			for (int j = i + 1; j < n; j++) {
				// HashSet for numbers between j and k
				HashSet<Integer> seen = new HashSet<>();

				// Third loop - pick third number
				for (int k = j + 1; k < n; k++) {
					// Find required fourth number
					long required = (long) target - arr[i] - arr[j] - arr[k];

					// If required number already seen → valid quadruplet
					if (seen.contains((int) required)) {
						List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], (int) required);
						Collections.sort(temp);
						set.add(temp);
					}

					// Add current third number into set
					seen.add(arr[k]);
				}
			}
		}
		return new ArrayList<>(set);
	}

	// Function to find quadruplets with sum = target
	private static List<List<Integer>> fourSumBrute(int[] arr, int target) {
		// Get size of array
		int n = arr.length;
		// Use set to avoid duplicate quadruplets
		Set<List<Integer>> set = new HashSet<>();

		// First loop - pick first element
		for (int i = 0; i < n; i++) {
			// Second loop - pick second element
			for (int j = i + 1; j < n; j++) {
				// Third loop - pick third element
				for (int k = j + 1; k < n; k++) {
					// Fourth loop - pick fourth element
					for (int l = k + 1; l < n; l++) {
						// Calculate sum of four numbers
						long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
						// If sum matches target
						if (sum == target) {
							// Create quadruplet
							List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
							// Sort to maintain uniqueness
							Collections.sort(temp);
							// Add to set
							set.add(temp);
						}
					}
				}
			}
		}
		// Convert set to list and return
		return new ArrayList<>(set);
	}

}
