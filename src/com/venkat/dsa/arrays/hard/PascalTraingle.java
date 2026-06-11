package com.venkat.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTraingle {

	public static void main(String[] args) {
		int n = 5;
		// Generate and print Pascal's Triangle
		// Time Complexity: O(N^2), we generate all the elements in first N rows sequentially one by one.
		// Space Complexity: O(N^2), additional space used for storing the entire pascal triangle.
		List<List<Integer>> result = generatePascalTriangle(n);
		for (List<Integer> row : result) {
			for (Integer val : row)
				System.out.print(val + " ");
			System.out.println();
		}
		
		System.out.println("Approach- 2 ");
		
		// Example: 5th row
		// Time Complexity: O(N), we iterate N times to compute each element of the row in O(1) time using the direct relation.
		// Space Complexity: O(N), additional space used for storing the Nth row.

		List<Long> result1 = getNthRow(n);
		// Print the row
		for (long num : result1) {
			System.out.print(num + " ");
		}
		
		System.out.println("\nApproach- 3");
		// Time Complexity: O(min(c,r−c)), The loop runs for min(c−1,r−c) iterations because binomial coefficients are symmetric.
		// Space Complexity: O(1), constant additional space is used.
		int r = 5, c = 3;
        System.out.println(findPascalElement(r, c));
	}

	// Function to compute binomial coefficient (nCr)
	private static long findPascalElement(int r, int c) {
		// Element is C(r-1, c-1)
		int n = r - 1;
		int k = c - 1;
		long result = 1;
		// Compute C(n, k) using iterative formula
		for (int i = 0; i < k; i++) {
			result *= (n - i);
			result /= (i + 1);
		}
		return result;
	}

	// Function to generate the Nth row of Pascal's Triangle
	private static List<Long> getNthRow(int n) {
		// Result list to store the row
		List<Long> row = new ArrayList<>();
		// First value of the row is always 1
		long val = 1;
		row.add(val);
		// Compute remaining values using the relation:
		// C(n, k) = C(n, k-1) * (n-k) / k
		for (int k = 1; k < n; k++) {
			val = val * (n - k) / k;
			row.add(val);
		}
		return row;
	}

	// Function to generate Pascal's Triangle up to numRows
	private static List<List<Integer>> generatePascalTriangle(int numRows) {
		// Result list to hold all rows
		List<List<Integer>> triangle = new ArrayList<>();
		// Loop for each row
		for (int i = 0; i < numRows; i++) {
			// Create a row with size (i+1)
			List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

			// Fill elements from index 1 to i-1 (middle values)
			for (int j = 1; j < i; j++) {
				// Each element = sum of two elements above it
				row.set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
			}

			// Add current row to the triangle
			triangle.add(row);
		}
		return triangle;
	}

}
