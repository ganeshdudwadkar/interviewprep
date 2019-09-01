package linkedlist;

// https://leetcode.com/problems/reverse-linked-list/

/*

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

 */

import common.Examples;
import common.LinkedList;
import common.nodes.ListNode;

public class ReverseLinkedList {

    public ListNode reverseListRecursive(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reversedList = head;
        ListNode remainingList = head.next;

        head.next = null; //head now becomes last node of reversedList
        ListNode temp;

        while (remainingList != null) {
            temp = remainingList;
            remainingList = remainingList.next;
            temp.next = reversedList;
            reversedList = temp; //temp becomes new head
        }

        return reversedList;
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(10);

        ListNode head = Examples.getLinkedListHead();

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode myReversedListHead = reverseLinkedList.reverseList(head);
        myReversedListHead.printSeqNodes();

        ListNode restoredListHead = reverseLinkedList.reverseList(myReversedListHead);
        restoredListHead.printSeqNodes();

    }
}


