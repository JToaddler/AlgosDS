package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.TreeNode;

public class MaximumHeight_BST {

	/**
	 * Time complexity: O(N).
	 * 
	 * Space complexity: in the worst case, the tree is completely unbalanced, e.g.
	 * each node has only the left child node, the recursion call would occur N
	 * times (the height of the tree), the storage to keep the call stack would be
	 * O(N). But in the average case (the tree is balanced), the height of the tree
	 * would be log(N). Therefore, the space complexity in this case would be
	 * O(log(N)).
	 * 
	 */
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		int depth = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; ++i) {
				TreeNode removed = que.poll();
				if (removed.left != null)
					que.add(removed.left);
				if (removed.right != null)
					que.add(removed.right);
			}
			depth += 1;
		}
		return depth;
	}

}
