package com.leetcode.array;

import java.util.Arrays;

/**
 * 
 * https://leetcode.com/problems/merge-sorted-array/description/
 * 
 * @author Anto
 *
 */
public class MergeSortedArray {

	public static void main(String[] args) {

		int[] nums1 = new int[] { 0 };
		int[] nums2 = new int[] { 1 };

		merge(nums1, 0, nums2, 1);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int p = m - 1;
		int q = n - 1;
		int k = m + n - 1;
		while (p >= 0 && q >= 0) {
			if (nums1[p] > nums2[q]) {
				nums1[k--] = nums1[p--];
			} else {
				nums1[k--] = nums2[q--];
			}
		}
		while (q >= 0) {
			nums1[k--] = nums2[q--];
		}
		System.out.println(Arrays.toString(nums1));

	}

}
