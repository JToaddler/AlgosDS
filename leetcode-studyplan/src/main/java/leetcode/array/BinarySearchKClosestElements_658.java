package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchKClosestElements_658 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 15, 16, 17 };
		System.out.println(Arrays.toString(arr) + ", Length=" + arr.length);
		findClosestElements(arr, 14, 1);
	}

	public static List<Integer> findClosestElements(int[] arr, int x, int k) {
		int left = 0;
		int right = arr.length - k;
		int mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			System.out.println(String.format("Left=%d, Mid=%d, Right=%d, arr[mid]=%d, arr[mid + k]=%d", left, mid,
					right, arr[mid], arr[mid + k]));
			if (x - arr[mid] > arr[mid + k] - x) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		System.out.println(String.format("Left=%d, Mid=%d, Right=%d", left, mid, right));
		List<Integer> res = new ArrayList<>();
		for (int i = left; i < left + k; i++) {
			res.add(arr[i]);
		}
		System.out.println(res);
		return res;
	}

}
