package com.venkat.dsa.birnarysearch.oneDarrays;

public class SearchInsertPositionInArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 7};
        int x = 6;
        // Time Complexity: O(logN), where N = size of the given array.
        // Space Complexity: O(1) as we are using no extra space.
        int index = searchInsertPosition(arr, x);
        System.out.println("The index is: " + index);
	}

	private static int searchInsertPosition(int[] arr, int x) {
		int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n; // Default to end if x is greater than all elements

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                // Potential answer found, try to go left
                ans = mid;
                high = mid - 1;
            } else {
                // Go right
                low = mid + 1;
            }
        }

        return ans;
	}

}
