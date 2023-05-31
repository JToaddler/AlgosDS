

Tree 

Binary Tree

Binary Search Tree
	
	


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
	
PreOrder traversal
	Visit root node
	Visit all the nodes in the left subtree
	Visit all the nodes in the right subtree

PostOrder traversal
	Visit all the nodes in the left subtree
	Visit all the nodes in the right subtree
	Visit the root node
	
	
AVL Tree

A self-balancing tree is a binary search tree that balances the height after insertion and deletion according to some balancing rules.

For BST to be an AVL tree, BST should maintain Balancing Factor. it should be in |-1,0,1|

If BF =  2, then imbalance is on left tree.
If BF = -2, then imbalance is on right tree.

	LL -> LL
	LR -> RL
	RR -> RR
	RL -> RL

