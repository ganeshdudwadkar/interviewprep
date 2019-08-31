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

    public void printSeqNodes(){
        ListNode iter = new ListNode(0);
        iter.next = this;
        while (iter.next != null) {
            System.out.print(iter.next + " ");
            iter = iter.next;
        }
        System.out.println();
    }
}
