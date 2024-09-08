package leetcode.array;

import java.util.Arrays;

public class SearchRotatedArray {

	public static void main(String[] args) {

		// int[] arr = buildArray(6);
		int[] arr = { 2, 4, 5, 6, 7, 12, };
		int target = 2;
		Arrays.sort(arr);
		System.out.println("Sroted :" + Arrays.toString(arr));
		rotateArray(arr, 2);
		System.out.println("Sroted :" + Arrays.toString(arr));
		System.out.println(findPivot(arr, target));

	}

	public static int findPivot(int[] arr, int target) {
		int n = arr.length - 1;
		int left = 0, right = n;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > arr[n - 1]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(String.format("Right=%d, Left=%d", arr[right], arr[left]));
		int res = binarySearch(arr, 0, left - 1, target);
		if (res != -1)
			return res;
		return binarySearch(arr, left, n - 1, target);
	}

	public static void rotateArray(int[] arr, int rotateCount) {
		int rotation = 0;
		while (rotation < rotateCount) {
			int first = arr[0];
			for (int i = 1; i <= arr.length - 1; i++) {
				arr[i - 1] = arr[i];
			}
			arr[arr.length - 1] = first;
			rotation++;
		}
	}

	public static int binarySearch(int[] arr, int leftIndex, int rightIndex, int target) {
		int left = leftIndex, right = rightIndex;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < target) {
				left = mid + 1;
			} else if (arr[mid] > target) {
				right = right - 1;
			} else
				return mid;
		}
		System.out.println(String.format("binarySearch Right=%d, Left=%d", right, left));
		return -1;
	}
}
