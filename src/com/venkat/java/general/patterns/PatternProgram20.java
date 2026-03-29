package com.venkat.java.general.patterns;

/*
*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *    
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram20 {

	public static void main(String[] args) {
		pattern(5);
	}

	private static void pattern(int n) {
		int initSpace = 2 * n - 2;
		for (int i = 1; i <= 2 * n - 1; i++) {
			int initalStars = i;
			if (i > n)
				initalStars = 2 * n - i;
			// stars
			for (int j = 0; j < initalStars; j++) {
				System.out.print("*");
			}
			// spaces
			for (int j = 0; j < initSpace; j++) {
				System.out.print(" ");
			}
			// stars
			for (int j = 0; j < initalStars; j++) {
				System.out.print("*");
			}
			System.out.println();
			if (i >= n)
				initSpace = initSpace + 2;
			else
				initSpace = initSpace - 2;
		}
	}
}
