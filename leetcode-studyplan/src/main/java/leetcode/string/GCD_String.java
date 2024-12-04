package leetcode.string;

public class GCD_String {

	public static void main(String[] args) {
		System.out.println(gcdOfStrings("ABCABCABCABC", "ABCABC"));
	}

	public static String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1))
			return "";
		int gcd = findGCD(str1.length(), str2.length());
		return str1.substring(0, gcd);
	}

	public static int findGCD(int x, int y) {

		if (y == 0) {
			return x;
		}
		System.out.println(y + " " + x % y);
		return findGCD(y, x % y);
	}

}
