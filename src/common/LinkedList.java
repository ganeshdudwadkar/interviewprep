package common;

import common.nodes.ListNode;

public class LinkedList {

    private ListNode head, tail;

    public LinkedList(){}

    public LinkedList(int val) {
        this.head = new ListNode(val);
        this.tail = head;
    }

    public ListNode getHead(){
        return this.head;
    }
    // adds new node at the end
    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            this.head = newNode;
            this.tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // removes node with given value - no duplicate removals
    public void remove(int val) {
        if (head == null) return;
        if (head.getValue() == val) {
            head = null;
            tail = null;
            return;
        }

        ListNode iter = head, prev;

        while (iter.next != null) {
            prev = iter;
            iter = iter.next;
            if (iter.getValue() == val) {
                prev.next = iter.next;
                if (iter == tail) {
                    tail = prev;
                }
                return;
            }
        }
    }

    // covert linked list elements to string
    public String toString(){

        return head.getSeqNodesString();
    }

}
