package leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOfTwoSortedArrays_4 {

	public static void main(String[] args) {

		int[] nums1 = {};
		int[] nums2 = {};
		System.out.println(findMedianSortedArrays_2PointerMergedrray(nums1, nums2));
		System.out.println(findMedianSortedArrays_BF(nums1, nums2));
		System.out.println(findMedianSortedArrays_2Pointer(nums1, nums2));

	}

	public static double findMedianSortedArrays_2Pointer(int[] nums1, int[] nums2) {

		int n = nums1.length;
		int m = nums2.length;
		if (n + m == 0)
			return 0;
		int i = 0, j = 0, m1 = 0, m2 = 0;
		for (int count = 0; count <= (n + m) / 2; count++) {
			m2 = m1;
			if (i < n && j < m) {
				if (nums1[i] > nums2[j]) {
					m1 = nums2[j++];
				} else {
					m1 = nums1[i++];
				}
			} else if (i < n) {
				m1 = nums1[i++];
			} else {
				m1 = nums2[j++];
			}
		}
		if ((n + m) % 2 == 1) {
			return m1;
		} else {
			double ans = m1 + m2;
			return ans / 2.0;
		}
	}

	public static double findMedianSortedArrays_2PointerMergedrray(int[] nums1, int[] nums2) {

		int n = nums1.length;
		int m = nums2.length;

		int totLen = n + m;
		if (totLen == 0)
			return 0;
		int i = 0, j = 0, index = 0;
		int[] arr = new int[totLen];
		while (i < n && j < m) {
			if (nums1[i] < nums2[j]) {
				arr[index] = nums1[i];
				i++;
			} else {
				arr[index] = nums2[j];
				j++;
			}
			index++;
		}
		while (i < n) {
			arr[index] = nums1[i];
			index++;
			i++;
		}
		while (j < m) {
			arr[index] = nums2[j];
			index++;
			j++;
		}
		System.out.println(Arrays.toString(arr));
		if (totLen % 2 == 0) {
			int mid = (totLen / 2) - 1;
			return (double) (arr[mid] + arr[mid + 1]) / 2;
		} else {
			return arr[totLen / 2];
		}
	}

	public static double findMedianSortedArrays_BF(int[] nums1, int[] nums2) {
		int[] arr = new int[nums1.length + nums2.length];
		int l = arr.length;
		if (l == 0)
			return 0;
		int mid = (arr.length / 2) - 1;
		int i = 0;
		for (; i < nums1.length; i++) {
			arr[i] = nums1[i];
		}
		for (int j = 0; j < nums2.length; j++, i++) {
			arr[i] = nums2[j];
		}
		Arrays.sort(arr);
		if (l % 2 == 0)
			return (double) (arr[mid] + arr[mid + 1]) / 2;
		else
			return arr[l / 2];
	}

}
