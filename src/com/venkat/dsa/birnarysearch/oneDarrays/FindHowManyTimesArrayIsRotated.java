package com.venkat.dsa.birnarysearch.oneDarrays;

public class FindHowManyTimesArrayIsRotated {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };

		// Time Complexity: O(n),We scan the entire array once to find the smallest element, where n is the size of the array.
		// Space Complexity: O(1),We only use a few extra variables to store the minimum value and its index, so the extra space used is constant.
		int rotations = findRotationsBrute(arr);
		System.out.println(rotations);
		
		// Time Complexity: O(n),We traverse the array once to find the rotation point, where n is the size of the array.
		// Space Complexity: O(1),Only a few extra variables are used regardless of input size, so constant space.
		int rotations1 = findRotationsBetter(arr);
		System.out.println(rotations1);
		
		// Time Complexity: O(log n),The binary search halves the search space each iteration, where n is the size of the array.
		// Space Complexity: O(1),Only a few variables are used regardless of input size, so constant extra space.
		int rotations2 = findRotationsOptimal(arr);
		System.out.println(rotations2);
	}

	private static int findRotationsOptimal(int[] arr) {
		int low = 0;
        int high = arr.length - 1;

        // Loop until low meets high
        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than element at high,
            // smallest element lies to the right of mid
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                // Else smallest element is at mid or to the left
                high = mid;
            }
        }

        // When low == high, we found the smallest element
        return low;
	}

	private static int findRotationsBetter(int[] arr) {
		int n = arr.length;
        // Traverse till second-last element
        for (int i = 0; i < n - 1; i++) {
            // If break in ascending order found
            if (arr[i] > arr[i + 1]) {
                // Index of next element is rotation count
                return i + 1;
            }
        }
        // No rotation found
        return 0;
	}

	private static int findRotationsBrute(int[] arr) {
		// Store size of array
		int n = arr.length;

		// Assume the first element is the smallest
		int minVal = arr[0];

		// Index of the smallest element
		int minIndex = 0;

		// Traverse the array
		for (int i = 1; i < n; i++) {
			// If current element is smaller than minVal, update
			if (arr[i] < minVal) {
				minVal = arr[i];
				minIndex = i;
			}
		}

		// The index of smallest element = number of rotations
		return minIndex;
	}

}
