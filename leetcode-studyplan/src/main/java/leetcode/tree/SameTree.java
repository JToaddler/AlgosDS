package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.model.TreeNode;

/**
 * 
 * https://leetcode.com/problems/same-tree/
 * 
 */
public class SameTree {

	/**
	 * Time complexity : O(N), where N is a number of nodes in the tree, since one
	 * visits each node exactly once.
	 * 
	 * Space complexity : O(N) in the worst case of completely unbalanced tree, to
	 * keep a recursion stack.
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		else
			return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
	}

	/**
	 * Time complexity : O(N) since each node is visited exactly once.
	 * 
	 * Space complexity : O(N) in the worst case, where the tree is a perfect fully
	 * balanced binary tree, since BFS will have to store at least an entire level
	 * of the tree in the queue, and the last level has O(N) nodes.
	 */
	public boolean isSameTree_iterative(TreeNode p, TreeNode q) {

		Queue<TreeNode> pQue = new LinkedList<>();
		Queue<TreeNode> qQue = new LinkedList<>();

		pQue.add(p);
		qQue.add(q);

		while (!pQue.isEmpty()) {
			TreeNode removedP = pQue.poll();
			TreeNode removedQ = qQue.poll();
			if (isSameNode(removedP, removedQ)) {
				if (removedP != null) {
					pQue.add(removedP.left);
					qQue.add(removedQ.left);
					pQue.add(removedP.right);
					qQue.add(removedQ.right);
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isSameNode(TreeNode node1, TreeNode node2) {
		if (node1 == null & node2 == null)
			return true;
		if (node1 != null & node2 != null) {
			if (node1.val == node2.val)
				return true;
			else
				return false;
		}
		return false;// either node 1 is null or node 2 is null.
	}

}
