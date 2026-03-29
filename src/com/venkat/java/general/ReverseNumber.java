package com.venkat.java.general;

public class ReverseNumber {

	public static void main(String[] args) {
		int num = -123;
		int reversedNum = reverseNumber(num);
		System.out.println("Reversed number of num : " + num + " is : " + reversedNum);
	}

	private static int reverseNumber(int num) {
		// number can be +ve or -ve integer . Convert -ve to +ve integer by Math.abs()
		// function.
		int positiveNum = Math.abs(num);
		// Convert number to String
        String numberStr = String.valueOf(positiveNum);
		StringBuffer sb = new StringBuffer(numberStr).reverse();
		// convert back from String buffer to integer
		int reversedNumber = 0;
		try {
			reversedNumber = Integer.parseInt(sb.toString());
		}catch(NumberFormatException npe) {
			System.out.println(npe);
		}
		return num < 0 ? -reversedNumber : reversedNumber;
	}

}
