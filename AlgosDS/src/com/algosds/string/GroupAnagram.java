package com.algosds.string;

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

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> groupAnagram = new HashMap<String, List<String>>();

		if (strs == null || strs.length == 0) {
			return result;
		}
		if (strs.length == 1) {
			List<String> group = new ArrayList<String>();
			result.add(group);
			return result;
		}
		for (String str : strs) {
			String code = getCode(str);
			groupAnagram.putIfAbsent(code, new ArrayList<String>());
			groupAnagram.get(code).add(str);
		}
		System.out.println(groupAnagram);
		return new ArrayList<List<String>>(groupAnagram.values());
	}

	public String getCode(String string) {

		int[] letters = new int[26];
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < string.length(); i++) {
			letters[string.charAt(i) - 'a']++;
		}
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] != 0) {
				sb.append((char) (i + 'a')).append(letters[i]);
			}
		}
		System.out.println(sb);
		return sb.toString();
	}

	public static void main(String[] args) {

		String[] groups = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };

		new GroupAnagram().groupAnagrams(groups);

	}

	public void print(int[] letters) {
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < letters.length; i++) {
			sb.append(letters[i] + ", ");
		}
		System.out.println(sb.toString());
	}

}
