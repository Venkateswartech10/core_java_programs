package com.venkat.java.general.patterns;

/*
A 
B B 
C C C 
D D D D 
E E E E E    
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram17 {

	public static void main(String[] args) {
		pattern(5);
	}

	private static void pattern(int n) {
		for (int i = 1; i <= n; i++) {
			char insPosition = 'A';
			// spaces
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			// characters
			for (int j = 0; j < 2 * i - 1; j++) {
				System.out.print(insPosition);
				if (j >= (2 * i - 1) / 2) {
					insPosition = (char) (insPosition - 1);
				} else {
					insPosition = (char) (insPosition + 1);
				}
			}
			// spaces
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}

			System.out.println();
		}
	}
}
