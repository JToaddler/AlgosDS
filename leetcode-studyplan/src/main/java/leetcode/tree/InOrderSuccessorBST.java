package leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;

import leetcode.model.TreeNode;

public class InOrderSuccessorBST {

	public static void main(String[] args) {

		TreeNode bst = new TreeNode(2);
		bst.right = new TreeNode(3);
		bst.left = new TreeNode(1);
		inorderSuccessor(bst, bst);
	}

	/**
	 * TODO
	 */
	public static TreeNode inorderSuccessor_recursion(TreeNode root, TreeNode p) {
		return null;
	}

	/**
	 * Time Complexity: O(N) - For skewed tree. O(logN) for balanced tree
	 * 
	 * Since we might end up encountering a skewed tree and in that case, we will
	 * just be discarding one node at a time. For a balanced binary search tree,
	 * however, the time complexity will be O(logN) which is what we usually find in
	 * practice.
	 * 
	 * Space Complexity: O(1) Since we don't use recursion or any other data
	 * structures for getting our successor.
	 */
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode suc = null;
		while (root != null) {
			if (p.val >= root.val) {
				root = root.right;
			} else {
				suc = root;
				root = root.left;
			}
		}
		return suc;
	}

	/**
	 * 
	 */
	public TreeNode inorderSuccessor_LIFO(TreeNode root, TreeNode p) {
		if (root == null || p == null)
			return null;

		Deque<TreeNode> stack = new ArrayDeque<>();

		boolean found = false;
		TreeNode curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (curr.val == p.val)
				found = true;
			else if (found) {
				return curr;
			}
			curr = curr.right;
		}
		return null;
	}

}
