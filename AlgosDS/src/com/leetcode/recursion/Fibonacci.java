package com.leetcode.recursion;

public class Fibonacci {

	public static void main(String[] args) {
		int x = 5;
		System.out.println("Sum of first " + x + " numbers : " + sumFibonacci(x));
		printFib(x);
	}

	public static int sumFibonacci(int x) {
		if (x <= 1) {
			return x;
		}
		return sumFibonacci(x - 1) + sumFibonacci(x - 2);
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
