package com.leetcode.number;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/integer-to-roman
 * 
 * @author Anto
 *
 */
public class IntegerToRoman {

	static String[] letters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
	static Integer[] range =  { 1000, 900,  500, 400,  100, 90,   50,  40,   10,   9,    5,   4,   1 };

	static Map<String, Integer> map = new HashMap<String, Integer>(13);
	static {
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);
	}

	public static void main(String[] args) {
		int num = 1994;
		String number = intToRomanBF(num);
		String numers2 = intToRoman(num);

		System.out.println("Int Number :" + num + ", Roman Number : " + number);
		System.out.println("Int Number :" + num + ", Roman Number : " + numers2);

	}

	public static String intToRoman(int num) {

		int temp = num;
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (temp > 0) {
			if (temp >= range[index]) {
				temp = temp - range[index];
				sb.append(letters[index]);
			} else
				index++;
		}
		return sb.toString();
	}

	public static String intToRomanBF(int num) {

		StringBuilder sb = new StringBuilder();
		int temp = num;
		while (temp > 0) {
			String key = getDiviser(temp);
			int divisor = map.get(key);
			int factor = temp / divisor;
			sb.append(new String(new char[factor]).replace("\0", key));
			temp = temp % divisor;
		}
		return sb.toString();
	}

	public static String getDiviser(int num) {

		if (num == 4) {
			return "IV";
		} else if (num < 5) {
			return "I";
		} else if (num == 9) {
			return "IX";
		} else if (num >= 5 && num < 10) {
			return "V";
		} else if (num >= 40 && num < 50) {
			return "XL";
		} else if (num >= 10 && num < 50) {
			return "X";
		} else if (num >= 90 && num < 100) {
			return "XC";
		} else if (num >= 50 && num < 100) {
			return "L";
		} else if (num >= 400 && num < 500) {
			return "CD";
		} else if (num >= 100 && num < 500) {
			return "C";
		} else if (num >= 900 && num < 1000) {
			return "CM";
		} else if (num >= 500 && num < 1000) {
			return "D";
		} else {
			return "M";
		}
	}
}
