package com.leetcode.slidingwindow;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 * 
 * https://www.youtube.com/watch?v=TsA4vbtfCvo
 * 
 * @author Anto
 *
 */
public class MaximumPointsFromArray {
	public static void main(String[] args) {

		maxScore(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3);

	}

	public static int maxScore(int[] cardPoints, int k) {
		int right = cardPoints.length - k;
		int left = 0;
		int sum = 0;
		for (int i = right; i < cardPoints.length; i++)
			sum += cardPoints[i];

		int res = sum;
		while (right < cardPoints.length) {
			sum = sum + cardPoints[left] - cardPoints[right];
			res = Math.max(sum, res);
			left++;
			right++;
		}
		System.out.println(res);
		return res;
	}
}
