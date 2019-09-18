package leetcode.medium;

// https://leetcode.com/problems/delete-node-in-a-bst/

import common.nodes.TreeNode;

/*

450. Delete Node in a BST

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

 */
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        TreeNode prev = null;
        TreeNode iter = root;
        if (root.val == key) { // special case
            return mergeLeft(root.left, root.right);
        }
        boolean isLeftChild = false;
        while (iter != null) {
            if (iter.val == key) {
                if (isLeftChild) {
                    prev.left = mergeLeft(iter.left, iter.right);
                } else {
                    prev.right = mergeLeft(iter.left, iter.right);
                }
                return root;
            }
            prev = iter;
            if (iter.val > key) {
                iter = iter.left;
                isLeftChild = true;
            } else {
                iter = iter.right;
                isLeftChild = false;
            }
        }
        return root;//not found case
    }

    // My Improved version - Beats 100% Java submissions

    public TreeNode deleteNodeImproved(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) { // root is the key
            return mergeLeft(root.left, root.right);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public TreeNode mergeLeft(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null) return rightNode;
        if (rightNode == null) return leftNode;
        TreeNode iterator = rightNode;
        while (iterator.left != null) {
            iterator = iterator.left;
        }
        iterator.left = leftNode;
        return rightNode;
    }
}
