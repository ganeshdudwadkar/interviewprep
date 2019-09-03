package common.nodes;

public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    private boolean hasCycle() {
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

    private ListNode detectCycle() {
        ListNode slow = this;
        ListNode fast = this;
        boolean cycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                fast = this;//reset fast back to head
                break;
            }
        }
        if (!cycle) {
            return null;
        }
        //now head and slow are equidistant from the cycle start node
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public String getSeqNodesString() {

        ListNode cycle = this.detectCycle();

        if (cycle != null) {
            System.out.println("This Sequence has cycle at " + cycle + "! Cannot Print the list beyond that point!!");
            // return;
        }
        ListNode iter = new ListNode(0);
        iter.next = this;
        String str = "";
        while (iter != cycle && iter.next != null) {
            str += iter.next + " -> ";
            iter = iter.next;
        }
        return str + " NULL";
    }

    public void printSeqNodes() {
        System.out.println(getSeqNodesString());
    }
}
