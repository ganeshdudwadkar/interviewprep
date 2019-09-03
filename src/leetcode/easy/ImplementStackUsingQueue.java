package leetcode.easy;

// https://leetcode.com/problems/implement-stack-using-queues/

/*

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false

 */

import java.util.LinkedList;
import java.util.List;

class MyStack {
    List<Integer> list = new LinkedList<>();
    int top;

    // Push element x onto stack.
    public void push(int x) {
        list.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public int pop() {
        //add back all the front elements at the end except last one
        int elem;
        for (int i = 0; i < list.size() - 1; i++) {
            elem = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            push(elem);
        }
        elem = list.get(list.size() - 1);
        list.remove(list.size() - 1); //remove the top which is now at the front
        return elem;
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return list.size() == 0;
    }
}

public class ImplementStackUsingQueue {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
        System.out.println(stack.pop());   // returns 1
        System.out.println(stack.empty()); // returns true
    }
}
