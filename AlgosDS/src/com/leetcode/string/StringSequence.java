package com.leetcode.string;

/**
 * 
 * Generate next sequence of alphabets
 * 
 * @author Anto
 *
 */
public class StringSequence {

	public static void main(String[] args) {
		int num = 25;

		for (int i = 0; i < 5; i++) {
			generateSequence(num + i);
		}
		System.out.println("Recursive ");
		for (int i = 0; i < 5; i++) {
			System.out.println(sequence(num + i));
		}

	}

	public static void generateSequence(int num) {
		StringBuilder sb = new StringBuilder();
		sb.append((char) ('A' + num % 26));
		while (num >= 26) {
			num = num / 26;
			sb.append((char) ('A' + ((num - 1) % 26)));
		}

		System.out.println(sb.reverse().toString());
	}

	public static String sequence(int num) {
		return num < 0 ? "" : sequence((num / 26) - 1) + (char) ('A' + num % 26);
	}

}
