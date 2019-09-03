package linkedlist;

import common.LinkedList;
import common.nodes.ListNode;

class Solution {

    public ListNode[] separateList(ListNode head) {
        ListNode even, odd, oddHead, evenHead;
        odd = head;
        oddHead = head;
        even = head.next;
        evenHead = even;
        //separate lists into odd-even lists
        while (odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        if (odd.next != null) {
            odd.next = odd.next.next;
        }
//        //print odd
//        odd = oddHead;
//        even = evenHead;

        return new ListNode[]{oddHead, evenHead};
    }
}

public class SeparateList {

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

        ListNode[] nodeArray = new Solution().separateList(myLinkedList.getHead());
        System.out.print("Odd List: ");
        nodeArray[0].printSeqNodes();
        System.out.print("Even List: ");
        nodeArray[1].printSeqNodes();

    }


}