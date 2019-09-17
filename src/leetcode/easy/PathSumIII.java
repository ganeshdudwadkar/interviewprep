package leetcode.easy;

// https://leetcode.com/problems/path-sum-iii/

/*

437. Path Sum III

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

 */

import common.nodes.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        int paths = 0;
        if (root == null) return 0;
        paths += pathSumFrom(root, sum) + pathSum(root.right, sum) + pathSum(root.left, sum);
        return paths;
    }

    private int pathSumFrom(TreeNode root, int sum){
        if (root == null) return 0;
        int paths = 0;
        if (root.val == sum) paths = 1;
        paths += pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
        return paths;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right =  new TreeNode(2);
        root.left.right.right =  new TreeNode(1);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(11);
        PathSumIII obj = new PathSumIII();
        System.out.println(obj.pathSum(root, 8));
    }
}
