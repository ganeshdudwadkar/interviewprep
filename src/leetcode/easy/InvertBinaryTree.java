package leetcode.easy;

// https://leetcode.com/problems/invert-binary-tree/

/*

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */

import common.Examples;
import common.nodes.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {

        TreeNode root = Examples.getExampleBSTRoot();
        root.printInorder();
        System.out.println();

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTree(root);

        root.printInorder();
    }
}
