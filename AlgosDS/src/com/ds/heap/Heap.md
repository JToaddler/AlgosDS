


https://www.youtube.com/watch?v=HqPJF2L5h9U

Tree Types

	Complete Binary Tree
	
		if we represent a binary tree in an array, there should not be any gaps in between any elements (from first to last)
		No nodes are missing in complete binary tree. ( if a node has only one node, then its not complete binary tree)
		
		A complete binary tree is full binary tree up to h - 1.
		Height of complete binary tree is Log n
		
	Full Binary Tree
		In binary tree with height of h, there are no new space for new node. adding a new node will result in 
		increasing the height of the tree.
		All nodes are there in the last level.

Array Representation of Binary Tree

To convert Tree to array representation, fill element level by level.(level order traversal)

	A Level Order Traversal is a traversal which always traverses based on the level of the tree.

	
If a Node is at ith index

	Left child is at 2 * i  (In 0 based index its = 2 * i + 1)
	Right child is at 2 * i + 1 (In 0 based index its = 2 * i + 2)
	Parent is at floor value of i/2 (In 0 based index its = pos - 1 / 2)

If a full binary tree has height of h, then

	max number of nodes in the tree is, 2^(h+1) - 1

	
	
Heap is complete binary


Max Heap - All child nodes are smaller than the parent nodes.
	
	Insertion -> add new leaf at the end of the tree. and adjustment is done from leaf to root.  ( time comp = Log n)
	Deletion -> delete element from root and move the last leaf to the root. Adjustment is done from root to child.   					(time comp = Log N)
	
Min Heap - all parent nodes are greater than child nodes. 



Creation - n * log n
Deletion - n * log n



Heapify - Procedure for creating a heap.
			O(n)
			
Heap is faster DS for implementing P queue.

Last Non-leaf Node = (n/2) – 1
First Lead Node = Last Non lead node + 1 => n/2
