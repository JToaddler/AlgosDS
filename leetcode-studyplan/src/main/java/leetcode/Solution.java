package leetcode;

public class Solution {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			if (i == 1) {
				break;
			}
			System.out.println("!!!");
		}

	}

	public static int binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
