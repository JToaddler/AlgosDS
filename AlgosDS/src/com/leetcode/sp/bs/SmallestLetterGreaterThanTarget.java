package com.leetcode.sp.bs;

public class SmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		System.out.println(nextGreatestLetter(new char[] { 'x', 'x', 'x', 'y' }, 'x'));
	}

	public static char nextGreatestLetter(char[] letters, char val) {
		int left = 0, right = letters.length - 1;
		while (left <= right) {
			int mid = right + (left - right) / 2;
			if (letters[mid] > val)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return left == letters.length ? letters[0] : letters[left];
	}
}
