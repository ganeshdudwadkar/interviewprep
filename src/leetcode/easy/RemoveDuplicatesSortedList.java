package leetcode.easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

 */

import common.LinkedList;
import common.nodes.ListNode;

public class RemoveDuplicatesSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode iterator = head;
        while (iterator.next != null) {
            if (iterator.value == iterator.next.value) iterator.next = iterator.next.next;
            else {
                iterator = iterator.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(21);
        myLinkedList.add(21);
        myLinkedList.add(22);
        myLinkedList.add(41);
        myLinkedList.add(41);
        myLinkedList.add(82);

        ListNode head = myLinkedList.getHead();
        head.printSeqNodes();
        ListNode newHead = deleteDuplicates(head);
        newHead.printSeqNodes();
    }
}
