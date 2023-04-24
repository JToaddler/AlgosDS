package com.algosds.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * A sliding window algorithm will form a window, or section, around parts of
 * the data. Incrementally, this window will move over the data and perform some
 * sort of computation.
 * 
 * 
 * To solve it, we must initialize an i and j pointer mapping to our 0 index in
 * our string. We also must initialize a set data structure to keep track of
 * characters we have seen in our window and a max variable. We move the i
 * pointer forward adding each character to our set.
 * 
 * If the character is already in our set, we start moving our j pointer forward
 * and removing at each step. After removals, we will compute the length of our
 * window which is i - j + 1 and assign that value to our max variable.
 * 
 * https://www.youtube.com/watch?v=4i6-9IzQHwo
 * 
 * 
 * @author Anto
 *
 */
public class SlidingWindowMaxSubstring {

	public static int lengthOfLongestSubString(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int i = 0, j = 0, max = 0;

		Set<Character> set = new HashSet<Character>();
		while (i < str.length()) {
			char c = str.charAt(i);
			while (set.contains(c)) {
				set.remove(c);
				j++;
			}
			set.add(c);
			max = Math.max(max, i - j + 1);
			i++;
		}
		return max;
	}

}
