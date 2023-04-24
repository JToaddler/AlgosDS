package com.algosds.interview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DuplicateStringCount {

	public static void main(String[] args) {

		String str = "ABBCCCDDDD";

		System.out.println(Arrays.asList(str.split("")).stream()
				.collect(Collectors.groupingBy(String::toString, Collectors.counting())));

	}

}
