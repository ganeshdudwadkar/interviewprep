package tree;

import common.Examples;
import common.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    // recursive
    public void inorderTraversal(TreeNode root, List<Integer> ls) {
        if(root==null) return;
        inorderTraversal(root.left,ls);
        ls.add(root.val);
        inorderTraversal(root.right,ls);
    }

    public List<Integer> inorderTraversalNonRec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode top = stack.peek();
            if(top.left!=null){
                stack.push(top.left);
                top.left=null;
            }else{
                result.add(top.val);
                stack.pop();
                if(top.right!=null){
                    stack.push(top.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = Examples.getExampleBSTRoot();
        List<Integer> resultList1 = new ArrayList<>();

        InOrderTraversal obj = new InOrderTraversal();

        obj.inorderTraversal(root, resultList1);
        System.out.println(resultList1);

        List<Integer> resultList2 = obj.inorderTraversalNonRec(root);
        System.out.println(resultList2);
    }

}
