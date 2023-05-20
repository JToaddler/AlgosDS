package com.algosds.interview;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateStringCount {

	public static void main(String[] args) {

		String str = "ABBCCCDDDD";
		System.out.println(
				Arrays.stream(str.split("")).collect(Collectors.groupingBy(String::toString, Collectors.counting())));
		Map<String, Long> treeMap = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
		
		
	}

}
