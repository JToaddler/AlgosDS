package com.leetcode.string;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/valid-anagram/
 * 
 * 
 * @author Anto
 *
 */
public class Anagram {

	public boolean isAnagram(String word1, String word2) {

		int[] letter1 = new int[26];

		for (int i = 0; i < word1.length(); i++) {
			letter1[word1.charAt(i) - 'a'] = letter1[word1.charAt(i) - 'a'] + 1;
		}
		System.out.println(Arrays.toString(letter1));
		for (int i = 0; i < word2.length(); i++) {
			letter1[word2.charAt(i) - 'a'] = letter1[word2.charAt(i) - 'a'] - 1;
		}
		System.out.println(Arrays.toString(letter1));
		for (Integer letter : letter1) {
			if (letter != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Anagram a = new Anagram();
		System.out.println(a.isAnagram("anagram", "nagarams"));
	}

}
