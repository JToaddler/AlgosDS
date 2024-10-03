package com.algosds.array;

import java.util.Arrays;

/**
 * 189
 * 
 * https://leetcode.com/problems/rotate-array/
 * 
 * Time complexity: O(N) Auxiliary Space: O(D)
 * 
 * 2 ways to solve this problem
 * 
 * a) Temp array & start iteration from index till end of array (index ->
 * length) And (0 to index +1) b) In place rotation. shift 1 -> 0, 2-> 1, 3->
 * 2......n -> n-1,0 -> n
 * 
 * @author Anto
 *
 */
public class Rorate1DArray {

	public void rotate(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}

	public static int[] rotateArrayByIndex(int[] array, int index) {

		for (int i = 0; i < index; i++) {
			rotateArrayByOne(array);
		}
		System.out.println(Arrays.toString(array));
		return array;
	}

	public static int[] rotateArrayByOne(int[] array) {

		int start = array[0];
		for (int i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		array[array.length - 1] = start;
		return array;
	}

	public static void main(String[] args) {

		int[] intArray = new int[] { -1, -100, 3, 99 };
		int[] intArray2 = new int[] { 1, 2, 3, 4, 5, 6, 7 };

		int shiftPosition = 2;
		// rotateArrayByOne(intArray);
		System.out.println(Arrays.toString(intArray2));
		rotateArrayByIndex(intArray2, 5);
	}
}
