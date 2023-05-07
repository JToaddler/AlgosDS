package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/solutions/2750704/java-easy-solution-hashmap-arraylist/
 * 
 * Given an array of strings strs, group the anagrams together. You can return
 * the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 * 
 * Input: strs = ["eat","tea","tan","ate","nat","bat"] Output:
 * [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * Example 2:
 * 
 * Input: strs = [""] Output: [[""]] Example 3:
 * 
 * Input: strs = ["a"] Output: [["a"]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 104 0 <= strs[i].length <= 100 strs[i] consists of
 * lowercase English letters.
 * 
 *
 */
public class GroupAnagram {

	public List<List<String>> groupAnagrams(String[] words) {

		List<List<String>> result = new ArrayList<List<String>>();

		Map<String, List<String>> keyResult = new HashMap<String, List<String>>();

		for (String word : words) {
			String signature = getSignature(word);
			keyResult.putIfAbsent(signature, new ArrayList<String>());
			keyResult.get(signature).add(word);
		}
		result.addAll(keyResult.values());
		return result;
	}

	public String getSignature(String word) {
		int[] letter = new int[26];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			letter[word.charAt(i) - 'a'] = letter[word.charAt(i) - 'a'] + 1;
		}
		for (int i = 0; i < letter.length; i++) {
			if (letter[i] != 0) {
				sb.append((char) i + 'a').append(letter[i]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] groups = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagram ga = new GroupAnagram();
		System.out.println(ga.groupAnagrams(groups));
	}

}
