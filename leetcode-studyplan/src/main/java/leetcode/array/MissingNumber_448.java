package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class MissingNumber_448 {

	public static void main(String[] args) {

		TreeSet<Integer> set = new TreeSet<>();
		
		

		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		findDisappearedNumbers_0(nums);
	}

	public static List<Integer> findDisappearedNumbers_0(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0)
				nums[index] = -1 * nums[index];
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				list.add(i + 1);
		}
		return list;
	}

	public static List<Integer> findDisappearedNumbers_1(int[] nums) {
		List<Integer> result = new ArrayList<>();
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, true);
		}
		System.out.println(map);
		for (int i = 0, j = 1; i <= nums.length - 1; i++, j++) {
			if (!map.containsKey(j))
				result.add(j);
		}
		System.out.println(result);
		return result;
	}

}
