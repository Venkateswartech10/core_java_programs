package com.venkat.java.general.recursion;

public class PalindromeCheckUsingRecursion {

	public static void main(String[] args) {
		String name = "MADSM";
		// Pass initial value of the string array and string in array format
		if (checkPalindrome(0, name.toCharArray())) {
			System.out.print("Palindrome");
		} else {
			System.out.print("Not a Palindrome");
		}
	}

	private static boolean checkPalindrome(int leftPointer, char[] name) {
		// Base condition to break the loop at exactly middle
		if (leftPointer >= name.length / 2) {
			return true;
		}
		// if condition to check first and last characters are same or not same . If not same then return false
		if (name[leftPointer] != name[name.length - leftPointer - 1]) {
			return false;
		}
		// Call recursion call by moving next to compare next set of characters
		return checkPalindrome(leftPointer + 1, name);
	}
}
