package com.dp;

import java.time.LocalDateTime;

public class Fibnonacci {

	int[] memo = new int[45 + 1];

	public static void main(String[] args) {
		Fibnonacci fib = new Fibnonacci();
		System.out.println(LocalDateTime.now());
		System.out.println(fib.fibonacci(45));
		System.out.println(LocalDateTime.now());
		System.out.println(fib.fibonacciDP(45));
		System.out.println(LocalDateTime.now());
		System.out.println(fib.fibonacciMemo(45));
		System.out.println(LocalDateTime.now());
	}

	public int fibonacci(int x) {
		if (x <= 1)
			return x;
		return fibonacci(x - 1) + fibonacci(x - 2);
	}

	public int fibonacciDP(int x) {
		int a = 1, b = 1, c = 0;
		if (x == 1 || x == 2)
			return 1;
		for (int i = 3; i <= x; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public int fibonacciMemo(int x) {
		if (memo[x] != 0)
			return memo[x];
		if (x == 1 || x == 2)
			memo[x] = 1;
		else
			memo[x] = fibonacciMemo(x - 1) + fibonacci(x - 2);
		return memo[x];

	}

}
