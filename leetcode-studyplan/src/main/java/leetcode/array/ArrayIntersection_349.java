package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection_349 {

	public static void main(String[] args) {
		int[] num1 = { 4, 9, 5 };
		int[] num2 = { 9, 4, 9, 8, 4 };
		intersection_Set(num1, num2);
		intersection_Sort(num1, num2);

	}

	public static int[] intersection_Set(int[] nums1, int[] nums2) {

		HashSet<Integer> set1 = new HashSet<>();
		for (int n : nums1)
			set1.add(n);

		Set<Integer> set2 = new HashSet<>();
		for (int n : nums2)
			set2.add(n);

		set1.retainAll(set2);
		int[] result = new int[set1.size()];
		int j = 0;
		for (int i : set1) {
			result[j] = i;
			j += 1;
		}
		return result;
	}

	public static int[] intersection_Sort(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		Set<Integer> set = new HashSet<>();
		int N = nums1.length;
		int M = nums2.length;
		int p1 = 0, p2 = 0;
		while (p1 < N && p2 < M) {
			if (nums1[p1] == nums2[p2]) {
				set.add(nums1[p1]);
				p1++;
				p2++;
			} else if (nums1[p1] < nums2[p2]) {
				p1++;
			} else {
				p2++;
			}
		}
		int i = 0;
		int[] res = new int[set.size()];
		for (int ele : set) {
			res[i] = ele;
			i++;
		}
		return res;
	}

}
