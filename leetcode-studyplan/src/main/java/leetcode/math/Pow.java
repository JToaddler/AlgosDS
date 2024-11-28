package leetcode.math;

/**
 * https://leetcode.com/problems/powx-n/description/
 * 
 * Time complexity: O(logn)
 * 
 * At each iteration, we reduce n by half, thus it means we will make only logn
 * number of iterations using a while loop. Thus, it will take overall O(logn)
 * time.
 * 
 * Space complexity: O(1)
 * 
 */
public class Pow {

	public static void main(String[] args) {

	}

	public static double myPow(double x, int n) {
		return binaryExp(x, n);
	}

	public static double binaryExp(double x, long n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -1 * n;
			x = 1.0 / x;
		}
		double result = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				result = result * x;
				n -= 1;
			}
			x = x * x;
			n = n / 2;
		}
		return result;
	}

}
