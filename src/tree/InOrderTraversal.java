package tree;

import common.Examples;
import common.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    // recursive
    public void inorderTraversal(TreeNode root, List<Integer> ls) {
        if(root==null) return;
        inorderTraversal(root.left,ls);
        ls.add(root.val);
        inorderTraversal(root.right,ls);
    }

    public static void main(String[] args) {

        TreeNode root = Examples.getExampleBSTRoot();
        List<Integer> resultList1 = new ArrayList<>();
        // List<Integer> resultList2 = new ArrayList<>();

        InOrderTraversal obj = new InOrderTraversal();

        obj.inorderTraversal(root, resultList1);
        System.out.println(resultList1);
    }

}
