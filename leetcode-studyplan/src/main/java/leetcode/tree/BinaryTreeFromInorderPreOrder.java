package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 */
public class BinaryTreeFromInorderPreOrder {

	int pIndex = 0;
	int[] pOrder;
	int[] iOrder;
	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		this.pOrder = preorder;
		this.iOrder = inorder;

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return dfs(0, inorder.length - 1);
	}

	public TreeNode dfs(int left, int right) {
		if (left > right)
			return null;

		int rootVal = pOrder[pIndex];
		TreeNode node = new TreeNode(rootVal);
		pIndex++;
		int mid = map.get(rootVal);
		node.left = dfs(left, mid - 1);
		node.right = dfs(mid + 1, right);
		return node;
	}
}
