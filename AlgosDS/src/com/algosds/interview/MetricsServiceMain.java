package com.algosds.interview;

import java.util.ArrayList;
import java.util.List;

public class MetricsServiceMain {

	public static void main(String... args) {

		MetricsService mservice = new MetricsService(new Metrics(1, "One"));

		mservice.add(new Metrics(1, "One"));
		System.out.println(mservice.contains(new Metrics(1, "One")));
		mservice.add(new Metrics(2, "two"));
		mservice.size();
		mservice.contains(new Metrics(3, "three"));
		mservice.size();
		mservice.add(new Metrics(3, "three"));
		mservice.add(new Metrics(4, "three"));
		mservice.add(new Metrics(6, "three"));
		mservice.size();
		mservice.remove(new Metrics(3, "three"));
		
		mservice.size();
		System.out.println(mservice);

		List<Metrics> lMetrics = new ArrayList<Metrics>();
		lMetrics.add(new Metrics(8, "three"));
		lMetrics.add(new Metrics(9, "three"));
		lMetrics.add(new Metrics(10, "three"));

		System.out.println("Added all " + mservice.addAll(lMetrics));
		System.out.println("Added all " + mservice.addAll(lMetrics));
		System.out.println(mservice);
		System.out.println("Added all " + mservice.removeAll(lMetrics));
		

		List<Metrics> mMetrics = new ArrayList<Metrics>();
		mMetrics.add(new Metrics(1, ""));
		mMetrics.add(new Metrics(2, ""));
		mMetrics.add(new Metrics(5, ""));
		System.out.println("Before reatin " +mservice);
		System.out.println("Retains " + mservice.retainAll(mMetrics));
		System.out.println(mservice);
	}

}
