package com.venkat.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Variety -1 : negatives and positives are not  size
public class ReArrangeElementsBySignElementsAreNotEqual {

	public static void main(String[] args) {
		int[] arr = { 3, 1, -2, -5, 2, -4, 3, 7 };
		reArrangeElementsBySignBrute(arr);
	}

	private static void reArrangeElementsBySignBrute(int[] arr) {
		// Create 2 lists to store +ves and -ves
		List<Integer> negativeList = new ArrayList<>();
		List<Integer> postiveList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				negativeList.add(arr[i]);
			} else {
				postiveList.add(arr[i]);
			}
		}

		if (postiveList.size() > negativeList.size()) {
			for (int i = 0; i < negativeList.size(); i++) {
				arr[2 * i] = postiveList.get(i);
				arr[2 * i + 1] = negativeList.get(i);
			}
			for (int j = negativeList.size() * 2; j < postiveList.size(); j++) {
				arr[j] = postiveList.get(j);
			}
		} else {
			for (int i = 0; i < postiveList.size(); i++) {
				arr[2 * i] = postiveList.get(i);
				arr[2 * i + 1] = negativeList.get(i);
			}
			for (int j = postiveList.size() * 2; j < negativeList.size(); j++) {
				arr[j] = postiveList.get(j);
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
