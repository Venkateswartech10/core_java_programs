package com.venkat.java.general.patterns;

/*
1        1
12      21
123    321
1234  4321
1234554321    
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram12 {

	public static void main(String[] args) {
		pattern(5);
	}

	private static void pattern(int n) {
		int initialSpace = 2 * n - 2;
		for (int i = 1; i <= n; i++) {
			// numbers
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			// spaces
			for (int j = 0; j < initialSpace; j++) {
				System.out.print(" ");
			}
			// numbers
			for (int j = i; j >= 1; j--) {
				System.out.print(j);
			}
			initialSpace = initialSpace - 2;
			System.out.println();
		}
	}
}
