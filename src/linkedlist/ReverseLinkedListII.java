package linkedlist;

// https://leetcode.com/problems/reverse-linked-list-ii/

/*

Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

 */

import common.LinkedList;
import common.nodes.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int c = n - m;
        if (c < 1) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev, mNode, nNode;
        prev = newHead;
        mNode = head;
        while (--m > 0) {
            mNode = mNode.next;
            prev = prev.next;
        }
        //System.out.println("mNode is " + mNode.val);
        nNode = mNode;
        n = c;
        //System.out.println("m " + m + " n " + n);
        while (n-- > 0) {
            nNode = nNode.next;
        }
        //System.out.println("nNode is " + nNode.val);
        while (c-- > 0) {
            //System.out.println("Pointing " + prev.val + " to " + mNode.next.val);
            prev.next = mNode.next;
            //System.out.println("Pointing " + mNode.val + " to " + nNode.next.val);
            mNode.next = nNode.next;
            //System.out.println("Pointing " + nNode.val + " to " + mNode.val);
            nNode.next = mNode;
            //System.out.println("Forwarding mNode to " + prev.val + " to " + mNode.val);
            mNode = prev.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(10);
        LinkedList myLinkedList = new LinkedList(10);
        myLinkedList.add(13);
        myLinkedList.add(9);
        myLinkedList.add(12);
        myLinkedList.add(24);
        myLinkedList.add(80);
        myLinkedList.add(123);

        System.out.println(myLinkedList);

        ReverseLinkedListII reverseLinkedList = new ReverseLinkedListII();

        ListNode myReversedListHead = reverseLinkedList.reverseBetween(myLinkedList.getHead(), 2, 5);
        myReversedListHead.printSeqNodes();

    }

}
