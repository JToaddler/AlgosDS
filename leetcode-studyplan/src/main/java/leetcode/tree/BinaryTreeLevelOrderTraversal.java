package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 
 * Time complexity: O(N) since each node is processed exactly once.
 * 
 * Space complexity: O(N) to keep the output structure which contains N node
 * values.
 * 
 */
public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> que = new LinkedList<>();
		int level = 0;
		que.add(root);
		while (!que.isEmpty()) {
			res.add(new ArrayList<Integer>());
			int size = que.size();
			for (int i = 0; i < size; i++) {
				TreeNode removed = que.poll();
				res.get(level).add(removed.val);
				if (removed.left != null)
					que.add(removed.left);
				if (removed.right != null)
					que.add(removed.right);
			}
			level++;
		}
		return res;
	}
}
