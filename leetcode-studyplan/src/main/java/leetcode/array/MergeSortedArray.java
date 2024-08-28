package leetcode.array;

import java.util.Arrays;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {

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

	}

	public void merge_2(int[] nums1, int m, int[] nums2, int n) {

		for (int i = 0; i < nums2.length; i++) {
			nums1[m + i] = nums2[i];
		}
		Arrays.sort(nums1);
	}
}
