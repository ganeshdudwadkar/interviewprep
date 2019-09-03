package leetcode.easy;

// https://leetcode.com/problems/linked-list-cycle/

/*
141. Linked List Cycle

Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
If pos is -1, then there is no cycle in the linked list.

 */

// https://leetcode.com/problems/linked-list-cycle-ii/

/*

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
If pos is -1, then there is no cycle in the linked list.

 */

import common.Examples;
import common.nodes.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean cycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                fast = head;//reset fast back to head
                break;
            }
        }
        if (!cycle) {
            return null;
        }
        //now head and slow are equidistant from the cycle start node
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {

        ListNode head = Examples.getLinkedListHeadWithCycle();

        LinkedListCycle linkedListCycle = new LinkedListCycle();
        System.out.println(linkedListCycle.hasCycle(head));
        ListNode cycle = linkedListCycle.detectCycle(head);
        if (cycle != null) {
            System.out.println("Cycle starts at : " + cycle);
        }
        head.printSeqNodes();
    }
}
