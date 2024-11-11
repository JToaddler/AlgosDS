package leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {
		int x = 5;
		System.out.println(fib_recursion(x));
		System.out.println(fib_dp(x));
		System.out.println(fib_iterative(x));
	}

	public static int fib_recursion(int n) {
		if (n <= 1)
			return n;
		return fib_recursion(n - 1) + fib_recursion(n - 2);
	}

	public static int fib_dp(int n) {
		int[] array = new int[n + 1];
		array[1] = 1;

		for (int i = 2; i <= n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		return array[n];
	}

	public static int fib_iterative(int n) {
		int prev1 = 1;
		int prev2 = 0;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = prev1 + prev2;
			prev2 = prev1;
			prev1 = result;
		}
		return result;
	}

	static Map<Integer, Integer> map = new HashMap<>();

	public int fib_recursion_memoization(int n) {
		if (map.containsKey(n))
			return map.get(n);
		if (n <= 1)
			return n;
		int result = fib_recursion_memoization(n - 1) + fib_recursion_memoization(n - 2);
		map.put(n, result);
		return result;
	}
}
