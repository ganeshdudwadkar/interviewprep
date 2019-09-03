package leetcode.medium;

// https://leetcode.com/problems/kth-largest-element-in-an-array/

/*

Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4

 */

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementArray {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<>(k);
        for (int i : nums) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {

        KthLargestElementArray obj = new KthLargestElementArray();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(obj.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }
}
