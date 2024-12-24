package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms
 * 
 * 
 */
public class MeetingRoom_1 {

	/**
	 * Time complexity : O(nlogn). The time complexity is dominated by sorting. Once
	 * the array has been sorted, only O(n) time is taken to go through the array
	 * and determine if there is any overlap.
	 * 
	 * Space complexity : O(1). Since no additional space is allocated.
	 */
	public boolean canAttendMeetings(int[][] intervals) {
		if (intervals == null)
			return false;
		if (intervals.length < 2)
			return true;
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i][1] > intervals[i + 1][0]) {
				return false;
			}
		}
		return true;
	}
}
