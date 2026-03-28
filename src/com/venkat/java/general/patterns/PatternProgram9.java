package com.venkat.java.general.patterns;

/*
    *    
   ***   
  *****  
 ******* 
*********
*********
 ******* 
  *****  
   ***   
    *    
*/

/*1.For the outer loop, count the no of lines.
2.For the inner loop, focus on the columns & connect them somehow to the rows.
3.Print them "*" inside the inner for loop.
4.Observe Symmetry ( Optional ). */
public class PatternProgram9 {

	public static void main(String[] args) {
		pattern1(5);
		pattern2(5);
	}

	private static void pattern1(int n) {
		for (int i = 0; i < n; i++) {
			// spaces
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			// Stars
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("*");
			}
			// spaces
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private static void pattern2(int n) {
		for (int i = 0; i < n; i++) {
			// spaces
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			// Stars
			for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
				System.out.print("*");
			}
			// spaces
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
