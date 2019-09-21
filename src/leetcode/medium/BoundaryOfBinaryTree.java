package leetcode.medium;

// - https://leetcode.com/problems/boundary-of-binary-tree/

/*

545. Boundary of Binary Tree

Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1

Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].

 */

import common.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        if (root != null) {
            ls.add(root.val);
            lookupElems(root.left, ls, true, false);
            lookupElems(root.right, ls, false, true);
        }
        return ls;
    }

    private void lookupElems(TreeNode root, List<Integer> ls, boolean isLeftBoundary, boolean isRightBoundary) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ls.add(root.val);
            return;
        }
        if (isLeftBoundary) {
            ls.add(root.val);
        }
        lookupElems(root.left, ls, root.left != null && isLeftBoundary, root.right == null && isRightBoundary);
        lookupElems(root.right, ls, root.left == null && isLeftBoundary, root.right != null && isRightBoundary);
        if (isRightBoundary) {
            ls.add(root.val);
        }
    }
}


/*

https://leetcode.com/problems/boundary-of-binary-tree/discuss/101288/java-recursive-solution-beats-94

I came up with this recursive solution. I saw some iterative solutions by others but felt the same tree is iterated 3 times to find left boundary, right boundary and leaves. This one does it in one iteration and is self explanatory and finishes in 11ms. I am giving all three solutions to understand how I compressed the code in each round but they all works fine and accepted by OJ.

First hand solution

public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root!=null){
            ls.add(root.val);
            lookupElems(root.left,ls,true,false);
            lookupElems(root.right,ls,false,true);
        }
        return ls;
    }

    private void lookupElems(TreeNode root,List<Integer> ls,boolean isLeftBoundary,boolean isRightBoundary){
        if (root==null) return;
        if (root.left==null && root.right==null) {
            ls.add(root.val);
            return;
        }
        if (isLeftBoundary) {
            ls.add(root.val);
            if(root.left!=null) {
                lookupElems(root.left,ls,true,false);
                lookupElems(root.right,ls,false,false);
            }
            else if (root.right!=null){
                lookupElems(root.right,ls,true,false);
            }
            return;
        }
        if(!isLeftBoundary && !isRightBoundary){
            lookupElems(root.left,ls,false,false);
            lookupElems(root.right,ls,false,false);
            return;
        }
        if (isRightBoundary) {
            if(root.right!=null) {
                lookupElems(root.left,ls,false,false);
                lookupElems(root.right,ls,false,true);
            }
            else if (root.left!=null){
                lookupElems(root.left,ls,false,true);
            }
            ls.add(root.val);
        }
    }
}

Second Round Compression

public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root!=null){
            ls.add(root.val);
            lookupElems(root.left,ls,true,false);
            lookupElems(root.right,ls,false,true);
        }
        return ls;
    }

    private void lookupElems(TreeNode root,List<Integer> ls,boolean isLeftBoundary,boolean isRightBoundary){
        if (root==null) return;
        if (root.left==null && root.right==null) {
            ls.add(root.val);
            return;
        }
        if (isLeftBoundary) {
            ls.add(root.val);
            lookupElems(root.left,ls,root.left!=null,false);
            lookupElems(root.right,ls,root.left==null,false);
            return;
        }
        if (!isLeftBoundary && !isRightBoundary){
            lookupElems(root.left,ls,false,false);
            lookupElems(root.right,ls,false,false);
            return;
        }
        if (isRightBoundary) {
            lookupElems(root.left,ls,false,root.right==null);
            lookupElems(root.right,ls,false,root.right!=null);
            ls.add(root.val);
        }
    }
}

Final Compression to look more elegant but it looks little complex :D

public class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        if(root!=null){
            ls.add(root.val);
            lookupElems(root.left,ls,true,false);
            lookupElems(root.right,ls,false,true);
        }
        return ls;
    }

    private void lookupElems(TreeNode root,List<Integer> ls,boolean isLeftBoundary,boolean isRightBoundary){
        if (root==null) {
            return;
        }
        if (root.left==null && root.right==null) {
            ls.add(root.val);
            return;
        }
        if (isLeftBoundary) {
            ls.add(root.val);
        }
        lookupElems(root.left,ls,root.left!=null && isLeftBoundary,root.right==null && isRightBoundary);
        lookupElems(root.right,ls,root.left==null && isLeftBoundary,root.right!=null && isRightBoundary);
        if (isRightBoundary) {
            ls.add(root.val);
        }
    }
}

Hope you like it! :-)

 */