package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import leetcode.model.TreeNode;

public class BSTIterator {

	int index;
	int size = 0;
	List<Integer> list = new ArrayList<>();

	public BSTIterator(TreeNode root) {
		list.add(-1);
		inOrder(root);
	}

	public void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		size++;
		list.add(root.val);
		inOrder(root.right);
	}

	/**
	 * O(1)
	 */
	public int next() {
		--size;
		return list.get(++index);
	}

	/**
	 * O(1)
	 */
	public boolean hasNext() {
		return size > 0;
	}
}