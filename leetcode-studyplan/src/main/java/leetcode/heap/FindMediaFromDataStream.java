package leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 
 * https://leetcode.com/problems/find-median-from-data-stream
 * 
 * refer solution
 * https://leetcode.com/problems/find-median-from-data-stream/solutions/74047/java-python-two-heap-solution-o-log-n-add-o-1-find/
 * 
 * 
 */
public class FindMediaFromDataStream {

}

class MedianFinder_Heap_Optimized {

	private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> large = new PriorityQueue<>();

	private boolean even = true;

	public MedianFinder_Heap_Optimized() {

	}

	public double findMedian() {
		if (even)
			return (small.peek() + large.peek()) / 2.0;
		else
			return small.peek();
	}

	public void addNum(int num) {
		if (even) {
			large.offer(num);
			small.offer(large.poll());
		} else {
			small.offer(num);
			large.offer(small.poll());
		}
		even = !even;
	}
}

class MedianFinder_1 {
	List<Integer> list;

	public MedianFinder_1() {
		list = new ArrayList<>(100000);
	}

	public void addNum(int num) {
		list.add(num);
	}

	public double findMedian() {
		Collections.sort(list);
		int n = list.size();
		return n % 2 == 1 ? list.get(n / 2) : (list.get((n / 2) - 1) + list.get(n / 2)) / 2.0;
	}
}
