package tree;

import common.Examples;
import common.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    // recursive

    public void preorder(TreeNode root, List<Integer> ls){
        if(root==null){
            return;
        }
        ls.add(root.val);
        preorder(root.left,ls);
        preorder(root.right,ls);
    }

    // Non-recursive

    public List<Integer> preorderNonRec(TreeNode root, List<Integer> ls) {

        if(root == null)
            return ls;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode n = stack.pop();
            ls.add(n.val);

            if(n.right != null){
                stack.push(n.right);
            }
            if(n.left != null){
                stack.push(n.left);
            }

        }
        return ls;
    }

    public static void main(String[] args){

        TreeNode root = Examples.getBST();
        List<Integer> resultList1 = new ArrayList<>();
        List<Integer> resultList2 = new ArrayList<>();

        PreOrderTraversal obj = new PreOrderTraversal();

        obj.preorder(root, resultList1);
        System.out.println(resultList1);

        obj.preorder(root, resultList2);
        System.out.println(resultList2);

    }

}
