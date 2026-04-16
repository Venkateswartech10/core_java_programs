package com.venkat.java.general.hasing;

// Hashing - Pre compute & fetch
public class HashingTest1 {

	public static void main(String[] args) {
		String name = "venkateswar";
		// if given string has only small letters then we can take 26 & save the counter using z-a value
		// printFrequencies(name);
		printFrequenciesInOptimized(name);
	}

	private static void printFrequenciesInOptimized(String name) {
		int[] hash = new int[26];
		for (int i = 0; i < name.length(); i++) {
			hash[name.charAt(i) - 'a']++;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] != 0) {
				System.out.println((char) (i + 'a') + "->" + hash[i]);
			}
		}
	}

	private static void printFrequencies(String name) {
		int[] hash = new int[256];
		for (int i = 0; i < name.length(); i++) {
			hash[name.charAt(i)]++;
		}

		for (int i = 0; i < hash.length; i++) {
			if (hash[i] != 0) {
				System.out.println((char) i + "->" + hash[i]);
			}
		}
	}

}
