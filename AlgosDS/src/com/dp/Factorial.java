package com.dp;

public class Factorial {

	public static void main(String[] args) {
		Factorial fact = new Factorial();
		System.out.println(fact.factorial(10));
		System.out.println(fact.factorial_DP(10));
	}

	public double factorial(int x) {
		if (x == 1)
			return 1;
		return x * factorial(x - 1);
	}

	public double factorial_DP(int x) {
		int fact = 1;
		for (int i = 2; i <= x; i++) {
			fact = fact * i;
		}
		return fact;
	}

}
