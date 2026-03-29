package com.venkat.java.general.patterns;

/*
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15    
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram13 {

	public static void main(String[] args) {
		pattern(5);
	}

	private static void pattern(int n) {
		int insPosition = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(insPosition + " ");
				insPosition = insPosition + 1;
			}
			System.out.println();
		}
	}
}
