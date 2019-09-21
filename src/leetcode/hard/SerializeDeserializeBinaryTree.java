package leetcode.hard;

import common.Examples;
import common.nodes.TreeNode;

public class SerializeDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return String.valueOf(root.val) + " " + serialize(root.left) + " " + serialize(root.right);
    }

    int desPos;

    public TreeNode deserialize(String data) {
        desPos = -1;
        return desHelper(data.split(" "));
    }

    private TreeNode desHelper(String[] strs) {
        desPos++;
        if (strs[desPos].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[desPos]));
        node.left = desHelper(strs);
        node.right = desHelper(strs);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = Examples.getExampleTreeRoot();
        root.print_inorder();
        System.out.println();
        SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();

        String serializedTree = obj.serialize(root);
        System.out.println(serializedTree);
        TreeNode treeNode = obj.deserialize(serializedTree);
        treeNode.print_inorder();
    }
}
