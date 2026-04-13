package com.venkat.java.general.recursion;

import java.util.Arrays;
// Array reverse using recursion
public class ArrayReverseDemo {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3, 4 };
		// Pass left and right index of an array & array to reverse
		// arrayReverseWithoutSingleVariable(0, num.length - 1, num);
		// System.out.println(Arrays.toString(num));
		// Only pass initial index & array to the method
		arrayReverseWithSingleVariable(0, num);
		System.out.println(Arrays.toString(num));
	}

	private static void arrayReverseWithSingleVariable(int leftPointer, int[] num) {
		// Break the loop when left pointer reaches exactly middle
		if (leftPointer >= num.length / 2) {
			return;
		}
		// Swap the values by passing left pointer and (size - leftPointer - 1 ) <- by using left and size we are calculating the right pointer value.
		swap(leftPointer, num.length - leftPointer - 1, num);
		// move left pointer value towards right
		arrayReverseWithSingleVariable(leftPointer + 1, num);

	}

	private static void arrayReverseWithoutSingleVariable(int leftPointer, int rightPointer, int[] num) {
		// Stop the loop / Base condition when left pointer reaches right pointer
		if (leftPointer >= rightPointer) {
			return;
		}
		// Swap the array elements by passing left & right Pointers
		swap(leftPointer, rightPointer, num);
		// move the leftPointer value towards right & move rightPointer value towards left.
		arrayReverseWithoutSingleVariable(leftPointer + 1, rightPointer - 1, num);
	}

	private static void swap(int leftPointer, int rightPointer, int[] num) {
		// We have leftPointer index & right pointer index & an array
		// Keep left pointer value in temp variable.
		int temp = num[leftPointer];
		// move the rightPointer value to left pointer position
		num[leftPointer] = num[rightPointer];
		// move the leftPointer value which is in temp variable to right pointer position
		num[rightPointer] = temp;
	}

}
