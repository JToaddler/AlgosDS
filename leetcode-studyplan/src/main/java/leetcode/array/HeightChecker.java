package leetcode.array;

import java.util.Arrays;

public class HeightChecker {

	public int heightChecker(int[] heights) {
		int mismatch = 0;
		int length = heights.length;
		Integer[] newH = new Integer[length];
		for (int i = 0; i < heights.length; i++)
			newH[i] = heights[i];

		Arrays.sort(newH, (a, b) -> {
			return Integer.compare(a, b);
		});
		for (int i = 0; i < length; i++) {
			if (heights[i] != newH[i])
				mismatch++;
		}
		return mismatch;
	}
}
