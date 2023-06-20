package com.leetcode.recursion;

public class Fibonacci {

	public static void main(String[] args) {
		int x = 30;
		System.out.println("Sum of first " + x + " numbers : " + fibonacci(x));
		printFib(x);
	}

	public static int fibonacci(int x) {
		if (x <= 1) {
			return x;
		}
		return fibonacci(x - 1) + fibonacci(x - 2);
	}

	public static void printFib(int x) {

		int a = 0;
		int b = 1;
		int count = 0;
		while (count < x - 1) {
			count++;
			int temp = b + a;
			a = b;
			b = temp;
			System.out.print(temp + " ");
		}

	}

}
