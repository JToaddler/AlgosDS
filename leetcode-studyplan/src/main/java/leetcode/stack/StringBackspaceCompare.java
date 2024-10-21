package leetcode.stack;

public class StringBackspaceCompare {

	public static void main(String[] args) {
		System.out.println(backSpaceCompare("ab#c", "ad#c"));
	}

	public static boolean backSpaceCompare(String a, String b) {
		return build(a).equals(build(b));
	}

	public static String build(String str) {

		StringBuilder sb = new StringBuilder();

		for (char c : str.toCharArray()) {
			if ('#' == c) {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
