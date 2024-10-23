package leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterNumber {

	public static void main(String[] args) {
		int[] nums1 = { 4, 1, 2 };
		int[] nums2 = { 1, 3, 4, 2 };
		nextGreaterElement(nums1, nums2);
	}

	// BF solution
	// TC - O(m*n) - m number of element in num1, n number of element in nums2
	// SC - O(N) - n number of element in nums2
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums2.length; i++)
			map.put(nums2[i], i);
		for (int i = 0; i < nums1.length; i++) {
			int index = map.get(nums1[i]);
			res[i] = -1;
			for (int j = index; j < nums2.length; j++) {
				if (nums1[i] < nums2[j]) {
					res[i] = nums2[j];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(res));
		return res;
	}

	// optimized
	/*
	 * Time complexity: O(n). The entire nums2 array (of size n) is scanned only
	 * once. Each of the stack's n elements are pushed and popped exactly once. The
	 * nums1 array is also scanned only once. All together this requires O(n+n+m)
	 * time. Since nums1 must be a subset of nums2, we know m must be less than or
	 * equal to n. Therefore, the time complexity can be simplified to O(n).
	 * 
	 * Space complexity: O(n). map will store n key-value pairs while stack will
	 * contain at most n elements at any given time.
	 * 
	 */ public int[] nextGreaterElement_stack(int[] nums1, int[] nums2) {
		int[] res = new int[nums1.length];
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>(nums2.length);

		for (int i = 0; i < nums2.length; i++) {
			while (!stack.isEmpty() && nums2[i] > stack.peek()) {
				map.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}
		while (!stack.isEmpty())
			map.put(stack.pop(), -1);

		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}
		return res;
	}
}
