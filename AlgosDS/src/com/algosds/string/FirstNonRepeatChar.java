package com.algosds.string;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Time complexity - O(2n). Space complexity - O(n)
 * 
 * @author
 *
 */
public class FirstNonRepeatChar {

	public static void main(String[] args) {

		String word = "Collectors";
		Map<String, Long> countMap = Arrays.stream(word.split("")).map(String::toUpperCase)
				.collect(Collectors.groupingBy(str -> {
					return str;
				}, Collectors.counting()));
		System.out.println(countMap);

		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			long count = countMap.get(Character.toString(letter).toUpperCase());
			if (count == 1) {
				System.out.println("First Non repeating character: " + letter);
				break;
			}
		}
	}
}