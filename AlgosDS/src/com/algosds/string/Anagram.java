package com.algosds.string;

public class Anagram {

	public boolean isAnagram(String word1, String word2) {

		int[] letters = new int[26];
		char[] words1 = word1.toCharArray();
		char[] words2 = word2.toCharArray();
		print(letters);
		for (int i = 0; i < words1.length; i++) {
			letters[words1[i] - 'a'] = letters[words1[i] - 'a'] + 1;
		}
		print(letters);
		for (int j = 0; j < words2.length; j++) {
			letters[words2[j] - 'a'] = letters[words2[j] - 'a'] - 1;
		}
		print(letters);
		
		for (int letter : letters) {
			if (letters[letter] != 0) {
				return false;
			}
		}
		return true;
	}

	public void print(int[] letters) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < letters.length; i++) {
			sb.append(letters[i] + ", ");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		new Anagram().isAnagram("anagram", "anagrams");
	}

}
