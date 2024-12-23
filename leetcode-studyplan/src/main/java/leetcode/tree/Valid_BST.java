package leetcode.tree;

import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * 
 * Time complexity: O(N) in the worst case when the tree is BST or the "bad"
 * element is the rightmost leaf.
 * 
 * 
 * Space complexity: O(N) to keep stack.
 * 
 */
public class Valid_BST {

	Integer prev = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> stack = new Stack<>();
		Integer prev = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (prev != null && prev >= root.val) {
				return false;
			}
			prev = root.val;
			root = root.right;
		}
		return true;
	}

	public boolean isValidBST_recursion(TreeNode root) {
		if (root == null)
			return true;

		boolean result = isValidBST_recursion(root.left);
		if (!result) {
			return false;
		}

		if (prev != null && prev >= root.val) {
			return false;
		}
		prev = root.val;
		return isValidBST_recursion(root);
	}

}
