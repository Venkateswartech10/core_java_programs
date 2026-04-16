package com.venkat.java.general.hasing;

import java.util.HashMap;
import java.util.Map;

// Hashing - Pre compute & fetch
public class NumberFrequencyDemo {

	public static void main(String[] args) {
		int[] num = { 1, 3, 2, 1, 3 };
		//findOccurances(num);
		findOccurancesUsingHashMap(num);
	}

	private static void findOccurancesUsingHashMap(int[] num) {
		// Declare hashmap to keep the number as key & occurances as value
		HashMap<Integer, Integer> map = new HashMap<>();
		/*
		 * for (int i = 0; i < num.length; i++) { if (map.containsKey(num[i])) {
		 * map.put(num[i], map.get(num[i]) + 1); } else { map.put(num[i], 1); } }
		 */
		for (int n : num) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
		for (Map.Entry entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	private static void findOccurances(int[] num) {
		// Assuming that input array has between 0 to 13
		// Precompute.
		// Declare Array size with 13 & map the number with Array index & increment the
		// index.
		int[] hash = new int[13]; // We have limitation in declaring array size . If we have large numbers we need
									// to use Hashmap
		for (int i = 0; i < num.length; i++) {
			hash[num[i]]++;
		}

		// fetch only non zero indexes & print the value and it's corresponding
		// occurences
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] != 0)
				System.out.println(i + " " + hash[i]);
		}
	}

}
