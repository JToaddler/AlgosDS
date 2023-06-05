package com.leetcode.matrix;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class WeakestRowInMatrix {

	public static int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<Integer[]> result = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if (o2[1] != o1[1])
					return o2[1].compareTo(o1[1]);
				else
					return o2[0].compareTo(o1[0]);
			}
		});
		for (int i = 0; i < mat.length; i++) {
			int count = findSum(mat[i]);
			result.add(new Integer[] { i, count });
			if (result.size() > k)
				result.remove();
		}
		int[] resArray = new int[k];
		for (int i = k - 1; i >= 0; i--)
			resArray[i] = result.poll()[0];
		return resArray;
	}

	public static int findSum(int[] array) {
		int sum = 0;
		for (int element : array)
			sum = sum + element;
		return sum;
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
		System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
	}

}