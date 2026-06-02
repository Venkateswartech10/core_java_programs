package com.venkat.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.venkat.dsa.sorting.SwapNumbersUtil;

public class NextPermutationDemo {

	public static void main(String[] args) {
		// int[] arr = {2,1,5,4,3,0,0};
		int[] arr = {1,2,3};
		// Time Complexity: O(N!*N), since we are generating all possible permutations, it takes N! time.
		// Space Complexity: O(N!), storing all permutations.
		// List<Integer> nextPermu = nextPermutationBrute(arr);
		// System.out.println(nextPermu);
		
		
		// Time Complexity: O(N), we find the breaking point and reverse the subarray in linear time.
		// Space Complexity: O(1), constant additional space is used.
		nextPermutationOptimal(arr);
	}

	private static void nextPermutationOptimal(int[] arr) {
		// Set index to -1
		int breakPoint = -1;
		// Find the first decreasing (breakPoint) element from end
		for (int i = arr.length - 2; i >= 0; i--) {
			 // If smaller found
			if (arr[i] < arr[i + 1]) {
				// store index
				breakPoint = i;
				break;
			}
		}
		
		// If no breakPoint found
        if (breakPoint == -1) {
            // Reverse the entire array
            reverse(arr, 0, arr.length - 1);
            return;
        }

		// find greater than breakpoint, but the smallest one so that you stay close
		for (int i = arr.length -1; i > breakPoint; i--) {
			if (arr[i] > arr[breakPoint]) {
				SwapNumbersUtil.swap(arr, breakPoint, i);
				break;
			}
		}

		// Try to place remaining in sorted array
		reverse(arr, breakPoint + 1, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	// Helper to reverse array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
        	SwapNumbersUtil.swap(arr, start, end);
            start++;
            end--;
        }
    }

	// Function to find the next permutation
	private static List<Integer> nextPermutationBrute(int[] arr) {
		// List to hold all permutations
		List<List<Integer>> all = new ArrayList<>();
		// Sort the input to start from the smallest
		Arrays.sort(arr);
		// Generate all permutations
        permute(arr, 0, all);
        
     // Convert array to list for comparison
        List<Integer> current = new ArrayList<>();
        for (int num : arr)
            current.add(num);

        // Find and return the next permutation
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).equals(current)) {
                if (i == all.size() - 1)
                    return all.get(0);
                return all.get(i + 1);
            }
        }
        return current;
	}
	
	// Backtracking permutation generator
    private static void permute(int[] nums, int start, List<List<Integer>> all) {
        if (start == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            all.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
        	SwapNumbersUtil.swap(nums, i, start);
            permute(nums, start + 1, all);
            SwapNumbersUtil.swap(nums, i, start);
        }
    }
}
