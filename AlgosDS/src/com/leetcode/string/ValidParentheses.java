package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
