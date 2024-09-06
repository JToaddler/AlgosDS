package leetcode.binarysearch;

import java.time.LocalDateTime;

public class GuessNumber_374 {
	public static void main(String[] args) {

		System.out.println(guessNumber(1690815734));

	}

	public static int guessNumber(int n) {
		System.out.println(LocalDateTime.now());
		if (n == 1)
			return 1;
		int left = 1;
		int right = n;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			int result = guess(mid);
			if (result == -1) {
				right = mid - 1;
			} else if (result == 1) {
				left = mid + 1;
			} else if (result == 0) {
				System.out.println(LocalDateTime.now());
				return mid;
			}
		}
		return -1;
	}

	public static int guess(int num) {
		if (num == 1049889538) {
			return 0;
		} else if (num > 1049889538) {
			return -1;
		} else {
			return 1;
		}
	}
}
