package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/description/
 * 
 */
public class Combinations {

	int n;
	int k;

	public List<List<Integer>> combine(int n, int k) {
		this.n = n;
		this.k = k;
		List<List<Integer>> ans = new ArrayList<>();
		backTrack(new ArrayList<Integer>(), 1, ans);
		return ans;
	}

	public void backTrack(List<Integer> cur, int firstNum, List<List<Integer>> ans) {
		if (cur.size() == k) {
			ans.add(new ArrayList<>(cur));
			return;
		}
		int need = k - cur.size();
		int remain = n - firstNum + 1;
		int k = remain - need;
		for (int i = firstNum; i <= k + firstNum; i++) {
			cur.add(i);
			backTrack(cur, i + 1, ans);
			cur.remove(cur.size() - 1);
		}

	}

}
