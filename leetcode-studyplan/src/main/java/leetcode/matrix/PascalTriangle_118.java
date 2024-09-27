package leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {

	public static void main(String[] args) {
		generate(6);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>(numRows);
		list.add(List.of(1));
		List<Integer> pRow = list.get(0);
		int pSize = pRow.size();
		for (int i = 2; i <= numRows; i++) {
			List<Integer> cRow = new ArrayList<>(i);
			cRow.add(1);
			if (cRow.size() + 1 < i) {
				for (int j = 2; j < i; j++) {
					int a = (j - 1 < 0 ? 1 : j - 1) - 1;
					int b = (j > pSize ? 1 : j - 1);
					cRow.add(pRow.get(a) + pRow.get(b));
				}
			}
			cRow.add(1);
			list.add(cRow);
			pRow = cRow;
			pSize = pRow.size();
		}
		System.out.println(list);
		return list;
	}

}
