package leetcode.easy;

// https://leetcode.com/problems/house-robber/

/*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class HouseRobber {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = nums[1];
        if (len > 2) {
            dp[2] = nums[2] + dp[0];
        }
        for (int i = 3; i < len; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 2], dp[i - 3]);
        }
        return Math.max(dp[len - 1], dp[len - 2]);
    }

    // Best one ->

    int robII(int num[]) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                a = Math.max(a + num[i], b);
            } else {
                b = Math.max(a, b + num[i]);
            }
        }
        return Math.max(a, b);
    }

    public static void main(String[] args) {

        HouseRobber obj = new HouseRobber();
        System.out.println(obj.rob(new int[]{1, 2, 3, 1}));
        System.out.println(obj.robII(new int[]{2, 7, 9, 3, 1}));

    }
}
