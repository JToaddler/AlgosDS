package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle_118 {

	public static void main(String[] args) {
		generate(6);
	}

	public List<List<Integer>> generate_Editorial(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();

		// Base case; first row is always [1].
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);

		for (int rowNum = 1; rowNum < numRows; rowNum++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(rowNum - 1);

			// The first row element is always 1.
			row.add(1);

			// Each triangle element (other than the first and last of each row)
			// is equal to the sum of the elements above-and-to-the-left and
			// above-and-to-the-right.
			for (int j = 1; j < rowNum; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			}

			// The last row element is always 1.
			row.add(1);

			triangle.add(row);
		}

		return triangle;
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
