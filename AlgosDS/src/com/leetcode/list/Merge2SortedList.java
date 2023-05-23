package com.leetcode.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists
 * 
 * @author Anto
 *
 */
public class Merge2SortedList {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(4);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(1);
		list2.add(3);
		list2.add(4);
		list2.add(7);
		list2.add(8);

		System.out.println(mergeList(list1, list2));

	}

	private static List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {

		List<Integer> result = new LinkedList<Integer>();
		int index1 = 0, index2 = 0;

		for (int i = 0; i < list1.size() + list2.size(); i++) {

			if (index1 < list1.size() && index2 < list2.size()) {
				if (list1.get(index1) == list2.get(index2)) {
					result.add(list2.get(index2));
					index2++;
					result.add(list1.get(index1));
					index1++;
				} else if (list1.get(index1) > list2.get(index2)) {
					result.add(list2.get(index2));
					index2++;
				} else {
					result.add(list1.get(index1));
					index1++;
				}
			} else if (index1 < list1.size() && index2 >= list2.size()) {
				result.add(list1.get(index1));
				index1++;
			} else if (index1 >= list1.size() && index2 < list2.size()) {
				result.add(list2.get(index2));
				index2++;
			}

		}
		return result;
	}
}
