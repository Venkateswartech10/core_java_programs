package com.venkat.dsa.birnarysearch.oneDarrays;

public class SearchXInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 }; // sorted array
		int target = 6; // target element to search
		// Time Complexity: In the algorithm, in every step, we are basically dividing the search space into 2 equal halves. This is actually equivalent to dividing the size of the array by 2, every time. After a certain number of divisions, the size will reduce to such an extent that we will not be able to divide that anymore and the process will stop. The number of total divisions will be equal to the time complexity. So the overall time complexity is O(logN), where N = size of the given array.
		// Space Complexity: 0(1), no extra space being used
		int index = searchXInArrayIterative(arr, target);
		System.out.println(index);
		
		// Time Complexity: In the algorithm, in every step, we are basically dividing the search space into 2 equal halves. This is actually equivalent to dividing the size of the array by 2, every time. After a certain number of divisions, the size will reduce to such an extent that we will not be able to divide that anymore and the process will stop. The number of total divisions will be equal to the time complexity. So the overall time complexity is O(logN), where N = size of the given array.
		// Space Complexity: 0(1), no extra space being used
		int index1 = searchXInArrayRecursive(arr, target);
		System.out.println(index1);
	}

	private static int searchXInArrayRecursive(int[] arr, int target) {
		 return binarySearch(arr, 0, arr.length - 1, target);
	}
	
	// Recursive Binary Search function
    public static int binarySearch(int[] nums, int low, int high, int target) {
        if (low > high) return -1; // Base case: target not found

        // Find middle index
        int mid = (low + high) / 2;

        // If target is found at mid
        if (nums[mid] == target) return mid;
        // If target is greater, search right half
        else if (target > nums[mid])
            return binarySearch(nums, mid + 1, high, target);
        // Otherwise, search left half
        return binarySearch(nums, low, mid - 1, target);
    }

	private static int searchXInArrayIterative(int[] arr, int target) {
		int n = arr.length; // size of the array
		int low = 0, high = n - 1;
		// Keep searching until low crosses high
		while (low <= high) {
			int mid = (low + high) / 2; // Find the middle index
			if (arr[mid] == target)
				return mid; // Target found
			else if (target > arr[mid])
				low = mid + 1; // Search in right half
			else
				high = mid - 1; // Search in left half
		}
		return -1;
	}

}
