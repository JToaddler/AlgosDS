package com.algosds.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetricsServiceMain {

	public static void main(String... args) {

		MetricsService mservice = new MetricsService(new Metrics(0));

		System.out.println(mservice.indexOf(new Metrics(1, "One")));
		System.out.println(mservice.add(new Metrics(1, "One")));
		System.out.println(mservice.add(null));
		System.out.println(mservice.add(null));
		System.out.println(mservice.indexOf(null));
		System.out.println(mservice.add(new Metrics(2)));
		System.out.println(mservice.add(new Metrics(3)));
		System.out.println(mservice.add(new Metrics(4)));
		System.out.println(mservice.add(new Metrics(5)));
		System.out.println(mservice.isEmpty());
		System.out.println(mservice);

		System.out.println(mservice.contains(new Metrics(5)));

		List<Metrics> list = new ArrayList<Metrics>();
		list.add(new Metrics(8));
		list.add(new Metrics(6));
		list.add(new Metrics(9));
		list.add(new Metrics(10));

		System.out.println("Add All :" + mservice.addAll(list));

		System.out.println(mservice);

		System.out.println("Contains all : " + mservice.containsAll(list));
		list.add(new Metrics(12));
		System.out.println("Contains all : " + mservice.containsAll(list));

		System.out.println("Before remove :" + mservice);
		System.out.println("Before remove count :" + mservice.size());

		mservice.remove(new Metrics(2));
		mservice.remove(new Metrics(9));
		mservice.remove(null);
		mservice.remove(new Metrics(10));
		System.out.println("After remove :" + mservice);

		List<Metrics> list2 = new ArrayList<Metrics>();
		list2.add(new Metrics(6));
		list2.add(new Metrics(34));
		
		System.out.println("Remove all :" + mservice.removeAll(list2));
		Metrics[] mArray = new Metrics[30];
		System.out.println(Arrays.toString(mservice.toArray(mArray)));
		System.out.println(mservice.isEmpty());
		
	}

}
