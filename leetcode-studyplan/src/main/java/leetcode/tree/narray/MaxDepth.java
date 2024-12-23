package leetcode.tree.narray;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * 
 * 
 */
public class MaxDepth {

	public int maxDepth(Node root) {
		if (root == null)
			return 0;
		Deque<Node> que = new ArrayDeque<>();
		que.add(root);
		int level = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Node removed = que.poll();
				if (removed.children != null)
					for (Node child : removed.children)
						que.add(child);
			}
			level++;
		}
		return level;
	}

}
