package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author Anto
 *
 */
public class LongestSubstringWithoutRepeatingChar {

	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		Set<Character> set = new HashSet<Character>();
		while (j < s.length()) {
			if (set.contains(s.charAt(j))) {
				set.remove(s.charAt(i));
				i++;
			} else {
				set.add(s.charAt(j));
				j++;
				max = Math.max(max, set.size());
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("dvdf"));
	}

}
