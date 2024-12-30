package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.model.TreeNode;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees
 * 
 * 
 * 
 */
public class DuplicateSubTree {

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		Map<String, Integer> map = new HashMap<>();
		List<TreeNode> res = new ArrayList<>();
		helper(root, map, res);
		return res;
	}

	public String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> res) {
		if (node == null) {
			return "";
		}
		String leftStr = helper(node.left, map, res);
		String rightStr = helper(node.right, map, res);

		String subTree = node.val + "," + leftStr + "," + rightStr;
		map.put(subTree, map.getOrDefault(subTree, 0) + 1);
		if (map.get(subTree) == 2) {
			res.add(node);
		}
		return subTree;
	}

}
