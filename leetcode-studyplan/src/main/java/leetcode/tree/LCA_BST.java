package leetcode.tree;

import leetcode.model.TreeNode;

public class LCA_BST {

	/**
	 * Using BST property
	 * 
	 * Time Complexity : O(N), where N is the number of nodes in the BST. In the
	 * worst case we might be visiting all the nodes of the BST.
	 * 
	 * Space Complexity : O(1).
	 * 
	 * this can be implemented without using BST property : refer {@link LCA_BinnaryTree}
	 * 
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		int pVal = p.val;
		int qVal = q.val;

		TreeNode node = root;
		while (node != null) {
			int parentVal = node.val;
			if (pVal > parentVal && qVal > parentVal) {
				node = node.right;
			} else if (pVal < parentVal && qVal < parentVal) {
				node = node.left;
			} else {
				return node;
			}
		}
		return null;
	}

	
	
}
