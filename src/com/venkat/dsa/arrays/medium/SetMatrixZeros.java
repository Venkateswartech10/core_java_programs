package com.venkat.dsa.arrays.medium;

public class SetMatrixZeros {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}

		// Time Complexity: O(m * n * (m + n)), We iterate through every cell (m * n), and for each zero, we potentially mark its entire row (O(n)) and column (O(m)), leading to O(m * n * (m + n)) overall.
		// Space Complexity: O(1), We are not using any extra data structures, only modifying the matrix in place (apart from a few variables).
		// setMatrixZerosBrute(matrix);
		// System.out.println("#######");
		// Print result
		/*
		 * for (int[] row : matrix) { for (int val : row) { System.out.print(val + " ");
		 * } System.out.println(); }
		 */

		// System.out.println("Better Approach");

		// Time Complexity: O(m × n),We make two passes over the matrix.First pass to identify rows and columns to be zeroed (O(m × n)).Second pass to update the matrix using the markers (O(m × n)).Total time is proportional to the number of cells in the matrix, so O(m × n).
		// Space Complexity: O(m + n),We store two extra arrays one for m rows and one for n columns. No other extra space is used besides these arrays.
		// setMatrixZerosBetter(matrix);
		// Print result
		/*
		 * for (int[] row : matrix) { for (int val : row) { System.out.print(val + " ");
		 * } System.out.println(); }
		 */
		System.out.println("Optimal Approach");

		// Time Complexity: O(m × n),We iterate over the entire matrix a constant number of times (first pass for markers, second pass for zeroing, final pass for first row/col), where m = number of rows and n = number of columns.
		// Space Complexity: O(1),No extra space is used apart from a few boolean flags; all marker information is stored within the first row and column of the matrix itself.
		setMatrixZerosOptimal(matrix);
		// Print result
		for (int[] row : matrix) {
			for (int val : row) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	// Function to set entire row and column to 0 if an element in the matrix
	private static void setMatrixZerosOptimal(int[][] matrix) {
		// Get dimensions of matrix
		int m = matrix.length;
		int n = matrix[0].length;

		// Flag to track if first row should be zeroed
		boolean firstRowZero = false;
		// Flag to track if first column should be zeroed
		boolean firstColZero = false;

		// Check if first row has any zero
		for (int j = 0; j < n; j++) {
			if (matrix[0][j] == 0) {
				firstRowZero = true;
				break;
			}
		}

		// Check if first column has any zero
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
				break;
			}
		}

		// Use first row/column as markers
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// Set cells to zero based on markers
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// Zero the first row if needed
		if (firstRowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}

		// Zero the first column if needed
		if (firstColZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	// Function to set entire row and column to 0 if an element in the matrix is 0
	private static void setMatrixZerosBetter(int[][] matrix) {
		// Get number of rows
		int m = matrix.length;
		// Get number of columns
		int n = matrix[0].length;

		// Create row marker array
		boolean[] row = new boolean[m];
		// Create column marker array
		boolean[] col = new boolean[n];

		// First pass: mark rows and columns that need to be zeroed
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// If element is zero, mark its row and column
				if (matrix[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}

		// Second pass: set cells to zero based on markers
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// If the row or column is marked, set cell to zero
				if (row[i] || col[j]) {
					matrix[i][j] = 0;
				}
			}
		}

	}

	private static void setMatrixZerosBrute(int[][] matrix) {
		// Get number of rows
		int rowLength = matrix.length;
		// Get number of columns
		int colLength = matrix[0].length;

		// First pass: mark rows and columns
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				// If the cell is zero
				if (matrix[i][j] == 0) {
					// Mark entire row as -1 (except zeros)
					for (int col = 0; col < colLength; col++) {
						if (matrix[i][col] != 0)
							matrix[i][col] = -1;
					}

					// Mark entire column as -1 (except zeros)
					for (int row = 0; row < rowLength; row++) {
						if (matrix[row][j] != 0)
							matrix[row][j] = -1;
					}

				}
			}
		}

		// Second pass: replace -1 with 0
		for (int i = 0; i < rowLength; i++) {
			for (int j = 0; j < colLength; j++) {
				if (matrix[i][j] == -1)
					matrix[i][j] = 0;
			}
		}

	}

}
