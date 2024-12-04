package leetcode.math;

public class LCM {

	public static void main(String[] args) {
		lcm(40, 48);
	}

	public static int lcm(int x, int y) {
		int lcm = (x * y) / gcd(x, y);
		System.out.println("LCM " + lcm);
		return lcm;
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

}
