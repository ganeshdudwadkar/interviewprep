package leetcode.medium;

// https://leetcode.com/problems/3sum/

/*

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int j, k, sum;
        for (int i = 0; i < nums.length - 2; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                //System.out.println("Checking " + nums[i] + " , " + nums[j] + " , " + nums[k]);
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    res.add(ls);
                    j++;
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;//to avoid duplicates
                    while (j < k && nums[j] == nums[j - 1]) j++;//to avoid duplicates
                } else if (sum > 0) {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;//optional skip for non-zero triplets
                } else {//
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;//optional skip for non-zero triplets
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) { //to avoid duplicates
                i++;
            }
        }
        return res;
    }

    /*

    Other clean solution ->

    Excellent elegant solution! Adding '<=' and '>=' for sum check and nums[i] > 0 are masterstrokes.
    This way the while loop is also applicable for duplicates which doesn't even form required triplet.

     */

    public List<List<Integer>> threeSumII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            if (nums[i] > 0) break;//good point since it is sorted. In general nums[i]>target
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                if (sum <= 0) while (nums[j] == nums[++j] && j < k) ;
                if (sum >= 0) while (nums[k--] == nums[k] && j < k) ;
            }
            while (nums[i] == nums[++i] && i < nums.length - 2) ;
        }
        return result;
    }

    public static void main(String[] args){

        ThreeSum obj = new ThreeSum();
        System.out.println(obj.threeSum(new int[]{-1, -2, 2, 1, 0}));
        System.out.println(obj.threeSumII(new int[]{-1, -2, 2, 1, 0}));
    }
}
