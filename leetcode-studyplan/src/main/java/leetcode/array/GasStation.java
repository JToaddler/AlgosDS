package leetcode.array;

/**
 * https://leetcode.com/problems/gas-station
 * 
 * 
 */
public class GasStation {

	/**
	 * Time complexity: O(2n) => O(n)
	 * 
	 * 
	 * Space complexity: O(1)
	 */
	public int canCompleteCircuit_2Pass(int[] gas, int[] cost) {
		int totGas = 0;
		int totCost = 0;
		for (int i = 0; i < gas.length; i++) {
			totGas += gas[i];
			totCost += cost[i];
		}
		if (totGas < totCost)
			return -1;
		int curGas = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			curGas += gas[i] - cost[i];
			if (curGas < 0) {
				curGas = 0;
				start = i + 1;
			}
		}
		return start;
	}

	/**
	 * Time complexity: O(n)
	 * 
	 * 
	 * Space complexity: O(1)
	 */
	public int canCompleteCircuit_Optimized(int[] gas, int[] cost) {
		int tot = 0, cur = 0, ans = 0;
		for (int i = 0; i < gas.length; i++) {
			tot += gas[i] - cost[i];
			cur += gas[i] - cost[i];
			if (cur < 0) {
				cur = 0;
				ans = i + 1;
			}
		}
		return tot >= 0 ? ans : -1;
	}

}
