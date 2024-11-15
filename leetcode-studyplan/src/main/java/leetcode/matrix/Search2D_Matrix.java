package leetcode.matrix;

/**
 * 
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 * 
 */
public class Search2D_Matrix {

	/**
	 * Because the rows and columns of the matrix are sorted (from left-to-right and
	 * top-to-bottom, respectively), we can prune O(m) or O(n) elements when looking
	 * at any particular value.
	 * 
	 * First, we initialize a (row,col) pointer to the bottom-left of the matrix.1
	 * Then, until we find target and return true (or the pointer points to a
	 * (row,col) that lies outside of the dimensions of the matrix), we do the
	 * following: if the currently-pointed-to value is larger than target we can
	 * move one row "up". Otherwise, if the currently-pointed-to value is smaller
	 * than target, we can move one column "right". It is not too tricky to see why
	 * doing this will never prune the correct answer; because the rows are sorted
	 * from left-to-right, we know that every value to the right of the current
	 * value is larger. Therefore, if the current value is already larger than
	 * target, we know that every value to its right will also be too large. A very
	 * similar argument can be made for the columns, so this manner of search will
	 * always find target in the matrix (if it is present).
	 * 
	 * This would work equally well with a pointer initialized to the top-right.
	 * Neither of the other two corners would work, as pruning a row/column might
	 * prevent us from achieving the correct answer
	 * 
	 * Time complexity : O(n+m)
	 * 
	 * The key to the time complexity analysis is noticing that, on every iteration
	 * (during which we do not return true) either row or col is is
	 * decremented/incremented exactly once. Because row can only be decremented m
	 * times and col can only be incremented n times before causing the while loop
	 * to terminate, the loop cannot run for more than n+m iterations. Because all
	 * other work is constant, the overall time complexity is linear in the sum of
	 * the dimensions of the matrix.
	 * 
	 * Space complexity : O(1)
	 * 
	 * Because this approach only manipulates a few pointers, its memory footprint
	 * is constant.
	 * 
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length - 1;
		int col = 0;

		while (row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] > target) {
				row--;
			} else if (matrix[row][col] < target) {
				col++;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean searchMatrix_binarySearch(int[][] matrix, int target) {
		for (int[] nums : matrix) {
			boolean result = binarySearch(nums, target);
			if (result)
				return true;
		}
		return false;
	}

	public boolean binarySearch(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = (right + left) / 2;
			if (nums[mid] == target)
				return true;
			if (nums[mid] > target)
				right = mid - 1;
			else if (nums[mid] < target) {
				left = mid + 1;
			}
		}
		return false;
	}

}
