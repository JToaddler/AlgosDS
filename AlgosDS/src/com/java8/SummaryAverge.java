package com.java8;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;

public class SummaryAverge {

	public static void main(String[] args) {

		int min = IntStream.rangeClosed(1, 3).map(index -> {
			return new Random().nextInt() * 10;
		}).min().getAsInt();

		int max = IntStream.rangeClosed(1, 3).map(index -> {
			return new Random().nextInt() * 10;
		}).max().getAsInt();

		double avg = IntStream.rangeClosed(1, 3).map(index -> {
			return new Random().nextInt() * 10;
		}).average().getAsDouble();

		int sum = IntStream.rangeClosed(1, 3).map(index -> {
			return new Random().nextInt() * 10;
		}).sum();

		IntSummaryStatistics stats = IntStream.rangeClosed(1, 3).map(index -> {
			return new Random().nextInt() * 10;
		}).summaryStatistics();
	}

}
