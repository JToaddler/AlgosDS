package leetcode.string;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix_14 {

	public static void main(String[] args) {
		
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

}
