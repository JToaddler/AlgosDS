package leetcode.stack;

import java.util.Stack;

class StockSpanner {
	Stack<int[]> stack = new Stack<>();

	public StockSpanner() {

	}

	public int next(int price) {
		int ans = 1;
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			ans += stack.pop()[1];
		}
		stack.push(new int[] { price, ans });
		return ans;
	}

	public static void main(String[] args) {

		StockSpanner ss = new StockSpanner();
		System.out.println(ss.next(100));
		System.out.println(ss.next(80));
		System.out.println(ss.next(50));
		System.out.println(ss.next(55));
		System.out.println(ss.next(60));
		System.out.println(ss.next(50));

	}

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */