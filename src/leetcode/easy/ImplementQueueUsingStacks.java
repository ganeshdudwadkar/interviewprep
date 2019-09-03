package leetcode.easy;

// https://leetcode.com/problems/implement-queue-using-stacks/

/*

Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 */

import java.util.Stack;

class MyQueue {
    private Stack<Integer> curStack = new Stack<>();
    private Stack<Integer> tempStack = new Stack<>();
    private int peek;

    // Push element x to the back of queue.
    public void push(int x) {
        curStack.push(x);
        if (curStack.size() == 1) {
            peek = x;
        }
    }

    // Removes the element from in front of queue.
    public int pop() {
        while (curStack.size() > 0) {
            tempStack.push(curStack.pop());
        }
        int elem = tempStack.pop();
        while (tempStack.size() > 0) {
            curStack.push(tempStack.pop());
            if (curStack.size() == 1) {
                peek = curStack.peek();
            }
        }
        return elem;
    }

    // Get the front element.
    public int peek() {
        return peek;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return curStack.size() == 0;
    }

}

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
        System.out.println(queue.pop());   // returns 2
        System.out.println(queue.empty()); // returns true
    }

}
