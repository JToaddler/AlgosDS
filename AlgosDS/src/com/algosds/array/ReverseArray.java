package com.algosds.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * Time Complexity : O(log n)
 * 
 * Space complexity O(i)
 * 
 * @author Anto
 *
 */
public class ReverseArray {

	public static void main(String[] args) {

		int max = 6;
		int[] array = new int[max];
		IntStream.range(0, max).forEach(i -> array[i] = (int) (Math.random() * 13 * 7));
		System.out.println(Arrays.toString(array));
		reverse(array);
	}

	public static void reverse(int[] array) {
		int n = array.length - 1;
		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
			array[i] = array[n];
			array[n] = temp;
			n--;
		}
		System.out.println(Arrays.toString(array));
	}

}
