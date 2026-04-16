package com.venkat.java.general.hasing;

// Hashing - Pre compute & fetch
public class CharacterFrequencyDemo {

	public static void main(String[] args) {
		String name = "venkateswar";
		// if given string has only small letters then we can take 26 & save the counter using z-a value
		// printFrequencies(name);
		printFrequenciesInOptimized(name);
	}

	private static void printFrequenciesInOptimized(String name) {
		int[] hash = new int[26]; // Assuming we have all small letters in the given name
		// Loop all characters in a name & calculate index - z-a & increment the counter of index
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
		// Take array size 256 as we have all characters in ASCII - 256
		int[] hash = new int[256];
		// Loop the characters in a name & put the increment the index of the ascii value
		for (int i = 0; i < name.length(); i++) {
			hash[name.charAt(i)]++;
		}
		// Print only non zero inde values
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] != 0) {
				System.out.println((char) i + "->" + hash[i]);
			}
		}
	}

}
