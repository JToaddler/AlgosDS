package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * 
 */
public class BinaryTreePreOrderTraversal {

	public static void main(String[] args) {

	}

	/**
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode removed = stack.pop();
			result.add(removed.val);
			if (removed.right != null)
				stack.push(removed.right);
			if (removed.left != null)
				stack.push(removed.left);
		}
		return result;
	}

	/**
	 * TC - O(n) SC - O(h)
	 */
	public List<Integer> preorderTraversal_recursion(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs_PreOrder(root, res);
		return res;
	}

	public void dfs_PreOrder(TreeNode root, List<Integer> res) {
		if (root == null)
			return;
		res.add(root.val);
		dfs_PreOrder(root.left, res);
		dfs_PreOrder(root.right, res);
	}

}
