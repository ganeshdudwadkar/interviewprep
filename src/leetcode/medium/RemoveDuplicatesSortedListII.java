package leetcode.medium;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

/*

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

 */

import common.LinkedList;
import common.nodes.ListNode;

public class RemoveDuplicatesSortedListII {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.value == head.next.value) {
            while (head.next != null && head.value == head.next.value) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
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
