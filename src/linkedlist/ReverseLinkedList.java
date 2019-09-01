package linkedlist;

// https://leetcode.com/problems/reverse-linked-list/

/*

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

 */

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
        LinkedList myLinkedList = new LinkedList(10);
        myLinkedList.add(13);
        myLinkedList.add(9);
        myLinkedList.add(12);
        myLinkedList.add(24);
        myLinkedList.add(80);
        myLinkedList.add(123);

        System.out.println(myLinkedList);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode myReversedListHead = reverseLinkedList.reverseList(myLinkedList.getHead());
        myReversedListHead.printSeqNodes();

        ListNode restoredListHead = reverseLinkedList.reverseList(myReversedListHead);
        restoredListHead.printSeqNodes();

    }
}


