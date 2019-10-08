package leetcode.medium;

// Binary Tree Vertical Order Traversal - LC 314 -> locked

import common.Examples;
import common.nodes.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    // Not working
    public List<List<Integer>> verticalOrderUnaccepted(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        preorder(root, map, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (int level : map.keySet()) {
            result.add(map.get(level));
        }
        //System.out.println(result);
        return result;
    }

    private void preorder(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if (root == null) {
            return;
        }
        List<Integer> ls;
        if (map.containsKey(level)) {
            ls = map.get(level);
        } else {
            ls = new ArrayList<>();
            map.put(level, ls);
        }
        ls.add(root.val);
        preorder(root.left, map, level - 1);
        preorder(root.right, map, level + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        q.add(root);
        cols.add(0);

        int min = 0, max = 0;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) map.put(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) {
                q.add(node.left);
                cols.add(col - 1);
                if (col <= min) min = col - 1;
            }
            if (node.right != null) {
                q.add(node.right);
                cols.add(col + 1);
                if (col >= max) max = col + 1;
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }

    public static void main(String[] args) {

        BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();
        TreeNode root = Examples.getExampleTreeRoot();
        System.out.println(obj.verticalOrder(root));
    }

}
