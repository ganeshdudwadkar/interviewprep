package leetcode.medium;

// BinaryTreeLongestConsecutiveSequenceII (LC 549) - locked

/*

Based on the problem I, this might have been asking the entire path to be returned instead of just the value.
So here is the made up description ->

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
Longest consecutive sequence path is 3-4-5, so return 3-4-5.
   2
    \
     3
    /
   2
  /
 1
Longest consecutive sequence path is 2-3, not 3-2-1, so return 2-3.

 */

import common.nodes.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLongestConsecutiveSequenceII {

    // Needs improvement as it adds duplicate lists

    public void longestConsecutive(TreeNode root) {

        List<List<Integer>> resultLs = new ArrayList<>();
        List<Integer> currentls = new ArrayList<>();
        helper(root, root.val, currentls, resultLs);
        System.out.println(resultLs);
        int maxLen = 0;
        List<Integer> maxLs = resultLs.get(0);
        for (List<Integer> ls : resultLs) {
            if (ls.size() > maxLen) {
                maxLs = ls;
            }
        }
        System.out.println(maxLs);
    }

    private void helper(TreeNode root, int target, List<Integer> currentls, List<List<Integer>> resultLs) {
        if (root == null) return;
        List<Integer> tempList;
        if (root.val == target) {
            tempList = currentls;
        } else {
            // add the existing list to result list as it might have the longest seq
            if (!currentls.isEmpty()) resultLs.add(new ArrayList<>(currentls));
            tempList = new ArrayList<>();
        }
        tempList.add(root.val);
        // max = Math.max(cur, max);
        helper(root.left, root.val + 1, tempList, resultLs);
        helper(root.right, root.val + 1, tempList, resultLs);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(3);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(5);
        root1.right.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(2);
        root2.right.left.left = new TreeNode(1);


        BinaryTreeLongestConsecutiveSequenceII obj1 = new BinaryTreeLongestConsecutiveSequenceII();
        obj1.longestConsecutive(root1);
    }
}
