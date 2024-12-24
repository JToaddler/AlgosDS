package com.algos.sort;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * https://www.programiz.com/dsa/heap-sort
 * 
 * Things to remember
 * 
 * Step 1 : start heapify the array. start from last non leaf node. last non
 * leaf node = (n/2) -1 [n is the number of element in array]
 * 
 * Step 2: delete the root (largest in the max heap) and add it to the last.
 * 
 * Step 3: For every deletion, start heapify the array
 * 
 * Step 2 & 3 is the sorting takes place. Step 1 is precursor to head sort(heapify the array)
 * 
 * @author Anto
 *
 */
public class HeapSort {

	public static void main(String[] args) {

		int[] arr = IntStream.range(1, 7).map(a -> (int) Math.round(Math.random() * 100)).toArray();
		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {

		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, n, i);
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			maxHeapify(arr, i, 0);
		}

	}

	public static void maxHeapify(int[] arr, int heapSize, int index) {

		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int parent = index;

		if (left < heapSize && arr[left] > arr[parent]) {
			parent = left;
		}
		if (right < heapSize && arr[right] > arr[parent]) {
			parent = right;
		}
		if (parent != index) {
			int temp = arr[index];
			arr[index] = arr[parent];
			arr[parent] = temp;
			maxHeapify(arr, heapSize, parent);
		}
	}
}
