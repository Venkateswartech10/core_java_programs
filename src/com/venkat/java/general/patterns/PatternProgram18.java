package com.venkat.java.general.patterns;

/*
E
DE
CDE
BCDE
ABCDE    
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram18 {

	public static void main(String[] args) {
		pattern(5);
	}

	private static void pattern(int n) {
		for (int i = 0; i < n; i++) {
			for (char ch = (char) ('E' - i); ch <= 'E'; ch++) {
				System.out.print(ch);
			}

			System.out.println();
		}
	}
}
