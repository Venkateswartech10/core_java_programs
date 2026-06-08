package com.venkat.dsa.arrays.medium;

public class RotateMatrixBy90Degrees {

	public static void main(String[] args) {
		int[][] matrix = {
	            {1, 2, 3},
	            {4, 5, 6},
	            {7, 8, 9}
	        };
		
		// Time Complexity: O(N²),Each element of the matrix is visited exactly once and placed into a new matrix, so the time taken is proportional to the total number of elements.
		// Space Complexity: O(N²),We use an additional matrix of the same size to store the rotated result, leading to O(N²) extra space.
		// int[][] rotated = rotateClockwiseBrute(matrix);
		
		// Print the rotated matrix
		/*
		 * for (int[] row : rotated) { for (int val : row) System.out.print(val + " ");
		 * System.out.println(); }
		 */
        
		
		// Time Complexity: O(N²),We traverse every element once during transposition and again during reversal of each row, resulting in a total of O(N²) time.
		// Space Complexity: O(1),All operations are done in-place using only temporary variables. No extra matrix is used.
		rotateClockwiseOptimal(matrix);
		// Print rotated matrix
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
        
	}
	
	// Function to rotate matrix 90 degrees clockwise in-place
	private static void rotateClockwiseOptimal(int[][] matrix) {
		int n = matrix.length;
		// Step 1: Transpose the matrix
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// Swap element at (i, j) with (j, i)
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		// Step 2: Reverse each row
		for (int i = 0; i < n; i++) {
			int left = 0, right = n - 1;

			// Swap elements from both ends moving toward center
			while (left < right) {
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				left++;
				right--;
			}
		}
	}

	// Function to rotate the matrix 90 degrees clockwise using extra space
	private static int[][] rotateClockwiseBrute(int[][] matrix) {
		// Get the size of the square matrix
		int n = matrix.length;

		// Create a new matrix of same size to store rotated result
		int[][] rotated = new int[n][n];

		// Traverse each element of original matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Place the element at its new rotated position
				rotated[j][n - i - 1] = matrix[i][j];
			}
		}

		// Return the rotated matrix
		return rotated;
	}

}
