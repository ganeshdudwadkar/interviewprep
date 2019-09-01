package common;

import common.nodes.ListNode;
import common.nodes.TreeNode;

public class Examples {

    public static TreeNode getExampleTreeRoot(){
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(70);
        root.right.right.left = new TreeNode(32);
        root.right.right.right = new TreeNode(45);
        return root;
    }

    public static TreeNode getExampleBSTRoot(){
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);
        root.right.right = new TreeNode(25);
        root.right.right.left = new TreeNode(22);
        root.right.right.right = new TreeNode(30);
        return root;
    }

    public static TreeNode getBalancedTreeRoot(){

        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static ListNode getLinkedListHead(){
        LinkedList myLinkedList = new LinkedList(10);
        myLinkedList.add(13);
        myLinkedList.add(9);
        myLinkedList.add(12);
        myLinkedList.add(24);
        myLinkedList.add(80);
        myLinkedList.add(123);

        // System.out.println(myLinkedList);
        return myLinkedList.getHead();
    }

    public static ListNode getLinkedListHeadWithCycle(){
        ListNode head = getLinkedListHead();
        ListNode iter = head, cycleNode;
        while(iter.next != null){
            iter = iter.next;
        }
        cycleNode = iter;
        iter.next = new ListNode(21);
        iter.next.next = new ListNode(38);
        iter.next.next.next = cycleNode;
        // head.printSeqNodes();
        return head;
    }
}
