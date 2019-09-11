package leetcode.hard;

// https://leetcode.com/problems/merge-k-sorted-lists/

/*

23. Merge k Sorted Lists

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

 */

import common.LinkedList;
import common.nodes.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.value - l2.value;
            }
        });

        // Add all the list head elems to the PriorityQueue
        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }

        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;

        while (!queue.isEmpty()) {
            // Add first element of the PQ to sorted list i.e p node
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;

            // Add next element of same list to the PQ
            if (n.next != null)
                queue.offer(n.next);
        }

        return fakeHead.next;
    }

    public static void main(String[] args){

        LinkedList linkedList1 = new LinkedList();
        linkedList1.add(3);
        linkedList1.add(6);
        linkedList1.add(8);
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(1);
        linkedList2.add(2);
        linkedList2.add(7);
        LinkedList linkedList3 = new LinkedList();
        linkedList3.add(4);
        linkedList3.add(5);
        linkedList3.add(9);
        ListNode[] lists = new ListNode[]{linkedList1.getHead(), linkedList2.getHead(), linkedList3.getHead()};
        MergeKSortedLists obj = new MergeKSortedLists();
        obj.mergeKLists(lists).printSeqNodes();


    }

}
