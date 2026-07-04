package com.venkat.dsa.arrays.hard;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 0, 0, 0 };
		int[] nums2 = { 2, 4, 6 };
		int m = 3, n = 3;
		mergeSortedArrays(nums1, nums2, m, n);
		// Print the merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
	}

	private static void mergeSortedArrays(int[] nums1, int[] nums2, int m, int n) {
		// i: last valid index in nums1
		int i = m - 1;

		// j: last index in nums2
		int j = n - 1;

		// k: last index in nums1 including extra 0s
		int k = m + n - 1;

		// Fill nums1 from the back to replace the 0's if we do from first we loss the elements
		while (i >= 0 && j >= 0) {
			// Place larger element from end of nums1 or nums2
			if (nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--];
			}
		}

		// If nums2 has leftovers, copy them to nums1
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
		// Remaining nums1 elements are already in correct position

	}

}
