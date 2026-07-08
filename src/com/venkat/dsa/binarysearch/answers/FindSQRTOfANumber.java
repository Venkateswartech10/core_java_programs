package com.venkat.dsa.binarysearch.answers;

public class FindSQRTOfANumber {

	public static void main(String[] args) {
		int n = 27;
		
		// Time Complexity: O(N), we check for every number from 1 to N.
		// Space Complexity: O(1), since the algorithm does not use any additional space or data structures.
		System.out.println(floorSqrtBrute(n));
		
		// Time Complexity: O(log(N)), we apply binary search on our search space to reduce it into half at every step.
		// Space Complexity: O(1), since the algorithm does not use any additional space or data structures.
		System.out.println(floorSqrtOptimal(n));
	}

	private static int floorSqrtOptimal(int n) {
		// Handle small numbers directly
        if (n < 2) return n;
        // Initialize binary search range
        int left = 1, right = n / 2, ans = 0;
        // Perform binary search
        while (left <= right) {
            // Find middle point
            long mid = left + (right - left) / 2;

            // Check if mid*mid is less than or equal to x
            if (mid * mid <= n) {
                // Store mid as potential answer
                ans = (int) mid;
                // Move to right half
                left = (int) mid + 1;
            } else {
                // Move to left half
                right = (int) mid - 1;
            }
        }

        return ans;
	}

	private static int floorSqrtBrute(int n) {
		// Variable to store answer
        int ans = 0;
        // Run loop from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if i*i <= n
            if ((long)(i) * i <= n) {
                // Update answer
                ans = i;
            } else {
                // Break when i*i > n
                break;
            }
        }
        // Return final answer
        return ans;
	}

}
