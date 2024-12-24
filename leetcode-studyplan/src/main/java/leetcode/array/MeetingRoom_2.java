package leetcode.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii
 * 
 */
public class MeetingRoom_2 {

	public static void main(String[] args) {

		int[][] intervals = { { 5, 8 }, { 6, 8 } };
		minMeetingRooms(intervals);

	}

	public static int minMeetingRooms(int[][] intervals) {

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		minHeap.add(intervals[0][1]);

		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= minHeap.peek()) {
				minHeap.poll();
			}
			minHeap.add(intervals[i][1]);
		}
		System.out.println(minHeap.size());
		return minHeap.size();

	}

}
