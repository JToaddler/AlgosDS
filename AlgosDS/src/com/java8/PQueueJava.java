package com.java8;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PQueueJava {

	class Student {
		int id;
		String name;
	}

	public static void main(String[] args) {

		Queue<Integer> plist = new PriorityQueue<Integer>(Collections.reverseOrder());
		/*
		Queue<Integer> plist = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		*/
		plist.add(5);
		plist.add(34);
		plist.add(78);
		plist.add(3);
		plist.add(72);
		plist.add(39);
		plist.add(6);

		System.out.println(plist);
		System.out.println(plist.poll());
		System.out.println(plist.poll());
		System.out.println(plist.poll());
		System.out.println(plist.poll());
		System.out.println(plist.poll());
		System.out.println(plist.poll());
		System.out.println(plist.poll());
		System.out.println(plist.poll());

	}
}