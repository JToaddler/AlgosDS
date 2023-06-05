package com.leetcode.number;

/**
 * 
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 * 
 * <code>
 * explanation : 
 * 
 * slope m = (y2-y1)/(x2-x2)
 * 
 * 
 * For Vertical line m = 0  [x2 -x1 = 0]
 * For 
 * 
 * delta y/delta x = y2-y1/x2-x2 
 * 
 * For 3 points, Slope m1 & m2 will be equal.
 * 
 * deltaY1      deltaY2
 * --------  = -------- => deltaY1 * delta X2 = deltaY2 * deltaX1 
 * deltaX1      deltaX2
 * </code>
 * 
 * 
 * 
 * @author Anto
 *
 */
public class StraightLine {

	public static boolean checkStraightLine(int[][] coordinates) {

		int deltaX = coordinates[1][0] - coordinates[0][0];
		int deltaY = coordinates[1][1] - coordinates[0][1];
		for (int i = 2; i < coordinates.length; i++) {
			if ((deltaY * (coordinates[i][0] - coordinates[0][0])) != (deltaX
					* (coordinates[i][1] - coordinates[0][1])))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] coordinates = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };

		System.out.println(checkStraightLine(coordinates));
	}
}
