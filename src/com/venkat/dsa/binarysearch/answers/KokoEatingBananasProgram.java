package com.venkat.dsa.binarysearch.answers;

import java.util.Arrays;

public class KokoEatingBananasProgram {

	public static void main(String[] args) {
		int[] a = { 3, 6, 7, 11 };
		// Hours allowed
		int h = 8;
		
		// Time Complexity: O(n * max(a[])), since for each possible speed we go through all the piles.
		// Space Complexity: O(1), since the algorithm does not use any additional space or data structures.
		System.out.println(minEatingSpeedBrute(a, h));
		
		// Time Complexity: O(N*log(max(a[]))), we apply binary search on our search space to reduce it into half at every step.
		// Space Complexity: O(1), since the algorithm does not use any additional space or data structures.
		System.out.println(minEatingSpeedOptimal(a, h));

	}

	private static int minEatingSpeedOptimal(int[] piles, int h) {
		// Find maximum element
        int maxPile = Arrays.stream(piles).max().getAsInt();

        // Initialize low and high pointers
        int low = 1, high = maxPile;
        int ans = maxPile;

        // Binary search on answer space
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalH = calculateTotalHours(piles, mid);

            // If possible, try smaller speed
            if (totalH <= h) {
                ans = mid;
                high = mid - 1;
            }
            // Otherwise, try larger speed
            else {
                low = mid + 1;
            }
        }
        return ans;
	}

	private static int minEatingSpeedBrute(int[] a, int h) {
		// Find maximum pile size
		int maxVal = Arrays.stream(a).max().getAsInt();
		// Try every possible speed
		for (int i = 1; i <= maxVal; i++) {
			int hours = calculateTotalHours(a, i);

			// If hours fit within h
			if (hours <= h) {
				return i;
			}
		}
		return maxVal;
	}

	private static int calculateTotalHours(int[] a, int hourly) {
		int totalHours = 0;
		for (int pile : a) {
			// Add hours using ceil
			totalHours += (int) Math.ceil((double) pile / hourly);
		}
		return totalHours;
	}

}
