package leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 * 
 * 
 */
public class StringBackspaceCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
	}

	public static boolean backspaceCompare(String s, String t) {
		return build(s).equals(build(t));
	}

	public static String build(String str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		for (Character c : str.toCharArray()) {
			if ('#' != c) {
				stack.push(c);
			} else if (!stack.isEmpty()) {
				stack.pop();
			}
		}
		for (Character c : stack)
			sb.append(c);
		return sb.toString();
	}

}
