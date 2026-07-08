package com.venkat.dsa.binarysearch.oneDarrays;

public class UpperBoundInSortedArray {

	public static void main(String[] args) {
		int[] arr = {3, 5, 8, 9, 15, 19}; // Sorted array
        int x = 9;
        // Time Complexity: O(N), where N = size of the given array.
        // Space Complexity: O(1), no extra space used.
        int index = upperBoundBrute(arr, x); // Call function
        System.out.println("The upper bound is the index: " + index); // Output result
        
        // Time Complexity: O(logn), used for typical binary search
        // Space Complexity: O(1), no extra space used.
        int index1 = upperBoundOptimal(arr, x); // Call function
        System.out.println("The upper bound is the index: " + index1); // Output result
	}

	private static int upperBoundOptimal(int[] arr, int x) {
		int low = 0, high = arr.length - 1;
        int ans = arr.length;  // Default to length if not found

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;        // Store current index as potential answer
                high = mid - 1;   // Move left
            } else {
                low = mid + 1;    // Move right
            }
        }
        return ans;  // Return final answer
	}

	private static int upperBoundBrute(int[] arr, int x) {
		for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x) {
                return i; // Return index of first element > x
            }
        }
        return arr.length; // Return length if no such element found
	}

}
