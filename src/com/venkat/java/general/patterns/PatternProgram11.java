package com.venkat.java.general.patterns;

/*
1 
0 1 
1 0 1 
0 1 0 1 
1 0 1 0 1   
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram11 {

	public static void main(String[] args) {
		pattern(5);
	}

	private static void pattern(int n) {
		for (int i = 1; i <= n; i++) {
			int start = 1;
			if (i % 2 == 0)
				start = start - 1;
			for (int j = 0; j < i; j++) {
				System.out.print(start+" ");
				start = 1 - start;
			}
			System.out.println();
		}
	}
}
