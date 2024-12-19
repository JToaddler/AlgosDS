package leetcode.tree;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * 
 * Time complexity: O(N) since we visit each node exactly once.
 * 
 * Space complexity: O(logN).
 * 
 * The recursion stack requires O(logN) space because the tree is
 * height-balanced. Note that the O(N) space used to store the output does not
 * count as auxiliary space, so it is not included in the space complexity.
 */
public class ArrayToBST {

	int[] nums;

	public TreeNode sortedArrayToBST(int[] nums) {
		this.nums = nums;
		return dfsPreOrder(0, nums.length - 1);
	}

	public TreeNode dfsPreOrder(int left, int right) {
		if (left > right)
			return null;
		int mid = left + ((right - left) / 2);
		TreeNode node = new TreeNode(nums[mid]);
		node.left = dfsPreOrder(left, mid - 1);
		node.right = dfsPreOrder(mid + 1, right);
		return node;
	}
}
