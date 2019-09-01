package leetcode.medium;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/*

236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 */

import common.Examples;
import common.nodes.TreeNode;

public class LowestCommonAncestorBinaryTree {

    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        TreeNode left, right;
        if (root == null)
            return root;
        if (root == a || root == b)
            return root;
        left = LCA(root.left, a, b);
        right = LCA(root.right, a, b);
        if (left != null && right != null)
            return root;// nodes are each on a separate branch
        else
            return (left != null ? left : right);
        // either one node is on one branch,
        // or none was found in any of the branches
    }

    public static void main(String[] args){

        LowestCommonAncestorBinaryTree obj = new LowestCommonAncestorBinaryTree();
        TreeNode root = Examples.getExampleTreeRoot();
        System.out.println(obj.LCA(root, root.left.right, root.right.right));
        System.out.println(obj.LCA(root, root.right.left, root.right.right));
    }

}
