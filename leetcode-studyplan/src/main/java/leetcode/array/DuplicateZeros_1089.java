package leetcode.array;

import java.util.Arrays;

public class DuplicateZeros_1089 {

	public static void main(String[] args) {
		int[] nums = { 0, 4, 1, 0, 0, 8, 0, 0, 3 };
		System.out.println(Arrays.toString(nums));
		duplicateZeros(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void duplicateZeros(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				shift(arr, i);
				i = i + 1;
			}
		}
	}

	public static void shift(int[] arr, int start) {
		for (int j = arr.length - 1; j > start; j--) {
			arr[j] = arr[j - 1];
		}
		System.out.println(Arrays.toString(arr));
	}

}
