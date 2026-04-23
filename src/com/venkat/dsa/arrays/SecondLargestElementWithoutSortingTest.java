package com.venkat.dsa.arrays;

import java.util.Arrays;

public class SecondLargestElementWithoutSortingTest {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 7, 7, 5 };
		// int secondLargestNumBurute = bruteForceApproach(nums);
		// System.out.println(secondLargestNumBurute);
		// int secondLargestNumBetter = betterApproach(nums); // TC -> O(N) + O(N) = O(2N)
		// System.out.println(secondLargestNumBetter);
		int secondLargestNumOptimal = optimalApproach(nums);
		System.out.println(secondLargestNumOptimal);
		
		int secondSmallestNumOptimal = secondSmallestOptimalApproach(nums);
		System.out.println(secondSmallestNumOptimal);
	}

	private static int secondSmallestOptimalApproach(int[] nums) {
		// Initialize the first element as smallest
		int smallest = nums[0];
		int secondSmallest = Integer.MAX_VALUE;
		// Loop all elements and check if smallest element is smaller . If smaller then
		// update second smallest value with smallest & smallest will be the current index
		// value
		for(int i=0;i<nums.length;i++) {
			if(nums[i] < smallest) {
				secondSmallest = smallest;
				smallest = nums[i];
			}
			// this else condition to check if duplicate smallest number then skip the
			// iteration & update only second smallest number if it is less than second
			// smallest number
			else if(nums[i] != smallest && nums[i] < secondSmallest) {
				secondSmallest = nums[i];
			}
		}
		return secondSmallest;
	}

	private static int betterApproach(int[] nums) {
		// First pass/loop to find largest number
		int largest = optimalApproach(nums);
		int secondLargest = -1;
		// Second pass / loop to find second largest number
		for (int i = 0; i < nums.length; i++) {
			// Iterate all the elements and make sure second largest is not largest number
			if (nums[i] > secondLargest && nums[i] != largest) {
				secondLargest = nums[i];
			}
		}
		return secondLargest;
	}

	private static int optimalApproach(int[] nums) {
		// Initialize the first element as largest
		int largest = nums[0];
		int secondLargest = -1;
		// Loop all elements and check if largest element is smaller . If smaller then
		// update second largest value with largest & largest will be the current index
		// value
		for (int i = 1; i < nums.length; i++) { // TC -> O(N)
			if (largest < nums[i]) {
				secondLargest = largest;
				largest = nums[i];
			}
			// this else condition to check if duplicate largest number then skip the
			// iteration & update only second largest number if it is greater than second
			// largest number
			else if (nums[i] < largest && nums[i] > secondLargest) {
				secondLargest = nums[i];
			}
		}
		// finally return largest value
		return secondLargest;
	}

	private static int bruteForceApproach(int[] nums) {
		// Use any Sorting technique of an array and last index value will be largest
		Arrays.sort(nums); // TC to sort an array is - O(N log N)
		int largest = nums[nums.length - 1];
		int secondLargest = 0;
		// Loop all the elements from second last to first element to find 2nd largest.
		for (int i = nums.length - 2; i >= 0; i--) {
			// this condition to check second largest is not the largest & break the loop if
			// we find second largest
			if (largest != nums[i]) {
				secondLargest = nums[i];
				break;
			}
		}
		return secondLargest;
	}

}
