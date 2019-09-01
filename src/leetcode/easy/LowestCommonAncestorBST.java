package leetcode.easy;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

/*

235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 */

import common.Examples;
import common.nodes.TreeNode;

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null || root == null){
            return null;
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor (root.left, p , q);
        }
        else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor (root.right, p , q);
        }
        else {
            return root;
        }
    }

    public static void main(String[] args){

        TreeNode bstRoot = Examples.getExampleBSTRoot();
        LowestCommonAncestorBST obj = new LowestCommonAncestorBST();
        System.out.println(obj.lowestCommonAncestor(bstRoot, bstRoot.left.left, bstRoot.right));
        System.out.println(obj.lowestCommonAncestor(bstRoot, bstRoot.right, bstRoot.right.right));
    }
}
