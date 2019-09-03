package leetcode.medium;

// https://leetcode.com/problems/rotate-list/

/*

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL

 */

import common.Examples;
import common.nodes.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode p1, p2;
        p1 = head;
        p2 = head;
        //calculate length
        int l = 1;
        while (p2.next != null) {
            l++;
            p2 = p2.next;
        }
        p2 = head; // reset back to head
        k = k % l;
        while (k > 0) {
            k--;
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1.next != null) {//rearrange list
            p2.next = head;
            head = p1.next;
            p1.next = null;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = Examples.getLinkedListHead();
        head.printSeqNodes();
        ListNode newHead = new RotateList().rotateRight(head, 3);
        newHead.printSeqNodes();
    }
}
