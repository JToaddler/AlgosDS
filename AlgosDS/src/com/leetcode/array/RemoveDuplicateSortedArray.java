package com.leetcode.array;

import java.util.Arrays;

public class RemoveDuplicateSortedArray {

	public static void main(String[] args) {
		deleteDuplicate(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
	}

	public static int deleteDuplicate(int[] nums) {

		int index = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[index] = nums[i + 1];
				index++;
			}
		}
		System.out.println(Arrays.toString(nums));
		return index;
	}

}
