package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.TreeNode;

public class SearchBST {

	/**
	 * TC : O(H), where H is a tree height. That results in O(logN) in the average
	 * case, and O(N) in the worst case.
	 * 
	 * SC : O(H)
	 */
	public TreeNode searchBST_BFS(TreeNode root, int val) {
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		while (!que.isEmpty()) {
			TreeNode removed = que.poll();
			if (removed.val == val)
				return removed;
			if (removed.val < val && removed.right != null)
				que.add(removed.right);
			else if (removed.val > val && removed.left != null)
				que.add(removed.left);
		}
		return null;
	}

	/**
	 * Time complexity : O(H), where H is a tree height. That results in O(logN) in
	 * the average case, and O(N) in the worst case.
	 * 
	 * SC : O(1)
	 */
	public TreeNode searchBST_Iteration(TreeNode root, int val) {
		TreeNode cur = root;
		while (cur != null) {
			if (cur.val == val)
				return cur;
			else if (cur.val > val)
				cur = cur.left;
			else
				cur = cur.right;
		}
		return null;
	}

	/**
	 * TC : O(H), where H is a tree height. That results in O(logN) in the average
	 * case, and O(N) in the worst case.
	 * 
	 * SC : O(H)
	 */
	public TreeNode searchBST_recurssion(TreeNode root, int val) {
		if (root == null || root.val == val)
			return root;
		return root.val > val ? searchBST_recurssion(root.left, val) : searchBST_recurssion(root.right, val);
	}

}
