package leetcode.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/lexicographical-numbers/description/
 * 
 */
public class LexicographicalNumbers_Sort_386 {

	public static void main(String[] args) {
		lexicalOrder_Correct(112);
	}

	public List<Integer> lexicalOrder(int n) {

		List<Integer> result = IntStream.rangeClosed(1, n).boxed()
				.sorted((a, b) -> String.valueOf(a).compareTo(String.valueOf(b))).collect(Collectors.toList());
		return result;

	}

	public List<Integer> lexicalOrder_2(int n) {
		List<Integer> res = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			res.add(i);
		}
		res.sort((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
		return res;
	}

	public static List<Integer> lexicalOrder_Correct(int n) {

		List<Integer> res = new ArrayList<>(n);
		int num = 1;
		for (int i = 0; i < n; i++) {
			res.add(num);
			if (num * 10 < n) {
				num *= 10;
			} else {
				while (num % 10 == 9 || num >= n) {
					num /= 10;
				}
				num += 1;
			}
		}
		System.out.println(res);
		return res;
	}

}
