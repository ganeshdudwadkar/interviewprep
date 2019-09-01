package leetcode.medium;

// https://leetcode.com/problems/path-sum-ii/

/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

 */

import common.Examples;
import common.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    private void preOrderT(TreeNode root, List<List<Integer>> mls, List<Integer> ls, int sum){ //preorder traverse
        if(root==null){
            return;
        }
        if(root.left == null && root.right == null && root.val==sum){
            List<Integer> copyls = new ArrayList<>(ls);
            copyls.add(root.val);
            mls.add(copyls);
            return;
        }
        ls.add(root.val);
        preOrderT(root.left,mls,ls,sum-root.val);
        preOrderT(root.right,mls,ls,sum-root.val);
        ls.remove(ls.size()-1);//remove last
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> mls = new ArrayList<>();
        List<Integer> ls = new ArrayList<Integer>();
        preOrderT(root,mls,ls,sum);
        return mls;
    }

    public static void main(String[] args){

        TreeNode root = Examples.getExampleTreeRoot();
        root.left.right = new TreeNode(13);
        PathSumII pathSumII = new PathSumII();
        List<List<Integer>> result = pathSumII.pathSum(root, 33);
        System.out.println(result);
    }

}
