package com.venkat.dsa.binarysearch.oneDarrays;

import java.util.Arrays;
import java.util.List;

public class FirstAndLastOccuranceInSortedArray {

	public static void main(String[] args) {
		// set size
        int n = 7;
        // set key to search
        int key = 13;
        // define input list
        List<Integer> v = Arrays.asList(3, 4, 13, 13, 13, 20, 40);
        // Time Complexity: O(N), where N is the size of the array. This is because we are traversing the array once to find the last occurrence of the target element.
        // Space Complexity: O(1), as we are using a constant amount of space for the result variable and the loop index. We are not using any additional data structures that grow with the input size.
        int firstOccurance = findFirstOccuranceBrute(n, key, v);
        int lastOccurance = findLastOccuranceBrute(n, key, v);
        // print last occurrence index (or -1)
        System.out.println("First Occurance: "+firstOccurance);
        System.out.println("Last Occurance: "+lastOccurance);
        
        // Time Complexity: O(log N), where N is the size of the array. This is because we are using binary search, which reduces the search space by half in each iteration.
        // Space Complexity: O(1), as we are using a constant amount of space for the result variable and the loop indices. We are not using any additional data structures that grow with the input size.
        int firstOccurance1 = findFirstOccuranceOptimal(n, key, v);
        int lastOccurance1 = findLastOccuranceOptimal(n, key, v);
        // print last occurrence index (or -1)
        System.out.println("First Occurance: "+firstOccurance1);
        System.out.println("Last Occurance: "+lastOccurance1);
        
	}

	private static int findFirstOccuranceOptimal(int n, int key, List<Integer> v) {
		// initialize search bounds and result
        int low = 0;
        int high = n - 1;
        int res = -1;

        // binary search loop
        while (low <= high) {
            // compute mid safely
            int mid = low + (high - low) / 2;
            // when match found, store index and move left
            if (v.get(mid) == key) {
                res = mid;
                high = mid - 1;
            }
            // when key is smaller, move left
            else if (key < v.get(mid)) {
                high = mid - 1;
            }
            // otherwise move right
            else {
            	low = mid + 1;
            }
        }
        // return last occurrence or -1
        return res;
	}

	private static int findLastOccuranceOptimal(int n, int key, List<Integer> v) {
		// initialize search bounds and result
        int low = 0;
        int high = n - 1;
        int res = -1;

        // binary search loop
        while (low <= high) {
            // compute mid safely
            int mid = low + (high - low) / 2;
            // when match found, store index and move right
            if (v.get(mid) == key) {
                res = mid;
                low = mid + 1;
            }
            // when key is smaller, move left
            else if (key < v.get(mid)) {
                high = mid - 1;
            }
            // otherwise move right
            else {
                low = mid + 1;
            }
        }
        // return last occurrence or -1
        return res;
	}

	private static int findFirstOccuranceBrute(int n, int key, List<Integer> v) {
		// initialize result as not found
        int res = -1;
        // scan from the end toward the start
        for (int i = 0; i < v.size(); i++) {
            // update and stop when match found
            if (v.get(i) == key) {
                res = i;
                break;
            }
        }
        // return index or -1
        return res;
	}

	private static int findLastOccuranceBrute(int n, int key, List<Integer> v) {
		// initialize result as not found
        int res = -1;
        // scan from the end toward the start
        for (int i = n - 1; i >= 0; i--) {
            // update and stop when match found
            if (v.get(i) == key) {
                res = i;
                break;
            }
        }
        // return index or -1
        return res;
	}

}
