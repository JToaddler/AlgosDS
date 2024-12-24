package leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream
 * 
 * Let M be the size of the initial stream nums given in the constructor, and
 * let N be the number of calls to add.
 * 
 * Time Complexity: O((M+N)⋅logk)
 * 
 * The add function involves adding and removing an element from a heap of size
 * k, which is an O(logk) operation. Since the add function is called N times,
 * the total time complexity for all add calls is O(N⋅logk).
 * 
 * The constructor also calls add M times to initialize the heap, leading to a
 * time complexity of O(M⋅logk).
 * 
 * Therefore, the overall time complexity is O((M+N)⋅logk).
 * 
 * 
 * 
 * Space Complexity: O(k)
 * 
 * The minHeap maintains at most k elements, so the space complexity is O(k).
 * 
 * 
 */
public class KthLargestInStream {
	int k;
	Queue<Integer> minHeap = new PriorityQueue<>();

	public KthLargestInStream(int k, int[] nums) {
		this.k = k;
		for (int x : nums) {
			add(x);
		}
	}

	public int add(int val) {
		minHeap.add(val);
		if (minHeap.size() > k)
			minHeap.poll();
		return minHeap.peek();
	}
}
