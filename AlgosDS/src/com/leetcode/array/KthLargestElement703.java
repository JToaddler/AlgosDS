package com.leetcode.array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream
 * 
 * @author Anto
 *
 */
public class KthLargestElement703 {

	private int k;
	private Queue<Integer> minHeap = null;

	public KthLargestElement703(int k, int[] nums) {
		minHeap = new PriorityQueue<Integer>(k);
		this.k = k;
		for (int num : nums) {
			this.add(num);
		}
	}

	public int add(int val) {
		minHeap.add(val);
		if (minHeap.size() > k) {
			minHeap.poll();
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {

		KthLargestElement703 kelement = new KthLargestElement703(7, new int[] { -10, 1, 3, 1, 4, 10, 3, 9, 4, 5, 1 });
		System.out.println(kelement.add(3));
		System.out.println(kelement.add(2));
		System.out.println(kelement.add(3));
		System.out.println(kelement.add(1));
		System.out.println(kelement.add(2));
		System.out.println(kelement.add(4));
		System.out.println(kelement.add(5));
		System.out.println(kelement.add(5));

	}

}
