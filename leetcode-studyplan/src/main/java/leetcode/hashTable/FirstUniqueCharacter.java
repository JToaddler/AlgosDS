package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

	public int firstUniqChar_array(String s) {
		int[] count = new int[26];
		int n = s.length();
		// build char count bucket : <charIndex, count>
		for (int i = 0; i < n; i++) {
			int index = s.charAt(i) - 'a';
			count[index]++;
		}

		// find the index
		for (int i = 0; i < n; i++) {
			int index = s.charAt(i) - 'a';
			if (count[index] == 1) {
				return i;
			}

		}
		return -1;
	}

	public int firstUniqChar_HashMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

}
