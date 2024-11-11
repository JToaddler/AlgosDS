package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Time complexity: O(numRows)2
 * 
 * Space complexity: O(1)
 * 
 * While O(numRows 2 ) space is used to store the output, the input and output
 * generally do not count towards the space complexity.
 * 
 */
public class PascalTriangle_1 {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(List.of(1));
		for (int i = 1; i < numRows; i++) {
			List<Integer> cRow = new ArrayList<>();
			List<Integer> pRow = res.get(i - 1);
			cRow.add(1);
			for (int j = 1; j < i; j++) {
				cRow.add(pRow.get(j) + pRow.get(j - 1));
			}
			cRow.add(1);
			res.add(cRow);
		}
		return res;
	}
}
