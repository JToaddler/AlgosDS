package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {

	static Map<Character, Character> map = new HashMap<>();

	static {
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;
				if (map.get(stack.pop()) != c)
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("[()]}"));
	}
}
