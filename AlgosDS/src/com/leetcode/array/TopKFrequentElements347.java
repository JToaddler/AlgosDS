package com.leetcode.array;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/editorial/
 * 
 * @author Anto
 *
 */
public class TopKFrequentElements347 {
	public static void main(String[] args) {
		topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 ,5,5,5}, 3);
	}

	public static int[] topKFrequent(int[] nums, int k) { 

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer int1, Integer int2) {
				return map.get(int1) - map.get(int2);
			}
		});

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (Integer in : map.keySet()) {
			queue.add(in);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		System.out.println("queue :" + queue);
		return queue.stream().mapToInt(Integer::intValue).toArray();
	}

}
