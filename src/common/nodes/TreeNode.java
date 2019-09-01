package common.nodes;

public class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int x){
        this.val = x;
    }

    public void print_inorder(){
        if (this.left != null){
            this.left.print_inorder();
        }
        System.out.print(val);
        System.out.print(" ");
        if (this.right != null){
            this.right.print_inorder();
        }
    }
}
