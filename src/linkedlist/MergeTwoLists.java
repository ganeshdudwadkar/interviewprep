package linkedlist;

import common.LinkedList;
import common.nodes.ListNode;

public class MergeTwoLists {

    public ListNode mergeAlternate(ListNode node1, ListNode node2) {
        ListNode odd = node1;
        ListNode even = node2;

        ListNode temp1;
        //idea is to take head of odd list and merge it into even list as one element addition
        while (odd.next != null && even.next != null) {
            temp1 = odd.next;
            odd.next = even.next;
            even.next = odd;
            even = odd.next;
            odd = temp1;
        }
        if (odd != null) {
            even.next = odd;
        }

        return node2;
    }

    public static void main(String[] args) {
        // ListNode head = new ListNode(10);
        LinkedList myList1 = new LinkedList(10);
        myList1.add(13);
        myList1.add(9);
        myList1.add(12);
        myList1.add(24);
        myList1.add(80);
        myList1.add(123);


        LinkedList myList2 = new LinkedList(3);
        myList2.add(21);
        myList2.add(5);
        myList2.add(7);

        System.out.println(myList1);
        System.out.println(myList2);

        ListNode mergedListHead = new MergeTwoLists().mergeAlternate(myList1.getHead(), myList2.getHead());
        mergedListHead.printSeqNodes();
    }
}
