package leetcode.easy;

// https://leetcode.com/problems/maximum-subarray/

/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */

public class MaximumContiguosSubArray {

    public int maxSubArray(int[] nums) {
        int cur_max, global_max;
        cur_max = nums[0];
        global_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur_max < 0) {
                cur_max = nums[i];
            } else {
                cur_max += nums[i];
            }
            global_max = Math.max(global_max, cur_max);
        }
        return global_max;
    }

    public static void main(String[] args) {

        MaximumContiguosSubArray obj = new MaximumContiguosSubArray();
        int[] input = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(obj.maxSubArray(input));
        System.out.println(obj.maxSubArray(new int[]{-8, -7, -2, -1, -9, -111}));

    }
}
