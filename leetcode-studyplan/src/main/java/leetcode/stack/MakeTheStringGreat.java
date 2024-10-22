package leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/make-the-string-great/description/
 * 
 */
public class MakeTheStringGreat {
	public String makeGood(String s) {

		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {

	}
}
