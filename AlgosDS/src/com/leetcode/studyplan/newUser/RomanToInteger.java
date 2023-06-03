package com.leetcode.studyplan.newUser;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer
 * 
 * @author Anto
 *
 */
public class RomanToInteger {

	static Map<String, Integer> map = new HashMap<String, Integer>(13);
	static {
		map.put("I", 1);
		// map.put("IV", 4);
		map.put("V", 5);
		// map.put("IX", 9);
		map.put("X", 10);
		// map.put("XL", 40);
		map.put("L", 50);
		// map.put("XC", 90);
		map.put("C", 100);
		// map.put("CD", 400);
		map.put("D", 500);
		// map.put("CM", 900);
		map.put("M", 1000);
	}

	public static int romanToInt(String roman) {
		int length = roman.length();
		roman = roman.replace("IV", "IIII").replace("IX", "VIIII");
		roman = roman.replace("XL", "XXXX").replace("XC", "LXXXX");
		roman = roman.replace("CD", "CCCC").replace("CM", "DCCCC");
		String temp = roman;
		int numbers = 0;
		for (String key : temp.split("")) {
			numbers = numbers + map.get(key);
			temp = temp.substring(1, temp.length());
			length = temp.length();
			if (length == 0)
				break;
		}
		System.out.println(numbers);
		return numbers;
	}

	public static void main(String[] args) {
		String str = "MCMXCIV";
		romanToInt(str);
	}
}