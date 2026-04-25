package com.venkat.dsa.arrays;

public class CheckArrayIsSortedTest {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 2, 3, 3, 4 };
		boolean isSorted = checkIsArraySorted(nums);
		if (isSorted)
			System.out.print("Sorted");
		else
			System.out.println("Unsorted");
	}

	private static boolean checkIsArraySorted(int[] nums) {
		// Loop starts from second element( index =1 ) As we will compare the elements
		// from second onwards
		for (int i = 1; i < nums.length; i++) {
			// If second element is greaterthan or equal to first element then do nothing
			// else return false
			if (nums[i] >= nums[i - 1]) {
			} else {
				return false;
			}
		}
		return true;
	}

}
