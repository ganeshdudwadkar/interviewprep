package leetcode.easy;

// - https://leetcode.com/problems/diameter-of-binary-tree/

/*

543. Diameter of Binary Tree

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

 */

import common.nodes.TreeNode;

public class DiameterOfABinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int curDiameter = maxDepth(root.left) + maxDepth(root.right);
        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);
        return Math.max(curDiameter, Math.max(leftD, rightD));
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + maxDepth(root.left) + maxDepth(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        System.out.println(new DiameterOfABinaryTree().diameterOfBinaryTree(root));
    }
}
