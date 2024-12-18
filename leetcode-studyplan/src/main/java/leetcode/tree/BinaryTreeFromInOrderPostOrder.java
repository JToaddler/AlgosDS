package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * 
 * Time complexity : O(N)
 * 
 * 
 * Space complexity : O(N), since we store the entire tree.
 * 
 * 
 */
public class BinaryTreeFromInOrderPostOrder {

	int pIndex;
	int[] pOrder;
	int[] iOrder;
	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.pOrder = postorder;
		this.iOrder = inorder;
		this.pIndex = postorder.length - 1;
		for (int x = 0; x < inorder.length; x++) {
			map.put(inorder[x], x);
		}
		return dfs(0, inorder.length - 1);
	}

	public TreeNode dfs(int left, int right) {
		if (left > right)
			return null;

		int rootVal = pOrder[this.pIndex];

		int mid = map.get(rootVal);

		pIndex--;
		TreeNode node = new TreeNode(rootVal);
		node.right = dfs(mid + 1, right);
		node.left = dfs(left, mid - 1);
		return node;
	}

}
