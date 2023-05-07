package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

	public String encode(List<String> words) {
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(word.length() + "/" + word);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public List<String> decode(String words) {

		List<String> list = new ArrayList<String>();
		int endIndex = 0;
		while (endIndex < words.length()) {
			int index = words.indexOf("/", endIndex);
			int wordLength = Integer.parseInt(words.substring(endIndex, index));
			endIndex = index + wordLength + 1;
			list.add(words.substring(index + 1, endIndex));

		}
		return list;
	}

	public static void main(String[] args) {
		EncodeDecode ed = new EncodeDecode();
		List<String> strings = new ArrayList<String>();
		strings.add("asdasd");
		strings.add("tyutpoir");
		strings.add("uioiudfny657");
		String encodedString = ed.encode(strings);
		System.out.println(ed.decode(encodedString));
	}
}
