package leetcode.medium;

class cNode{
    int val;
    cNode next;
    public cNode(int val){
        this.val = val;
    }
}

class MyCircularQueue {

    /** Initialize your data structure here. Set the size of the queue to be k. */
    private final int MAX_SIZE;
    private int curSize;
    private cNode front;
    private cNode rear;
    public MyCircularQueue(int k) {
        this.MAX_SIZE = k;
        this.curSize = 0;
        front = null;
        rear = null;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.isFull()) return false;
        cNode temp = new cNode(value);
        if (this.isEmpty()){
            front = temp;
            rear = temp;
            front.next = rear;
            rear.next = front;
        } else {
            rear.next = temp;
            temp.next = front;
            rear = temp;
        }
        curSize++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.isEmpty()) return false;
        curSize--;
        front = front.next;
        rear.next = front;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.isEmpty()) return -1;
        return front.val;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (this.isEmpty()) return -1;
        return rear.val;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return curSize == MAX_SIZE;
    }

    public static void main(String[] args){
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(5));
        System.out.println(obj.enQueue(6));
        System.out.println(obj.enQueue(7));
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.isFull());
        System.out.println(obj.enQueue(7));
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.deQueue());
        System.out.println(obj.isEmpty());
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
