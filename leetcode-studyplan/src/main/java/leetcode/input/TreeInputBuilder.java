package leetcode.input;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.TreeNode;
import leetcode.tree.InvertBinaryTree;

public class TreeInputBuilder {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		TreeNode tree = buildTree(input);
		printTree_BFS_levelOrder(tree);
		InvertBinaryTree sol = new InvertBinaryTree();
		sol.invertTree(tree);
		printTree_BFS_levelOrder(tree);
	}

	public static TreeNode buildTree(int[] array) {
		if (array == null || array.length == 0)
			return null;

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(array[0]);
		queue.add(root);

		int i = 1;
		while (i < array.length) {
			TreeNode current = queue.remove();
			if (i < array.length) {
				current.left = new TreeNode(array[i++]);
				queue.add(current.left);
			}
			if (i < array.length) {
				current.right = new TreeNode(array[i++]);
				queue.add(current.right);
			}
		}
		return root;
	}

	public static void printTree_BFS_levelOrder(TreeNode tree) {

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(tree);
		while (!queue.isEmpty()) {
			TreeNode current = queue.remove();
			System.out.print(current.val + " ");
			if (current.left != null)
				queue.add(current.left);
			if (current.right != null)
				queue.add(current.right);
		}
		System.out.println();
	}

}
