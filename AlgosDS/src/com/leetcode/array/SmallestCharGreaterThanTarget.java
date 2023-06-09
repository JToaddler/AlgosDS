package com.leetcode.array;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class SmallestCharGreaterThanTarget {

	public char nextGreatestLetter(char[] letters, char val) {

		int index = binarySearch(letters, val);
		System.out.println("Search :" + index);
		int resultIndex = (index == -1 || index == letters.length) ? 0 : index;
		return letters[resultIndex];
	}

	public int binarySearch(char[] letters, char val) {
		int l = 0, r = letters.length - 1;
		int target = (int) val;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			// if (target == (int) letters[mid])
			// return mid;
			if (target < (int) letters[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}
		return l;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		char[] letters = new char[10];
		IntStream.range(0, 10).forEach(c -> {
			letters[c] = (char) rand.nextInt(97, 123);
		});
		Arrays.sort(letters);
		System.out.println(Arrays.toString((letters)));
		SmallestCharGreaterThanTarget main = new SmallestCharGreaterThanTarget();
		System.out.println(main.nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'c'));
	}
}
