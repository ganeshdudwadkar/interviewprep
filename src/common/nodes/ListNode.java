package common.nodes;

public class ListNode {

    private int value;
    public ListNode next;

    public ListNode(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public boolean hasCycle() {
        ListNode slow = this;
        ListNode fast = this;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void printSeqNodes(){
        if (this.hasCycle()){
            System.out.println("This Sequence has cycle! Cannot Print!!");
            return;
        }
        ListNode iter = new ListNode(0);
        iter.next = this;
        while (iter.next != null) {
            System.out.print(iter.next + " ");
            iter = iter.next;
        }
        System.out.println();
    }
}
