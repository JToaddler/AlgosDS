package leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/
 * 
 * TC : O(1) - 
 * SC : O(N) - N is size of the moving window
 */
public class MovingAverage {
	int size;
	int windowSum = 0, count = 0;
	Queue<Integer> queue = new LinkedList<>();
	
	public MovingAverage(int size) {
		this.size = size;
	}

	public double next(int val) {
		queue.add(val);
		count += 1;
		int tail = count > size ? queue.poll() : 0;
		windowSum = windowSum - tail + val;
		return windowSum * 1.0 / Math.min(size, count);
	}
}
