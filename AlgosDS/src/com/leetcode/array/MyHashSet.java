package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

class MyHashSet {

	Integer[] set = null;
	int size = 0;

	public MyHashSet() {
		set = new Integer[1000000];
	}

	public void add(int key) {
		if (indexOf(key) < 0) {
			set[size] = key;
			size++;
		}
	}

	private int indexOf(int data) {

		Comparator<Integer> func = (a, b) -> {
			if (a == null)
				return 1;
			if (b == null)
				return -1;
			return a.compareTo(b);
		};
		Arrays.sort(set, func);
		return Arrays.binarySearch(set, data, func);
	}

	public void remove(int key) {
		int index = indexOf(key);
		if (index < 0)
			return;
		if (index >= 0) {
			set[index] = set[size - 1];
			set[size - 1] = null;
			set = Arrays.copyOf(set, set.length + 1);
			size--;
		}
	}

	@Override
	public String toString() {
		return "MyHashSet [set=" + Arrays.toString(set) + "]";
	}

	public boolean contains(int key) {
		return indexOf(key) >= 0 ? true : false;
	}

	public static void main(String[] args) {
		MyHashSet set = new MyHashSet();
		set.add(1);
		set.add(2);
		set.add(3);
		System.out.println(set);
		System.out.println(set.contains(2));
		set.remove(2);
		System.out.println(set);
		set.add(3);
		System.out.println(set);
	}
}
