package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/editorial/
 * 
 * Time Complexity : O(n).
 * 
 * We do a linear search to put all numbers on the stack, and process all
 * operators. Processing an operator requires removing 2 numbers off the stack
 * and replacing them with a single number, which is an O(1) operation.
 * Therefore, the total cost is proportional to the length of the input array.
 * Unlike before, we're no longer doing expensive deletes from the middle of an
 * Array or List.
 * 
 * Space Complexity : O(n).
 * 
 * In the worst case, the stack will have all the numbers on it at the same
 * time. This is never more than half the length of the input array.
 * 
 */
public class EvaluateReversePolishNotation {
	static Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
	static {
		map.put("+", (a, b) -> a + b);
		map.put("-", (a, b) -> a - b);
		map.put("*", (a, b) -> a * b);
		map.put("/", (a, b) -> a / b);
	}

	public static void main(String[] args) {
		evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" });
	}

	public static int evalRPN(String[] tokens) {
		Set<String> set = Set.of("+", "-", "*", "/");
		Stack<Integer> stack = new Stack<>();
		for (String t : tokens) {
			if (set.contains(t)) {
				int b = stack.pop();
				int a = stack.pop();
				// stack.push(eval(a, b, t));
				stack.push(evalLambda(a, b, t));
			} else {
				stack.push(Integer.valueOf(t));
			}
		}
		System.out.println(stack.peek());
		return stack.peek();
	}

	private static int eval(int a, int b, String expr) {
		int res = 0;
		switch (expr) {
		case "+":
			res = a + b;
			break;
		case "-":
			res = a - b;
			break;
		case "*":
			res = a * b;
			break;
		case "/":
			res = a / b;
			break;
		}
		return res;
	}

	private static int evalLambda(int a, int b, String expr) {
		return map.get(expr).apply(a, b);
	}
}
