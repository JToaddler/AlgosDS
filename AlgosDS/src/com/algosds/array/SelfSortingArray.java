package com.algosds.array;

import java.util.Arrays;

public class SelfSortingArray {

	private static int itemCount;

	public static void main(String[] args) {

		int[] array = new int[5];
		add(array, 4);
		add(array, 8);
		add(array, 2);
		add(array, 5);
		add(array, 1);
		add(array, 3);
		System.out.println(Arrays.toString(array));
	}

	public static void add(int[] array, int val) {
		int i = 0;
		if (itemCount >= array.length) {
			throw new IndexOutOfBoundsException(itemCount + " is out of range for array of size " + array.length);
		}
		if (itemCount == 0) {
			array[itemCount++] = val;
		} else {
			for (i = itemCount - 1; i >= 0; i--) {
				if (val > array[i]) {
					array[i + 1] = array[i];
				} else {
					break;
				}
			}
			array[i + 1] = val;
		}
		itemCount++;
	}

}
