package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class Temprature {
	static double closestToZero(double[] ts) {

		double min = Double.MAX_VALUE;
		Map<Double, Double> map = new HashMap<Double, Double>();
		if (ts.length == 0) {
			return 0;
		}
		double[] result = new double[ts.length];
		for (int i = 0; i < ts.length; i++) {
			result[i] = Math.abs(ts[i]);

			map.putIfAbsent(result[i], ts[i]);
			if (map.get(result[i]) < ts[i]) {
				map.put(result[i], ts[i]);
			}
			min = Math.min(result[i], min);
		}
		System.out.println("Result: " + map.get(min));
		return map.get(min);
	}

	public static void main(String[] args) {

		double[] ts = { 7, -10, 13, 8, 4, -7.2, -12, -3.7, 3.5, -9.6, 6.5, 1.7, -1.7, -6.2, 7 };
		System.out.println(closestToZero(ts));

	}
}
