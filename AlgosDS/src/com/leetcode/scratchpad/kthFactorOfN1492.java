package com.leetcode.scratchpad;

/**
 * 
 * Could you solve this problem in less than O(n) complexity?
 * 
 * https://leetcode.com/problems/the-kth-factor-of-n/description/
 * 
 * after N / 2, N is the largest factor. Not necessary to iterate till N.
 * 
 * @author Anto
 *
 */
public class kthFactorOfN1492 {

	public static void main(String[] args) {
		System.out.println(" kth Factor :" + kthFactor(12, 3));
	}

	public static int kthFactor(int n, int k) {

		int increment = n % 2 == 0 ? 1 : 2;
		int j = 0;
		for (int i = 1; i <= n / 2; i = i + increment) {
			if (n % i == 0)
				j++;
			if (j == k) {
				return i;
			}
		}
		return -1;
	}

}
