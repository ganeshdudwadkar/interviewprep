package leetcode.easy;

// https://leetcode.com/problems/balanced-binary-tree/

/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

 */

import common.Examples;
import common.nodes.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(depth(root.left) - depth(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    public static void main(String[] args) {

        TreeNode rootUnBalanced = Examples.getExampleBSTRoot();
        System.out.println(new BalancedBinaryTree().isBalanced(rootUnBalanced));
        TreeNode rootBalanced = Examples.getBalancedTreeRoot();
        System.out.println(new BalancedBinaryTree().isBalanced(rootBalanced));
    }
}
