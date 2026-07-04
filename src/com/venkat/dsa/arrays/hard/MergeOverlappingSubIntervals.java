package com.venkat.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

		// Time Complexity: O(N^2), for every interval we check all future intervals.
		// Space Complexity: ON), additonal space used to store the non-overlapping intervals.
		/*
		 * List<List<Integer>> result = mergeSubintervalsBrute(intervals); for
		 * (List<Integer> interval : result) { System.out.print(interval + " "); }
		 */
		
		// Time Complexity: O(N*logN) + O(N), we sort the entire array and then merge them in a single pass.
		// Space Complexity: O(N), additonal space used to store the non-overlapping intervals.
		/*
		 * List<List<Integer>> result = mergeSubintervalsOptimal(intervals); for
		 * (List<Integer> interval : result) { System.out.print(interval + " "); }
		 */
		
		int[][] result = mergeSubintervalsOptimal1(intervals); 
		for(int[] interval : result) { 
			System.out.print("["+interval[0] + " " +interval[1]+"]"); 
		}
		

	}

	private static int[][] mergeSubintervalsOptimal1(int[][] intervals) {
		// Sort intervals based on start time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<int[]> ans = new ArrayList<>();
		int[] newInterval = intervals[0];
		ans.add(newInterval);
		for (int[] interval : intervals) {
			if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
				newInterval[1] = Math.max(newInterval[1], interval[1]);
			else { // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				ans.add(newInterval);
			}
		}

		return ans.toArray(new int[ans.size()][]);
	}

	private static List<List<Integer>> mergeSubintervalsOptimal(int[][] intervals) {
		// Sort intervals based on start time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<List<Integer>> ans = new ArrayList<>();
		
		// Traverse through all intervals
        for (int[] interval : intervals) {
            // If merged list is empty or no overlap
            if (ans.isEmpty() || ans.get(ans.size() - 1).get(1) < interval[0]) {
                // Add current interval as a new block
                ans.add(Arrays.asList(interval[0], interval[1]));
            } else {
                // Overlapping: update end to max of both
                int last = ans.size() - 1;
                int maxEnd = Math.max(ans.get(last).get(1),interval[1]);
                ans.get(last).set(1, maxEnd);
            }
        }
        return ans;
	}

	private static List<List<Integer>> mergeSubintervalsBrute(int[][] intervals) {

		// Sort intervals based on start time
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		List<List<Integer>> ans = new ArrayList<>();

		int n = intervals.length;
		int i = 0;
		while (i < n) {
			// Start of merged interval
			int start = intervals[i][0];
			int end = intervals[i][1];

			// move j pointer to compare start value
			int j = i + 1;
			// Check all overlapping intervals
			while (j < n && intervals[j][0] <= end) {
				// Extend the end of current interval
				end = Math.max(end, intervals[j][1]);
				j++;
			}
			// Add merged interval to result
			ans.add(Arrays.asList(start, end));
			// Move to next non-overlapping interval
			i = j;
		}
		return ans;
	}

}
