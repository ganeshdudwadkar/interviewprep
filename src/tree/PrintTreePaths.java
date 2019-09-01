package tree;

import java.util.List;
import java.util.ArrayList;

import common.nodes.TreeNode;

class Solution {
    private void dfs(TreeNode root, List<String> ls, String s) {
        //System.out.println("Current at " + root.val + "String is " + s);
        if (s.length() == 0) {
            s = Integer.toString(root.val);
        } else {
            s = s.concat("->").concat(Integer.toString(root.val));
        }

        if (root.left == null && root.right == null) {
            ls.add(s);
            int lastIndex = s.lastIndexOf("->");
            if (lastIndex > 0) {
                s = s.substring(0, lastIndex);
            }
            return;
        }
        if (root.left != null) {
            dfs(root.left, ls, s);
        }
        if (root.right != null) {
            dfs(root.right, ls, s);
        }
        int lastIndex = s.lastIndexOf("->");
        if (lastIndex > 0) {
            s = s.substring(0, lastIndex);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<String>();
        if (root == null) {
            return ls;
        }
        String s = "";
        dfs(root, ls, s);
        return ls;
    }
}

public class PrintTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(32);
        root.right.right.right = new TreeNode(45);

        Solution s = new Solution();
        List<String> resultLs = s.binaryTreePaths(root);
        System.out.println(resultLs);
    }
}

