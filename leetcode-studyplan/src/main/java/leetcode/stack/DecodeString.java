package leetcode.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/description/
 * 
 * 
 */
public class DecodeString {
	public static void main(String[] args) {
		String str = "3[a2[c]]";
		System.out.println(decodeString(str));
	}

	public static String decodeString(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (c.equals(']')) {
				List<Character> strList = new LinkedList<>();
				while (!stack.isEmpty() && '[' != stack.peek()) {
					strList.addFirst(stack.pop());
				}
				String numStr = "";
				stack.pop(); // remove '['
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					numStr = stack.pop() + numStr;
				}
				Integer x = Integer.valueOf(numStr);
				for (int i = 0; i < x; i++) {
					for (Character cStr : strList) {
						stack.push(cStr);
					}
				}
			} else {
				stack.push(c);
			}
		}
		System.out.println(stack);
		char[] cArray = new char[stack.size()];
		for (int i = cArray.length - 1; i >= 0; i--) {
			cArray[i] = stack.pop();
		}
		return new String(cArray);
	}

}
