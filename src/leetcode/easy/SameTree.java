package leetcode.easy;

// https://leetcode.com/problems/same-tree/

/*

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false

 */

import common.Examples;
import common.nodes.TreeNode;

// compare structure and values

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        SameTree obj = new SameTree();
        TreeNode bstRoot = Examples.getExampleBSTRoot();
        TreeNode btRoot = Examples.getExampleTreeRoot();
        System.out.println(obj.isSameTree(bstRoot, bstRoot));
        System.out.println(obj.isSameTree(bstRoot, btRoot));
    }
}
