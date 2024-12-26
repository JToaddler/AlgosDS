package leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/k-closest-points-to-origin
 *
 */
public class KClosestPointToOrigin {

	/**
	 * Time complexity: O(N⋅logN) for the sorting of points.
	 * 
	 * While sorting methods vary between different languages, most have a
	 * worst-case or average time complexity of O(N⋅logN).
	 * 
	 * Space complexity: O(logN) to O(N) for the extra space required by the sorting
	 * process.
	 */
	public int[][] kClosest_approach_1(int[][] points, int k) {
		// Sort the array with a custom lambda comparator function
		Arrays.sort(points, (a, b) -> distanceToOrigin(a) - distanceToOrigin(b));

		// Return the first k elements of the sorted array
		return Arrays.copyOf(points, k);
	}

	/**
	 * Here N refers to the length of the given array points.
	 * 
	 * Time complexity: O(N⋅logk)
	 * 
	 * Adding to/removing from the heap (or priority queue) only takes O(logk) time
	 * when the size of the heap is capped at k elements.
	 * 
	 * Space complexity: O(k)
	 * 
	 * The heap (or priority queue) will contain at most k elements.
	 */
	public int[][] kClosest(int[][] points, int k) {

		Queue<int[]> maxHeap = new PriorityQueue<>(k + 1, (a, b) -> {
			return Integer.compare(b[0], a[0]);
		});
		for (int i = 0; i < points.length; i++) {
			int[] point = points[i];
			int[] entry = { distanceToOrigin(point), i };
			maxHeap.add(entry);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		int[][] result = new int[k][2];
		for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
			int[] entry = maxHeap.poll();
			result[i] = points[entry[1]];
		}
		return result;
	}

	public int distanceToOrigin(int[] point) {
		return (point[0] * point[0]) + (point[1] * point[1]);
	}
}
