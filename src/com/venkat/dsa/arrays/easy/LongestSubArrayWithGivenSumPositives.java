package com.venkat.dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSumPositives {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3, 1, 1, 1, 1, 4, 2, 3 };
		int k = 3;
		// TC - O(N square)
		// int length = findLongestSubArrayWithGivenSumPositivesBrute(nums, k);
		// System.out.print(length);

		int length = findLongestSubArrayWithGivenSumPositivesBetter(nums, k);
		System.out.print(length);

		//int length = findLongestSubArrayWithGivenSumPositivesOptimal(nums, k);
		//System.out.print(length);

	}

	public static int findLongestSubArrayWithGivenSumPositivesOptimal(int[] nums, int k) {
        int n = nums.length;

        // To store the maximum length of the subarray
        int maxLen = 0;

        // Pointers for sliding window
        int left = 0, right = 0;

        // Sum of the current window
        int sum = nums[0];

        // Traverse through the array
        while (right < n) {

            // Shrink the window if sum exceeds k
            while (left <= right && sum > k) {
                sum -= nums[left];
                left++;
            }

            // Update max length if sum equals k
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Expand the window to the right
            right++;
            if (right < n) {
                sum += nums[right];
            }
        }

        return maxLen;
    }

	// compute length of the longest subarray with sum 0
    public static int findLongestSubArrayWithGivenSumPositivesBetter(int[] A, int n) {
        // map prefix sum -> first index seen
        Map<Integer, Integer> mpp = new HashMap<>();
        // best length so far
        int maxi = 0;
        // running prefix sum
        int sum = 0;

        // iterate over the array
        for (int i = 0; i < n; i++) {
            // update running sum
            sum += A[i];

            // if sum is zero, subarray [0..i] has zero sum
            if (sum == 0) {
                // update best length
                maxi = i + 1;
            }
            // otherwise check if this sum was seen before
            else {
                // when seen, zero-sum segment between previous index + 1 and i
                if (mpp.containsKey(sum)) {
                    // maximize length
                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                // first time seeing this sum
                else {
                    // record index
                    mpp.put(sum, i);
                }
            }
        }

        // return best length
        return maxi;
    }

	private static int findLongestSubArrayWithGivenSumPositivesBrute(int[] nums, int sum) {
		int maxLength = 0;
		// Outer Loop starts from 0 - > n , 1 - > n
		for (int i = 0; i < nums.length; i++) {
			int summ = 0;
			// Inner loop starts from i & find the sum
			for (int j = i; j < nums.length; j++) {
				summ = summ + nums[j];
				// If sum is matching with the given sum and find length from j to i
				if (summ == sum) {
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}
		}
		return maxLength;
	}

}
