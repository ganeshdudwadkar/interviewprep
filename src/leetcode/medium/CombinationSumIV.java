package leetcode.medium;

// https://leetcode.com/problems/combination-sum-iv/

/*

Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.

 */

import java.util.Arrays;

public class CombinationSumIV {

    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    // correct recursive solution but not efficient for larger inputs and gives TLE on leetcode
    public int combinationSumIV(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += combinationSumIV(nums, target - nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args){

        CombinationSumIV obj = new CombinationSumIV();
        System.out.println(obj.combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(obj.combinationSumIV(new int[]{1, 2, 3}, 4));
    }
}
