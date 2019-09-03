package leetcode.medium;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/*

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

 */

import common.Examples;
import common.nodes.ListNode;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveNodeFromEnd {

    private static final Logger LOGGER = Logger.getLogger(RemoveNodeFromEnd.class.getName());

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p1, p2;
        p1 = head;
        p2 = head;
        while (p2.next != null && n > 0) {
            n--;
            p2 = p2.next;
        }

        LOGGER.log(Level.INFO, "n is " + n);
        LOGGER.log(Level.INFO, "p2 is " + p2.value);

        if (n > 1) {//not enough elements
            return head;
        }
        if (n == 1) {//remove head
            return head.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        LOGGER.log(Level.INFO, "P1 is at " + p1.value);
        if (p1.next != null) {
            p1.next = p1.next.next;
        } else {
            p1 = null;//last element?
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNodeFromEnd obj = new RemoveNodeFromEnd();
        ListNode head = Examples.getLinkedListHead();
        head.printSeqNodes();
        // ListNode newHead = obj.removeNthFromEnd(head, 2);
        ListNode newHead = obj.removeNthFromEnd(head, 7);
        newHead.printSeqNodes();

    }
}
