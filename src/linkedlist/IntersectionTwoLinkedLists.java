package linkedlist;

// https://leetcode.com/problems/intersection-of-two-linked-lists/

/*

Write a program to find the node at which the intersection of two singly linked lists begins.

 */

import common.nodes.ListNode;

public class IntersectionTwoLinkedLists {

    public ListNode getIntersectionNodeOld(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        if (headA == headB ){//same lists
            return headA;
        }
        ListNode iteratorA = headA;
        ListNode iteratorB = headB;
        //get the length of both the lists
        int lenA = 1;
        int lenB = 1;
        while(iteratorA.next != null){
            lenA++;
            iteratorA = iteratorA.next;
        }
        while(iteratorB.next != null){
            lenB++;
            iteratorB = iteratorB.next;
        }
        if (iteratorA != iteratorB){ //no intersection
            return null;
        }
        //reset iterators
        iteratorA = headA;
        iteratorB = headB;
        int diff;
        if (lenA > lenB){
            diff = lenA - lenB;
            for(int i = 0; i< diff ; i++){
                iteratorA = iteratorA.next;
            }
        } else if (lenB > lenA ) {
            diff = lenB - lenA;
            for(int i = 0; i< diff ; i++){
                iteratorB = iteratorB.next;
            }
        }
        while(iteratorA != iteratorB){
            iteratorA = iteratorA.next;
            iteratorB = iteratorB.next;
        }
        return iteratorA;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration (how?)
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    
}
