package leetcode.medium;

// - Binary Tree Longest Consecutive Sequence (LC 298) - Locked

/*

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.

 */

import common.nodes.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {

    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        // reset max to 0 always;
        max = 0;
        helper(root, 0, root.val);
        return max;
    }

    private void helper(TreeNode root, int cur, int target){
        if(root == null) return;
        if(root.val == target) cur++;
        else cur = 1;
        max = Math.max(cur, max);
        helper(root.left, cur, root.val + 1);
        helper(root.right, cur, root.val + 1);
    }

    public static void main(String[] args){

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(5);
        root1.right.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(2);
        root2.right.left.left = new TreeNode(1);


        BinaryTreeLongestConsecutiveSequence obj1 = new BinaryTreeLongestConsecutiveSequence();
        // BinaryTreeLongestConsecutiveSequence obj2 = new BinaryTreeLongestConsecutiveSequence();
        System.out.println(obj1.longestConsecutive(root1));

        System.out.println(obj1.longestConsecutive(root2));

    }

}
