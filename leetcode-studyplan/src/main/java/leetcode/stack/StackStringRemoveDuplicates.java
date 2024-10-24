package leetcode.stack;

public class StackStringRemoveDuplicates {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("abbccda"));
	}

	public static String removeDuplicates(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
