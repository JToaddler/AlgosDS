package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/path-sum
 */
public class PathSum {

	/**
	 * Time complexity : we visit each node exactly once, thus the time complexity
	 * is O(N), where N is the number of nodes.
	 * 
	 * 
	 * Space complexity : in the worst case, the tree is completely unbalanced, e.g.
	 * each node has only one child node, the recursion call would occur N times
	 * (the height of the tree), therefore the storage to keep the call stack would
	 * be O(N). But in the best case (the tree is completely balanced), the height
	 * of the tree would be log(N). Therefore, the space complexity in this case
	 * would be O(log(N)).
	 */
	public boolean hasPathSum_recursion(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		targetSum -= root.val;
		if (root.left == null && root.right == null)
			return targetSum == 0;
		return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
	}

	/**
	 * same as recursion
	 */
	public boolean hasPathSum(TreeNode root, int targetSum) {
		Queue<State> que = new LinkedList<>();
		que.add(new State(root, targetSum));
		while (!que.isEmpty()) {
			State removed = que.poll();
			TreeNode node = removed.key;
			int sum = removed.val;
			if (node != null) {
				sum -= node.val;
				if (node.left == null && node.right == null && sum == 0)
					return true;
				que.add(new State(node.left, sum));
				que.add(new State(node.right, sum));
			}
		}
		return false;
	}

	class State {
		TreeNode key;
		int val;

		public State(TreeNode node, int val) {
			this.key = node;
			this.val = val;
		}
	}

}
