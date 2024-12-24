package leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/last-stone-weight
 */
public class LastStoneWeight {

	/**
	 * Time complexity : O(NlogN).
	 * 
	 * Converting an array into a Heap takes O(N) time (it isn't actually sorting;
	 * it's putting them into an order that allows us to get the maximums, each in
	 * O(logN) time).
	 * 
	 * Like before, the main loop iterates up to N−1 times. This time however, it's
	 * doing up to three O(logN) operations each time; two removes, and an optional
	 * add. Like always, the three is an ignored constant. This means that we're
	 * doing N⋅O(logN)=O(NlogN) operations.
	 * 
	 * Space complexity : O(N) In Java though, it's O(N) to create the
	 * PriorityQueue.
	 * 
	 * 
	 */
	public int lastStoneWeight(int[] stones) {
		Queue<Integer> maxHeap = new PriorityQueue<>(stones.length, Collections.reverseOrder());
		for (int stone : stones) {
			maxHeap.add(stone);
		}
		while (maxHeap.size() > 1) {
			int x = maxHeap.poll();
			int y = maxHeap.poll();
			int newStone = x - y;
			if (newStone > 0)
				maxHeap.add(newStone);
		}
		return maxHeap.isEmpty() ? 0 : maxHeap.peek();
	}
}
