package com.venkat.dsa.binarysearch.oneDarrays;

public class SearchInRotatedSortedArrayOne {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 0;
		// Time Complexity: O(N),We may need to check every element in the worst case if the target is not present.
		// Space Complexity: O(1),No extra space is used; only constant variables.
		int index = searchBrute(nums, target);
		System.out.println(index);
		
		// Time Complexity: O(log N),We eliminate half of the search space in each iteration using binary search.
		// Space Complexity: O(1),We use only a few variables (low, high, mid) no extra space used.
		int index1 = searchOptimal(nums, target);
		System.out.println(index1);
	}

	private static int searchOptimal(int[] nums, int target) {
		// Initialize search space
        int low = 0;
        int high = nums.length - 1;

        // Continue while there is still a valid search range
        while (low <= high) {

            // Calculate middle index
            int mid = (low + high) / 2;

            // If target found, return index
            if (nums[mid] == target)
                return mid;

            // If left part is sorted
            if (nums[low] <= nums[mid]) {

                // If target lies within sorted left part
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                }
                // Else, search in right half
                else {
                    low = mid + 1;
                }
            }

            // Else, right part is sorted
            else {

                // If target lies within sorted right part
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                }
                // Else, search in left half
                else {
                    high = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
	}

	private static int searchBrute(int[] nums, int target) {
		// Loop through each element in the array
		for (int i = 0; i < nums.length; i++) {

			// If current element matches target, return index
			if (nums[i] == target) {
				return i;
			}
		}

		// If not found, return -1
		return -1;
	}

}
