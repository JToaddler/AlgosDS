package com.algos.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {

	public static void mergeSort(int[] array, int l, int m, int r) {

		// System.out.println(" > " + l + " " + m + " " + r + ": ");

		int n1 = m - l + 1;
		int n2 = r - m;

		Integer L[] = new Integer[n1];
		Integer R[] = new Integer[n2];

		for (int i = 0; i < n1; i++)
			L[i] = array[l + i];

		for (int j = 0; j < n2; j++)
			R[j] = array[m + 1 + j];

		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			array[k] = L[i];
			k++;
			i++;
		}
		while (j < n2) {
			array[k] = R[j];
			k++;
			j++;
		}

		// System.out.println(Arrays.asList(L) + " -- " + Arrays.asList(R) + " -- " +
		// Arrays.asList(array));

	}

	public static void sort(int[] array, int l, int r) {

		// System.out.println(Arrays.asList(Arrays.copyOfRange(array, l, r)));
		if (l < r) {
			int m = (r + l) / 2;
			sort(array, l, m);
			sort(array, m + 1, r);
			// System.out.print(l + " " + m + " " + r + ": ");
			// System.out.println(Arrays.asList(Arrays.copyOfRange(array, l, m + 1)) + " "
			// + Arrays.asList(Arrays.copyOfRange(array, m + 1, r + 1)));
			mergeSort(array, l, m, r);

		}

	}

	public static void main(String[] args) {

		int siz = 3;
		int[] array = new int[siz];
		IntStream.range(0, siz).forEach(id -> {
			array[id] = (int) ((Math.random() * Math.random()) * 100);
		});
		System.out.println("UnSorted array :" + Arrays.toString(array));
		sort(array, 0, siz - 1);
		
		//int[] result = mergeSort_Leetcode(array);
		//System.out.println("Sorted array :" + Arrays.toString(result));

	}

	public static int[] mergeSort_Leetcode(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int pivot = array.length / 2;
		int[] left = mergeSort_Leetcode(Arrays.copyOfRange(array, 0, pivot));
		int[] right = mergeSort_Leetcode(Arrays.copyOfRange(array, pivot, array.length));
		return merge(left, right);
	}

	public static int[] merge(int[] left, int[] right) {

		int[] res = new int[left.length + right.length];
		int resIndex = 0, lIndex = 0, rIndex = 0;

		while (lIndex < left.length && rIndex < right.length) {
			if (left[lIndex] < right[rIndex]) {
				res[resIndex++] = left[lIndex++];
			} else {
				res[resIndex++] = right[rIndex++];
			}
		}
		while (rIndex < right.length) {
			res[resIndex++] = right[rIndex++];
		}
		while (lIndex < left.length) {
			res[resIndex++] = left[lIndex++];
		}
		return res;
	}

}
