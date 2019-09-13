package leetcode.easy;

// Moving Average of data stream (LC # 346) - Google

/*

Your MovingAverage object will be instantiated and called as such:
MovingAverage obj = new MovingAverage(size);
double param_1 = obj.next(val);


For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3

 */

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    /**
     * Initialize your data structure here.
     */
    double sum;
    Queue<Integer> q;
    int count;
    int size;

    public MovingAverage(int size) {
        sum = 0;
        count = 0;
        this.size = size;
        q = new LinkedList<>();
    }

    public double next(int val) {
        sum += val;
        if (count < size) {
            count++;
            q.add(val);
            return sum / count;
        }
        sum -= q.remove();
        q.add(val);
        return sum / count;
    }

    public static void main(String[] args){

        MovingAverage obj = new MovingAverage(2);
        System.out.println(obj.next(1));
        System.out.println(obj.next(10));
        System.out.println(obj.next(3));
        System.out.println(obj.next(5));
    }
}
