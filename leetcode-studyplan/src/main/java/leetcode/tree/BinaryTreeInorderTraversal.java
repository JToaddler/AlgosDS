package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

import leetcode.model.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {

		/**
		 * <code>
		 * 				  9
		 * 			   /    \
		 * 			 11      65
		 * 			/ \     /  \
		 * 		   7	5  22   3
		 * </code>
		 */

		TreeNode root = new TreeNode(9);

		TreeNode left_l1 = new TreeNode(11);
		TreeNode right_l1 = new TreeNode(65);

		TreeNode left_l2_1 = new TreeNode(7);
		TreeNode right_l2_2 = new TreeNode(5);
		TreeNode left_l2_3 = new TreeNode(22);
		TreeNode right_l2_4 = new TreeNode(3);

		root.left = left_l1;
		root.right = right_l1;

		left_l1.left = left_l2_1;
		left_l1.right = right_l2_2;

		right_l1.left = left_l2_3;
		right_l1.right = right_l2_4;

		inorderTraversal_Stack(root);
	}

	public static List<Integer> inorderTraversal_Stack(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.add(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		System.out.println(res);
		
		
		
		return res;
		
		
		
		
	}

	/**
	 * 
	 * Time complexity: O(n)
	 * 
	 * The time complexity is O(n) because the recursive function is
	 * T(n)=2⋅T(n/2)+1. Space complexity: O(n)
	 * 
	 * The worst case space required is O(n), and in the average case it's O(logn)
	 * where n is number of nodes.
	 * 
	 */
	public List<Integer> inorderTraversal_recursion(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		visit(root, res);
		return res;
	}

	public void visit(TreeNode node, List<Integer> res) {
		if (node != null) {
			visit(node.left, res);
			res.add(node.val);
			visit(node.right, res);
		}
	}

}
