package leetcode.easy;

// https://leetcode.com/problems/palindrome-linked-list/

/*

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?

 */

import common.Examples;
import common.nodes.ListNode;

import java.util.Stack;

public class PalindromeLinkedlist {

    public boolean isPalindromeBasic(ListNode head) {
        if (head == null){//empty
            return true;
        }
        if (head.next == null){//only one elem
            return true;
        }
        // below solution also works but not efficient
        /*
        ListNode p1 = head;
        ListNode temp = new ListNode(0);
        while(p1.next!=null){
            temp = p1;//preserve previous
            p1 = p1.next;
        }
        if (p1.val != head.val){//compare last
            return false;
        } else {
            temp.next = null;//remove last
            return isPalindrome(head.next);//send reduced list
        }
        */
        ListNode slow = head, fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Integer> stack = new Stack<Integer>();
        while(slow!=null){
            stack.push(slow.value);
            slow=slow.next;
        }
        //System.out.println(stack);
        int t;
        while(!stack.isEmpty()){
            t = stack.pop();
            if(head.value!=t){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;

        slow = reverse(slow);
        while (slow != null && head.value == slow.value) {
            head = head.next;
            slow = slow.next;
        }
        return slow == null;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // another recursive solution - from java-questions.com
    // but not working

    private ListNode left;

    public boolean isPalindromeAlternate(ListNode head) {
        left = head;
        return checkValue(head);
    }

    private boolean checkValue(ListNode right) {
        if (right == null)
            return true;
        System.out.println("Inside " + left.value + " " + right.value);
        boolean val = checkValue(right.next);
        if (!val)
            return false;
        boolean v = left.value == right.value;
        left = left.next;
        return v;
    }

    public boolean isPalindromeAlternateII(ListNode head) {
        return checkValue(head, head, 0);
    }

    private boolean checkValue(ListNode left, ListNode right, int i) {
        if (right == null)
            return true;
        System.out.println("i " + i);
        System.out.println("Inside " + left.value + " " + right.value);
        /*
        if (right.next == null){
            System.out.println("Calling " + left.value + " null");
        } else {
            System.out.println("Calling " + left.value + " " + right.next.value);
        }*/
        boolean val = checkValue(left, right.next, i+1);
        if (!val)
            return false;
        System.out.println("Comparing " + left.value + " " + right.value);
        boolean v = left.value == right.value;
        left = left.next;
        return v;
    }

    public static void main(String[] args){

        PalindromeLinkedlist obj = new PalindromeLinkedlist();
        ListNode head = Examples.getLinkedListHead();
        head.printSeqNodes();
        System.out.println(obj.isPalindrome(head));
        //System.out.println(obj.isPalindromeAlternate(head));
        System.out.println(obj.isPalindromeAlternateII(head));

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(1);
        head1.next.next.next.next.next = new ListNode(5);

        head1.printSeqNodes();
        System.out.println(obj.isPalindrome(head1));
        //System.out.println(obj.isPalindromeAlternate(head1));
        System.out.println(obj.isPalindromeAlternateII(head1));

    }

}
