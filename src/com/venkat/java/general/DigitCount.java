package com.venkat.java.general;

public class DigitCount {

	public static void main(String[] args) {
		int num = 4567;
		int digitCount = 0;
		while (num > 0) {
			num = num / 10;
			digitCount = digitCount + 1;
		}
		System.out.println(digitCount); // 4

	}

}
