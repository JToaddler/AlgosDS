package leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin
 * 
 */
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] points = { { 1, 3 }, { -2, 2 } };
		kClosest(points, 1);
	}

	/**
	 * Approach 1
	 * 
	 * 
	 * Time complexity: O(N⋅logN) for the sorting of points.
	 * 
	 * 
	 * Space complexity: O(logN)
	 */
	public int[][] kClosest_Approach_1(int[][] points, int k) {
		Arrays.sort(points, (a, b) -> Integer.compare(distanceToOrgin(a), distanceToOrgin(b)));
		return Arrays.copyOf(points, k);
	}

	/**
	 * Approach 2 - using heap
	 * 
	 * Time complexity: O(N⋅logk)
	 * 
	 * Adding to/removing from the heap (or priority queue) only takes O(logk) time
	 * when the size of the heap is capped at k elements.
	 * 
	 * Space complexity: O(k)
	 * 
	 * The heap (or priority queue) will contain at most k elements.
	 * 
	 */
	public static int[][] kClosest(int[][] points, int k) {

		Queue<int[]> maxHeap = new PriorityQueue<>(k + 1, (a, b) -> Integer.compare(b[0], a[0]));
		for (int i = 0; i < points.length; i++) {
			int[] entry = { distanceToOrgin(points[i]), i };
			maxHeap.add(entry);
			if (maxHeap.size() > k)
				maxHeap.poll();
		}
		int[][] res = new int[k][2];
		for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
			int index = maxHeap.poll()[1];
			res[i] = points[index];
			System.out.println(Arrays.toString(res[i]));
		}
		return res;
	}

	public static int distanceToOrgin(int[] point) {
		return (point[0] * point[0]) + (point[1] * point[1]);
	}
}
