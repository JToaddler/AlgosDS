package com.leetcode.scratchpad;

import java.util.ArrayList;
import java.util.List;

public class RangeSummary {

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>(nums.length);
		if (nums.length == 0)
			return result;
		for (int i = 0; i < nums.length; i++) {
			int start = nums[i];
			while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
				i++;
			}
			if (start != nums[i])
				result.add(start + "->" + nums[i]);
			else
				result.add(String.valueOf(start));
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		RangeSummary rs = new RangeSummary();
		rs.summaryRanges(new int[] { -1000000000, -9999, 0, 1, 2, 10, 100, 1000, 999999999, 1000000000 });
	}
}
