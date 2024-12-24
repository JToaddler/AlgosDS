package leetcode.heap;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array
 */
public class KthLargestElementinArray {

	/**
	 * Time complexity: O(n⋅logk)
	 * 
	 * Operations on a heap cost logarithmic time relative to its size. Because our
	 * heap is limited to a size of k, operations cost at most O(logk). We iterate
	 * over nums, performing one or two heap operations at each iteration.
	 * 
	 * We iterate n times, performing up to logk work at each iteration, giving us a
	 * time complexity of O(n⋅logk).
	 * 
	 * Because k≤n, this is an improvement on the previous approach.
	 * 
	 * 
	 * Space complexity: O(k)
	 * 
	 * The heap uses O(k) space.
	 */
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
		for (int x : nums) {
			minHeap.add(x);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}

}
