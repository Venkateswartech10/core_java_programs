package com.venkat.dsa.binarysearch.answers;

public class NthRootOfANumber {

	public static void main(String[] args) {
		int n = 3, m = 27;

		// Time Complexity: O(M), we search for every possible number from 1 to M to check if it is the Nth root.
		// Space Complexity: O(1), constant additional space is used.
        System.out.println("Nth Root: " + nthRootBrute(n, m));
        
        // Time Complexity: O(logM), we search for every possible number from 1 to M to check if it is the Nth root.
        // Space Complexity: O(1), constant additional space is used.
        System.out.println("Nth Root: " + nthRootOptimal(n, m));
	}

	private static int nthRootOptimal(int n, int m) {
		// Set low and high for binary search
        int low = 1, high = m;
        // Start binary search
        while (low <= high) {
            // Calculate mid
            int mid = (low + high) / 2;
            // Store result of mid^n
            long ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= mid;
                if (ans > m) break;
            }

            // If mid^n equals m
            if (ans == m) return mid;

            // If mid^n is less than m
            if (ans < m) low = mid + 1;

            // If mid^n is more than m
            else high = mid - 1;
        }

        // Return -1 if not found
        return -1;
	}

	private static int nthRootBrute(int n, int m) {
		// Loop from 1 to m
        for (int i = 1; i <= m; i++) {
            // Compute i^n
            long power = (long) Math.pow(i, n);

            // If equal to m, return i
            if (power == m) return i;

            // If exceeds m, break
            if (power > m) break;
        }

        // If not found, return -1
        return -1;
	}

}
