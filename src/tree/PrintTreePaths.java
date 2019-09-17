package tree;

import java.util.List;
import java.util.ArrayList;

import common.Examples;
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
        List<String> ls = new ArrayList<>();
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
        TreeNode root = Examples.getExampleTreeRoot();
        root.print_inorder();
        Solution s = new Solution();
        List<String> resultLs = s.binaryTreePaths(root);
        System.out.println(resultLs);
    }
}

