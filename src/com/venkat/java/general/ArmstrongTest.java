package com.venkat.java.general;

public class ArmstrongTest {
	public static void main(String[] args) {
		int num = 371; // 3*3*3 + 7*7*7 + 1*1*1 = 371
		boolean isArmstrong = testArmstrong(num);
		if (isArmstrong)
			System.out.println("The given number is Armstrong number");
		else
			System.out.println("The given number is not Armstrong number");
	}

	private static boolean testArmstrong(int num) {
		// Keep num in temp variable as we are playing with input number
		int tempNumber = num; // tempNumber = 371
		// initialize sum with default value
		int sum = 0;
		while (num > 0) {
			int lastDigit = num % 10;
			sum = sum + (lastDigit * lastDigit * lastDigit);
			num = num / 10;
		}
		return tempNumber == sum ? true : false;
	}
}
