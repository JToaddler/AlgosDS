package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses
 * 
 * Answer :
 * 
 * https://leetcode.com/problems/valid-parentheses/solutions/3399077/easy-solutions-in-java-python-and-c-look-at-once-with-exaplanation/
 * 
 * The time complexity of the solution is O(n)
 * 
 * The space complexity of the solution is O(n)
 * 
 * @author Anto
 *
 */
public class ValidParentheses {

	static Map<Character, Character> keys = new HashMap<Character, Character>();

	static {
		keys.put(']', '[');
		keys.put(')', '(');
		keys.put('}', '{');
	}

	public static boolean validateParentheses(String text) {

		Stack<Character> stacks = new Stack<Character>();

		for (Character c : text.toCharArray()) {
			switch (c) {
			case '[':
			case '{':
			case '(':
				stacks.push(c);
				break;
			case ']':
			case ')':
			case '}':
				if (stacks.isEmpty() || stacks.pop() != keys.get(c)) {
					return false;
				}
			}
		}
		return stacks.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(validateParentheses("{[]})"));
	}

}
