

Tree 

Binary Tree

Binary Search Tree
	Insertion:
		Compare root value and determine whether it should go to left or right and repeat the comparison.
	Deletion
		Case 1: leaf nodes ( no adjustment required)
		Case 2: Non leaf node. but only one child (1-2-3 to be deleted 1)
		Case 3: key to be deleted has 2 non leaf nodes.
				find the minimum in the right subtree

BFS (level order traversal)
DFS 
	InOrder traversal
	PreOrder traversal
	PostOrder traversal
	
	Repeat all above three in iterative mode


InOrder traversal
	First, visit all the nodes in the left subtree
	Then the root node
	Visit all the nodes in the right subtree
	NOTE : (start from smallest/ deepest node, it like iterating from start index of sorted array )
	
PreOrder traversal
	Visit root node
	Visit all the nodes in the left subtree
	Visit all the nodes in the right subtree

PostOrder traversal
	Visit all the nodes in the left subtree
	Visit all the nodes in the right subtree
	Visit the root node
	
	
AVL Tree

BST can become skewed based on the elements inserted into Tree. So search will become linear  - O(N) instead of O(log N)

A self-balancing tree is a binary search tree that balances the height after insertion and deletion according to some balancing rules.

For BST to be an AVL tree, BST should maintain Balancing Factor. it should be in |-1,0,1|


If BF =  2, then imbalance is on left tree.
If BF = -2, then imbalance is on right tree.

	LL -> LL
	LR -> RL
	RR -> RR
	RL -> RL

