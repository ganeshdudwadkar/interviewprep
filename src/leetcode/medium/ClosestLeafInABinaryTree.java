package leetcode.medium;

// https://leetcode.com/problems/closest-leaf-in-a-binary-tree/

/*

Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.

Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The nearest leaf node is the root node itself.

Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.

 */

import common.nodes.TreeNode;

public class ClosestLeafInABinaryTree {

    private int val = 0;
    private int steps = 0;

    public int findClosestLeaf(TreeNode root, int k) {
        dfs(root, k, 0);
        return val;
    }

    private int dfs(TreeNode root, int k, int depth) {
        if (root != null) {
            if (root.val == k) {
                // DFS to leaves from this node
                dfsFromNode(root, 0);
                return 1;
            } else {
                // Continue trying to find
                int leftSubtree = dfs(root.left, k, depth + 1);
                int rightSubtree = dfs(root.right, k, depth + 1);
                if (leftSubtree != -1) {
                    if (root.right != null) dfsFromNode(root.right, ++leftSubtree);
                    return leftSubtree;
                } else if (rightSubtree != -1) {
                    if (root.left != null) dfsFromNode(root.left, ++rightSubtree);
                    return rightSubtree;
                }
            }
        }
        return -1;
    }

    private void dfsFromNode(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (val == 0) {
                val = root.val;
                steps = depth;
            } else if (depth < steps) {
                val = root.val;
                steps = depth;
            }
        } else {
            if (root.left != null) dfsFromNode(root.left, depth + 1);
            if (root.right != null) dfsFromNode(root.right, depth + 1);
        }
    }
}
