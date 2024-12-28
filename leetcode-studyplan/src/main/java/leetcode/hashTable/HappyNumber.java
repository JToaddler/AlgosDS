package leetcode.hashTable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		isHappy(19);
	}

	public static boolean isHappy(int n) {
		if (n == 1)
			return true;
		Set<Integer> set = new HashSet<>();
		set.add(n);
		int newNum = n;
		while (newNum != 1) {
			newNum = getNextNum(newNum);
			if (set.contains(newNum))
				return false;
		}
		return true;
	}

	public static int getNextNum(int n) {
		int tot = 0;
		while (n > 0) {
			int digit = n % 10;
			n = n / 10;
			tot = tot + (digit * digit);
		}
		return tot;
	}

}
