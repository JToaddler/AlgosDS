package leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/simplify-path/description/ </br>
 * TC : O(N) </br>
 * SC : O(N). But actually its 2N
 * 
 */
public class SimplifyPath {

	public static void main(String[] args) {
		System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
	}

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] array = path.split("/");
		for (String directory : array) {
			if ("".equals(directory) || directory.isEmpty()) {
				continue;
			} else if ("..".equals(directory)) {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(directory);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String str : stack) {
			sb.append("/").append(str);
		}
		return sb.length() > 0 ? sb.toString() : "/";
	}
}
