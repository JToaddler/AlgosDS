package com.leetcode.number;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public static List<String> fizzBuzz(int n) {

		List<String> strList = new ArrayList<String>(n);
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				strList.add("FizzBuzz");
			else if (i % 3 == 0)
				strList.add("Fizz");
			else if (i % 5 == 0)
				strList.add("Buzz");
			else
				strList.add("" + i);
		}
		return strList;
	}

	public static List<String> fizzBuzz2(int n) {

		List<String> strList = new ArrayList<String>(n);
		for (int i = 1; i <= n; i++) {
			strList.add(i % 15 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : "" + i);
		}
		return strList;
	}

	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
		System.out.println(fizzBuzz2(15));
	}

}
