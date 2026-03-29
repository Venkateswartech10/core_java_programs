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
public class PatternProgram16 {

	public static void main(String[] args) {
		pattern(5);
	}

	private static void pattern(int n) {
		char insPosition = 'A';
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(insPosition + " ");
			}
			insPosition = (char) (insPosition + 1);
			System.out.println();
		}
	}
}
