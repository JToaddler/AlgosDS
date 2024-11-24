package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("paper", "title"));
	}

	public static boolean isIsomorphic(String s, String t) {
		return transform(s).equals(transform(t));
	}

	public static String transform(String str) {

		Map<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, i);
			}
			sb.append(map.get(c)).append(" ");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
