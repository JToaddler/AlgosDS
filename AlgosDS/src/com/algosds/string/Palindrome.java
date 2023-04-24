package com.algosds.string;

public class Palindrome {

	public static void main(String[] args) {

		String str = "Anna";
		StringBuilder sb = new StringBuilder("");
		for (int i = str.length() - 1; i >= 0; i--) {
			sb.append(str.charAt(i));
		}
		System.out.println(sb.toString());
		System.out.println(str.toLowerCase().equals(sb.toString().toLowerCase()) ? true : false);
	}

}
