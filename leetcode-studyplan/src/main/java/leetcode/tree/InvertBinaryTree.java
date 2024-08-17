package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * @author Anto
 *
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			TreeNode temp = current.left;
			current.left = current.right;
			current.right = temp;
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
		return root;
	}

}
