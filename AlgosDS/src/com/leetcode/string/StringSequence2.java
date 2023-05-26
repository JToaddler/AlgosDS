package com.leetcode.string;

/**
 * 
 * for positive integer N = 5 then output 5555544443332210122333444455555
 * 
 * 
 * @author Anto
 *
 */
public class StringSequence2 {

	public static void main(String[] args) {

		int num = 5;
		StringBuilder sb = new StringBuilder();
		for (int i = 5; i >= 0; i--) {
			sb.append(
					new String(Math.abs(i) == 0 ? new char[1] : new char[Math.abs(i)]).replace("\0", Math.abs(i) + ""));
		}
		System.out.println(sb.toString());
	}

}
