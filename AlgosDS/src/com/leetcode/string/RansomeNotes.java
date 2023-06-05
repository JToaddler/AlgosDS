package com.leetcode.string;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/ransom-note
 * 
 * @author Anto
 *
 */
public class RansomeNotes {

	public static boolean canConstruct_BF(String ransomNote, String magazine) {
		if (magazine.length() < ransomNote.length())
			return false;
		for (Character c : ransomNote.toCharArray()) {
			boolean result = magazine.contains(c.toString());
			if (result)
				magazine = magazine.replaceFirst(c.toString(), "");
			if (!result)
				return false;
		}
		return true;
	}

	public static boolean canConstruct(String ransomNote, String magazine) {

		int[] count = new int[26];
		for (char ch : magazine.toCharArray()) {
			count[ch - 'a'] = count[ch - 'a'] + 1;
		}
		System.out.println(Arrays.toString(count));
		for (char c : ransomNote.toCharArray()) {
			count[c - 'a'] = count[c - 'a'] - 1;
			if (count[c - 'a'] < 0)
				return false;
		}
		System.out.println(Arrays.toString(count));
		return true;
	}

	public static void main(String[] args) {
		String ranSome = "aaa", msg = "aaa";
		System.out.println(" Result :  " + canConstruct_BF(ranSome, msg));
		System.out.println(" Result :  " + canConstruct(ranSome, msg));
	}
}
