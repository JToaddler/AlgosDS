package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/description/
 * 
 * 
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2, 3, 3, 3, 3, 2, 2, 2, 2 };
		System.out.println(majorityElement(nums));
	}

	/**
	 * Time complexity : O(n)
	 * 
	 * Boyer-Moore performs constant work exactly n times, so the algorithm runs in
	 * linear time.
	 * 
	 * Space complexity : O(1)
	 * 
	 * Boyer-Moore allocates only constant additional memory.
	 * 
	 */
	public static int majorityElement(int[] nums) {
		int count = 0;
		int element = 0;
		for (int num : nums) {
			if (count == 0) {
				element = num;
			}
			count += (num == element) ? 1 : -1;
		}
		return element;
	}

	/**
	 * 
	 * Time complexity : O(n)
	 * 
	 * We iterate over nums once and make a constant time HashMap insertion on each
	 * iteration. Therefore, the algorithm runs in O(n) time.
	 * 
	 * Space complexity : O(n)
	 * 
	 * At most, the HashMap can contain n−⌊ 2 n ​ ⌋ associations, so it occupies
	 * O(n) space. This is because an arbitrary array of length n can contain n
	 * distinct values, but nums is guaranteed to contain a majority element, which
	 * will occupy (at minimum) ⌊ 2 n ​ ⌋+1 array indices. Therefore, n−(⌊ 2 n ​
	 * ⌋+1) indices can be occupied by distinct, non-majority elements (plus 1 for
	 * the majority element itself), leaving us with (at most) n−⌊ 2 n ​ ⌋ distinct
	 * elements.
	 * 
	 */
	public static int majorityElement_HashMap(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				int count = map.get(i) + 1;
				map.put(i, count);
				if (count > n / 2)
					return i;
			} else {
				map.put(i, 1);
			}
		}
		return -1;
	}

	/**
	 * Time complexity : O(nlgn)
	 * 
	 * Sorting the array costs O(nlgn) time in Python and Java, so it dominates the
	 * overall runtime.
	 * 
	 * Space complexity : O(1) or (O(n))
	 * 
	 * We sorted nums in place here - if that is not allowed, then we must spend
	 * linear additional space on a copy of nums and sort the copy instead.
	 */
	public int majorityElement_ArraySort(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

}
