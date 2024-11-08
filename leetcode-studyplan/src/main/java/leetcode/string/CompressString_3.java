package leetcode.string;

/**
 * https://leetcode.com/problems/string-compression-iii/description/
 * 
 * Time complexity: O(n)
 * 
 * Space complexity: O(n)
 * 
 */
public class CompressString_3 {
	public String compressedString(String word) {
		StringBuilder sb = new StringBuilder("");
		int pos = 0;
		int len = word.length();
		while (pos < len) {
			int count = 0;
			char curC = word.charAt(pos);
			while (pos < len && count < 9 && word.charAt(pos) == curC) {
				pos++;
				count++;
			}
			sb.append(count).append(curC);
		}
		return sb.toString();
	}
}
