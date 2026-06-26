package com.venkat.dsa.arrays.hard;

import java.util.ArrayList;
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
		List<Integer> result1 = generateNthRow(n);
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

	private static List<List<Integer>> generatePascalTriangle(int n) {
		List<List<Integer>> traingleList = new ArrayList();
		for (int row = 1; row <= n; row++) {
			List<Integer> result = generateNthRow(row);
			traingleList.add(result);
		}
		return traingleList;
	}

	// Function to compute binomial coefficient (nCr)
	private static long findPascalElement(int row, int col) {
		// Element is C(r-1, c-1)
		int n = row - 1;
		int k = col - 1;
		long result = 1;
		// Compute C(n, k) using iterative formula
		for (int i = 0; i < k; i++) {
			result = result * (n - i);
			result = result / (i + 1);
		}
		return result;
	}

	// Function to generate the Nth row of Pascal's Triangle
	private static List<Integer> generateNthRow(int row) {
		// Result list to store the row
		List<Integer> rowList = new ArrayList();
		// First value of the row is always 1
		int rowValue = 1;
		rowList.add(rowValue);
		// Compute remaining values using the relation:
		// C(n, k) = C(n, k-1) * (n-k) / k
		for (int col = 1; col < row; col++) {
			rowValue = rowValue * (row - col);
			rowValue = rowValue / col;
			rowList.add(rowValue);
		}
		return rowList;
	}

}
