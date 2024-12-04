package leetcode.math;

public class GCD {

	public static void main(String[] args) {
		gcd(40, 48);

		System.out.println(findGCD(12, 6));
	}

	public static int gcd(int x, int y) {
		int gcd = 1;
		for (int i = 1; i <= x && i <= y; i++) {
			if (x % i == 0 && y % i == 0) {
				gcd = i;
			}
		}
		System.out.println("GCD : " + gcd);
		return gcd;
	}

	/**
	 * find GCD using recursion
	 */
	public static int findGCD(int a, int b) {
		if (b == 0)
			return a;
		System.out.println(b + " " + a % b);
		return findGCD(b, a % b);
	}

}
