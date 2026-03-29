package com.venkat.java.general.patterns;

/*
A B C D E 
A B C D 
A B C 
A B 
A   
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram15 {

	public static void main(String[] args) {
		pattern(5);
	}

	private static void pattern(int n) {
		for (int i = 0; i < n; i++) {
			char insPosition = 'A';
			for (int j = 0; j < n - i; j++) {
				System.out.print(insPosition + " ");
				insPosition = (char) (insPosition + 1);
			}
			System.out.println();
		}
	}
}
