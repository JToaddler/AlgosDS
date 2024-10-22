package leetcode.stack.monotonic;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemprature {

	public static void main(String[] args) {
		int[] temp = { 30, 60, 90 };
		dailyTemperatures_BF(temp);
	}

	// time limit exceeded exception - TC - O(N^2)
	public static int[] dailyTemperatures_BF(int[] temperatures) {
		int[] res = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			res[i] = findWarmerIndex(temperatures, i, temperatures[i]);
		}
		System.out.println(Arrays.toString(res));
		return res;
	}

	public static int findWarmerIndex(int[] temperatures, int i, int temp) {
		for (int j = i + 1; j < temperatures.length; j++) {
			if (temp < temperatures[j])
				return j - i;
		}
		return 0;
	}

}
