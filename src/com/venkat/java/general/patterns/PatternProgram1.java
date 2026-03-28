package com.venkat.java.general.patterns;

/*
* * * * * 
* * * * * 
* * * * * 
* * * * * 
* * * * *   
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram1 {

	public static void main(String[] args) {
		pattern1(5);
	}

	private static void pattern1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
