package leetcode.string;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Time complexity: O(n 3 )
 * 
 * The two nested for loops iterate O(n 2 ) times. We check one substring of
 * length n, two substrings of length n - 1, three substrings of length n - 2,
 * and so on.
 * 
 * There are n substrings of length 1, but we don't check them all since any
 * substring of length 1 is a palindrome, and we will return immediately.
 * 
 * Therefore, the number of substrings that we check in the worst case is 1 + 2
 * + 3 + ... + n - 1. This is the partial sum of this series for n - 1, which is
 * equal to 2 n⋅(n−1) ​ =O(n 2 ).
 * 
 * In each iteration of the while loop, we perform a palindrome check. The cost
 * of this check is linear with n as well, giving us a time complexity of O(n 3
 * ).
 * 
 * Note that this time complexity is in the worst case and has a significant
 * constant divisor that is dropped by big O. Due to the optimizations of
 * checking the longer length substrings first and exiting the palindrome check
 * early if we determine that a substring cannot be a palindrome, the practical
 * runtime of this algorithm is not too bad.
 * 
 * Space complexity: O(1)
 * 
 * We don't count the answer as part of the space complexity. Thus, all we use
 * are a few integer variables.
 * 
 */
public class LongestPalindorome {

	public static String longestPalindrome_2(String s) {
		for (int len = s.length(); len > 0; len--) {
			for (int start = 0; start <= s.length() - len; start++) {
				if (isPlaindrome_2(start, start + len, s)) {
					return s.substring(start, start + len);
				}
			}
		}
		return "";
	}

	public static boolean isPlaindrome_2(int i, int j, String s) {
		int left = i, right = j - 1;
		System.out.println(String.format("Left = %d Right = %d S=%s", left, right, s.substring(left, right)));
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

}
