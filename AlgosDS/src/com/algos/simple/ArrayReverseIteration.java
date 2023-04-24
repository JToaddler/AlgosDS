package com.algos.simple;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayReverseIteration {

	public static void main(String[] args) {

		int max = 5;
		Long[] array = new Long[max];
		IntStream.range(0, max).forEach(index -> {
			array[index] = Math.round(Math.random() * 100);
		});
		System.out.println(Arrays.asList(array));

		for (int i = array.length - 1; i >= 0; i--) {
			System.out.println(array[i]);
		}

	}

}
