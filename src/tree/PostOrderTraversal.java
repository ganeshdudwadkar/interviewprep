package tree;

import common.Examples;
import common.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    // recursive
    public void postorderTraversal(TreeNode root, List<Integer> ls) {
        if (root == null) return;
        postorderTraversal(root.left, ls);
        postorderTraversal(root.right, ls);
        ls.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.left == null && temp.right == null) {
                TreeNode pop = stack.pop();
                res.add(pop.val);
            } else {
                if (temp.right != null) {
                    stack.push(temp.right);
                    temp.right = null;
                }

                if (temp.left != null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        TreeNode root = Examples.getExampleBSTRoot();
        List<Integer> resultList1 = new ArrayList<>();

        PostOrderTraversal obj = new PostOrderTraversal();

        // recursive
        obj.postorderTraversal(root, resultList1);
        System.out.println(resultList1);

        // non-recursive
        List<Integer> resultList2 = obj.postorderTraversal(root);
        System.out.println(resultList2);
    }
}
