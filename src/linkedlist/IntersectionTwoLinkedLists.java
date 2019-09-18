package linkedlist;

// https://leetcode.com/problems/intersection-of-two-linked-lists/

/*

Write a program to find the node at which the intersection of two singly linked lists begins.

 */

import common.nodes.ListNode;

public class IntersectionTwoLinkedLists {

    public ListNode getIntersectionNodeOld(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {//same lists
            return headA;
        }
        ListNode iteratorA = headA;
        ListNode iteratorB = headB;
        //get the length of both the lists
        int lenA = 1;
        int lenB = 1;
        while (iteratorA.next != null) {
            lenA++;
            iteratorA = iteratorA.next;
        }
        while (iteratorB.next != null) {
            lenB++;
            iteratorB = iteratorB.next;
        }
        if (iteratorA != iteratorB) { //no intersection
            return null;
        }
        //reset iterators
        iteratorA = headA;
        iteratorB = headB;
        int diff;
        if (lenA > lenB) {
            diff = lenA - lenB;
            for (int i = 0; i < diff; i++) {
                iteratorA = iteratorA.next;
            }
        } else if (lenB > lenA) {
            diff = lenB - lenA;
            for (int i = 0; i < diff; i++) {
                iteratorB = iteratorB.next;
            }
        }
        while (iteratorA != iteratorB) {
            iteratorA = iteratorA.next;
            iteratorB = iteratorB.next;
        }
        return iteratorA;
    }

    /*

    I found most solutions here preprocess linkedlists to get the difference in len.
    Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the intersection node at the same time.
    We can use two iterations to do that. In the first iteration, we will reset the pointer of one linkedlist to the head of another linkedlist
    after it reaches the tail node. In the second iteration, we will move two pointers until they points to the same node.
    Our operations in first iteration will help us counteract the difference. So if two linkedlist intersects, the meeting point in second
    iteration must be the intersection point. If the two linked lists have no intersection at all, then the meeting pointer in second iteration
    must be the tail node of both lists, which is null.

     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if (headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration (how?)
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(5);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(7);
        head1.next.next.next = new ListNode(9); // interecting node
        head2.next = new ListNode(8);
        head2.next.next = head1.next.next.next;
        head2.next.next.next = new ListNode(10);
        head1.printSeqNodes();
        head2.printSeqNodes();
        IntersectionTwoLinkedLists inter = new IntersectionTwoLinkedLists();
        ListNode node = inter.getIntersectionNode(head1, head2);
        System.out.println(node);
    }
}
