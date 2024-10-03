package leetcode.string;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix_14 {

	public static void main(String[] args) {
		String[] strs = { "leetcode", "leets", "lee" };
		System.out.println(longestCommonPrefix_verticalScan(strs));
	}

	public static String longestCommonPrefix_horizontalScan(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String prefix = strs[0];
		for (String s : strs) {
			while (s.indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}
		}
		return prefix;
	}

	public static String longestCommonPrefix_verticalScan(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c) {
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}

}
