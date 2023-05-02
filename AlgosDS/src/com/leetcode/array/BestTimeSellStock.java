package com.leetcode.array;

/**
 * 
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 * 
 * 
 * @author Anto
 *
 */
public class BestTimeSellStock {

	/**
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity: O(n^2). Calculating area for all n(n−1)/2 height pairs.
	 * 
	 * Space complexity: O(1) Only two variables - maxprofit and profit are used.
	 * 
	 * @param prices
	 * @return
	 */
	public static int findMaxProfit_BruteForce(int[] prices) {
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] - prices[i] > maxProfit) {
					maxProfit = prices[j] - prices[i];
				}
			}
		}
		return maxProfit;
	}

	/**
	 * 
	 * Complexity Analysis
	 * 
	 * Time complexity: O(n). Only a single pass is needed.
	 * 
	 * Space complexity: O(1). Only two variables are used.
	 * 
	 * @param prices
	 * @return
	 */
	public static int findMaxProfit_Optimized(int[] prices) {
		int min_price = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min_price) {
				min_price = prices[i];
			} else if (prices[i] - min_price > maxProfit) {
				maxProfit = prices[i] - min_price;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(findMaxProfit_BruteForce(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(findMaxProfit_Optimized(new int[] { 7, 1, 5, 3, 6, 4 }));
	}
}
