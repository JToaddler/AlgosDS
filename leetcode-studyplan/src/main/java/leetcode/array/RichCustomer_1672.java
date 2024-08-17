package leetcode.array;

import leetcode.input.Array2DBuilder;

public class RichCustomer_1672 {

	public int maximumWealth(int[][] accounts) {
		int max = 0;
		for (int[] banks : accounts) {
			max = Math.max(max, getTotal(banks));
		}
		System.out.println("Max wealth :" + max);
		return max;
	}

	public int getTotal(int[] bank) {
		int total = 0;
		for (int i : bank) {
			total = total + i;
		}
		return total;
	}

	public static void main(String[] args) {
		RichCustomer_1672 ob = new RichCustomer_1672();
		int[][] accounts = Array2DBuilder.build2dArray(2, 3);
		ob.maximumWealth(accounts);
	}

}
