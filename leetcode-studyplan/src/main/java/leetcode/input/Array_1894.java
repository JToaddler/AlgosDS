package leetcode.input;

import java.util.Arrays;

public class Array_1894 {

	public static void main(String[] args) {

		int[] chalk = {};
		System.out.println(chalkReplacer(chalk, 999999999));
	}

	public static int chalkReplacer(int[] chalk, int k) {
		System.out.println(Arrays.toString(chalk) + " K=" + k);
		long count = k;
		int j = 0;
		long tot = 0;
		for (int i : chalk) {
			tot = tot + i;
		}
		if (tot < k) {
			count = k % tot;
		}
		while (true) {
			for (int i = 0; i < chalk.length && count >= 0; i++) {
				j = i;
				count = count - chalk[i];
				System.out.println("Count : " + count + ", j :" + j);
				if (count > 0) {
					continue;
				}
				if (count == 0) {
					j++;
					if (j >= chalk.length)
						j = j % chalk.length;
					break;
				}
			}
			if (count <= 0) {
				break;
			}
		}
		System.out.println("-- " + "oldCount =" + count + ", j = " + j);
		return j;
	}

}
