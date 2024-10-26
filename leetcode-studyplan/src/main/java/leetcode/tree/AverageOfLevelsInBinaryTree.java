package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
 * 
 * Time complexity : O(n). The whole tree is traversed at most once. Here, n
 * refers to the number of nodes in the given binary tree.
 * 
 * Space complexity : O(m). The size of queue or temp can grow upto at most the
 * maximum number of nodes at any level in the given binary tree. Here, m refers
 * to the maximum mumber of nodes at any level in the input tree.
 * 
 */
public class AverageOfLevelsInBinaryTree {

	public static void main(String[] args) {

	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		while (!que.isEmpty()) {
			double count = 0;
			int size = que.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = que.poll();
				count += node.val;
				if (node.left != null)
					que.add(node.left);
				if (node.right != null)
					que.add(node.right);
			}
			res.add((double) count / size);
		}
		return res;
	}

}
