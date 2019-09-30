package interviews;

import common.nodes.TreeNode;

public class InorderSuccessorInBST {

    public TreeNode getInorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while (root != null) {
            if (root.val == p.val) {
                if (root.right == null) return ans;
                return rightMin(root.right);
            } else if (root.val > p.val) {
                ans = root; // saved parent as it is higher than the key & could be the successor if right side is null
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }

    private TreeNode rightMin(TreeNode root) {
        while (root != null) {
            if (root.left == null) return root;
            root = root.left;
        }
        return null;
    }

    public TreeNode inorderSuccessorRecursive(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (p.val >= root.val) {
            return inorderSuccessorRecursive(root.right, p);
        } else {
            TreeNode left = inorderSuccessorRecursive(root.left, p);
            if (left != null)
                return left;
            else
                return root;
        }
    }

    public TreeNode inorderSuccessorAlternate(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        // Construct BST which will have all the scenarios
        TreeNode root = new TreeNode(13);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(8);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.right = new TreeNode(7);
        root.left.right = new TreeNode(11);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(12);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(18);
        root.printInorder();

        InorderSuccessorInBST obj = new InorderSuccessorInBST();
        TreeNode ans = obj.getInorderSuccessor(root, new TreeNode(12));
        System.out.println(ans);

    }
}
