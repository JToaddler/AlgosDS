package leetcode.bitmanipulation;

import java.math.BigInteger;

/**
 * https://leetcode.com/problems/add-binary/description/
 * 
 */
public class BinaryAddition_67 {

	public static void main(String[] args) {

		Integer a = 11;
		Integer b = 10;

		addBinary_dumb("101111111111111111111111111111111111111111111111111111111110",
				"11111111111111111111111111111111111111111111111111111111111111111111011");
		addBinary_withBitManipulation("101111111111111111111111111111111111111111111111111111111110",
				"11111111111111111111111111111111111111111111111111111111111111111111011");
	}

	/*
	 * fails for long input string
	 * 
	 * @param a
	 * 
	 * @param b
	 * 
	 * @return
	 */
	public static String addBinary_dumb(String a, String b) {

		String sum = null;
		try {
			sum = Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

		System.out.println(sum);
		return sum;
	}

	public static String addBinary_withBitManipulation(String a, String b) {
		BigInteger x = new BigInteger(a, 2);
		BigInteger y = new BigInteger(b, 2);
		BigInteger zero = new BigInteger("0", 2);
		BigInteger sum, carry;
		while (y.compareTo(zero) != 0) {

			sum = x.xor(y);
			carry = x.and(y).shiftLeft(1);
			x = sum;
			y = carry;
		}
		System.out.println(x.toString());
		return x.toString(2);
	}

}
