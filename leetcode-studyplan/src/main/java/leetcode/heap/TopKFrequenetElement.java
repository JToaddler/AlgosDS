package leetcode.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements
 * 
 */
public class TopKFrequenetElement {

	/**
	 * Time complexity : O(Nlogk) if k<N and O(N) in the particular case of N=k.
	 * That ensures time complexity to be better than O(NlogN).
	 * 
	 * Space complexity : O(N+k) to store the hash map with not more N elements and
	 * a heap with k elements.
	 */
	public int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> {
			return Integer.compare(map.get(a), map.get(b));
		});

		for (int x : map.keySet()) {
			maxHeap.add(x);
			if (maxHeap.size() > k)
				maxHeap.poll();
		}

		int[] res = new int[k];
		for (int i = 0; i < k && maxHeap.size() > 0; i++) {
			res[i] = maxHeap.poll();
		}
		return res;
	}
}
