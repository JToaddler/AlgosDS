package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.TreeNode;

public class SymetricBinaryTree {

	public static void main(String[] args) {
		
	}

	/**
	 * Time complexity: O(n). Because we traverse the entire input tree once, the
	 * total run time is O(n), where n is the total number of nodes in the tree.
	 * 
	 * Space complexity: There is additional space required for the search queue. In
	 * the worst case, we have to insert O(n) nodes in the queue. Therefore, space
	 * complexity is O(n).
	 */
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> que = new LinkedList<>();
		que.add(root);
		que.add(root);
		while (!que.isEmpty()) {
			TreeNode t1 = que.poll();
			TreeNode t2 = que.poll();
			if (t1 == null && t2 == null)
				continue;
			if (t1 == null || t2 == null)
				return false;
			if (t1.val != t2.val)
				return false;
			que.add(t1.left);
			que.add(t2.right);
			que.add(t1.right);
			que.add(t2.left);
		}
		return true;
	}

	/**
	 * Time complexity: O(n). Because we traverse the entire input tree once, the
	 * total run time is O(n), where n is the total number of nodes in the tree.
	 * 
	 * Space complexity: The number of recursive calls is bound by the height of the
	 * tree. In the worst case, the tree is linear and the height is in O(n).
	 * Therefore, space complexity due to recursive calls on the stack is O(n) in
	 * the worst case.
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric_recursion(TreeNode root) {
		return isMirror(root, root);
	}

	public static boolean isMirror(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
	}

}
