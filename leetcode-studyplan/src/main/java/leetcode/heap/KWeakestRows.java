package leetcode.heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
 */
public class KWeakestRows {

	public int[] kWeakestRows(int[][] mat, int k) {
		Queue<int[]> minHeap = new PriorityQueue<>(k + 1, (a, b) -> {
			if (a[1] != b[1])
				return Integer.compare(b[1], a[1]);
			else
				return Integer.compare(b[0], a[0]);
		});
		for (int i = 0; i < mat.length; i++) {
			int[] row = mat[i];
			int[] rank = { i, findSum(row) };
			minHeap.add(rank);
			if (minHeap.size() > k)
				minHeap.poll();
		}
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = minHeap.poll()[0];
		}
		return result;
	}

	public int findSum(int[] row) {
		int sum = 0;
		for (int x : row) {
			if (x == 0)
				return sum;
			sum += x;
		}
		return sum;
	}
}
