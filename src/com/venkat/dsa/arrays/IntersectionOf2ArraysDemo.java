package com.venkat.dsa.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOf2ArraysDemo {

	public static void main(String[] args) {
		int[] nums1 = { 1, 1, 2, 3, 4, 5 };
		int[] nums2 = { 2, 3, 4, 4, 5, 6 };
		// TC = O(n1 log n ) + O(n2 log n) + O(n1+n2)
		// SC = O(n1+n2) + O(n1+n2)
		// int[] unionArray = unionArrayBruteForce(nums1, nums2);
		// System.out.println(Arrays.toString(unionArray)); // [1, 2, 3, 4, 5, 6]
		// TC - O(n1+n2)
		// SC - O(n1+n2)
		List unionArray = unionArrayOptimal(nums1, nums2);
		System.out.println(unionArray); // [1, 2, 3, 4, 5, 6]
	}

	private static List unionArrayOptimal(int[] nums1, int[] nums2) {
		// 2 - Pointer Approach
		List<Integer> union = new ArrayList();
		// Initialize pointers
		int i = 0;
		int j = 0;
		// Loop continues until one of the array finesh
		while (i < nums1.length && j < nums2.length) {
			// Divide the problem into 3 scenarios
			// 1 Scenario is first array of first element is smaller than second array of
			// first element
			// 2 Scenario is second array of first element is smaller than first array of
			// first element
			// 3 if both elements are equal
			if (nums1[i] < nums2[j]) {
				// Add if empty or not duplicate
				if (union.isEmpty() || union.get(union.size() - 1) != nums1[i])
					union.add(nums1[i]);
				i++; // Move pointer in arr1
			} else if (nums2[j] < nums1[i]) {
				// If element in arr2 is smaller
				// Add if empty or not duplicate
				if (union.isEmpty() || union.get(union.size() - 1) != nums2[j])
					union.add(nums2[j]);
				j++; // Move pointer in arr2
			} else {
				// Elements are equal, add once if not duplicate
				if (union.isEmpty() || union.get(union.size() - 1) != nums1[i])
					union.add(nums1[i]);
				i++;
				j++; // Move both pointers
			}
		}

		// Append remaining elements from arr1
		while (i < nums1.length) {
			if (union.isEmpty() || union.get(union.size() - 1) != nums1[i])
				union.add(nums1[i]);
			i++;
		}

		// Append remaining elements from arr2
		while (j < nums2.length) {
			if (union.isEmpty() || union.get(union.size() - 1) != nums2[j])
				union.add(nums2[j]);
			j++;
		}
		return union;
	}

	private static int[] unionArrayBruteForce(int[] nums1, int[] nums2) {
		// Take one set & add all the elements into set
		Set<Integer> set = new HashSet();
		// Loop first array and add all elements
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		// Loop second array and add all elements
		for (int i = 0; i < nums2.length; i++) {
			set.add(nums2[i]);
		}
		System.out.println(set); // [1, 2, 3, 4, 5, 6]
		// Declare union array & add set elements into union array
		int[] union = new int[set.size()];
		int index = 0;
		for (int element : set) {
			union[index] = element;
			index++;
		}

		return union;
	}

}
