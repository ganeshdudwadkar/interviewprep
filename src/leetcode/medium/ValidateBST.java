package leetcode.medium;

// https://leetcode.com/problems/validate-binary-search-tree/

/*

98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false

 */

import common.Examples;
import common.nodes.TreeNode;

import java.util.Stack;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    // Alternative O(nlogn) space
    public boolean isValidBSTAlternate(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode p = stack.pop();
                if (pre != null && p.val <= pre.val) {
                    return false;
                }
                pre = p;
                cur = p.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        ValidateBST obj = new ValidateBST();
        System.out.println(obj.isValidBST(Examples.getExampleTreeRoot()));
        System.out.println(obj.isValidBST(Examples.getExampleBSTRoot()));

        System.out.println(obj.isValidBSTAlternate(Examples.getExampleTreeRoot()));
        System.out.println(obj.isValidBSTAlternate(Examples.getExampleBSTRoot()));
    }
}
