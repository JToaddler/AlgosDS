package com.java8;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetJava {

	public static void main(String... args) {

		TreeSet<String> tree_set1 = new TreeSet<String>(new Helper());

	}
}

class Helper implements Comparator<String> {

	public int compare(String str1, String str2) {

		String first_Str;
		String second_Str;

		first_Str = str1;
		second_Str = str2;

		return second_Str.compareTo(first_Str);
	}
}
