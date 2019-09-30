package common.nodes;

public class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int x) {
        this.val = x;
    }

    public void printInorder() {
        inorder();
        System.out.println();
    }

    private void inorder(){
        if (this.left != null) {
            this.left.inorder();
        }
        System.out.print(val);
        System.out.print(" ");
        if (this.right != null) {
            this.right.inorder();
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.val);
    }
}
