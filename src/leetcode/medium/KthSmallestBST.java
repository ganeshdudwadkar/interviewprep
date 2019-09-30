package leetcode.medium;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

 */

import common.nodes.TreeNode;

public class KthSmallestBST {

    int res = Integer.MIN_VALUE;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraverse(root, k);
        return res;
    }

    private void inOrderTraverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inOrderTraverse(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        inOrderTraverse(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);
        root.right.right = new TreeNode(25);
        root.right.right.left = new TreeNode(22);
        root.right.right.right = new TreeNode(30);
        root.printInorder();
        System.out.println();
        KthSmallestBST solution = new KthSmallestBST();
        System.out.println(solution.kthSmallest(root, 3));

    }

}
