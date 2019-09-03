package leetcode.easy;

// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashMap;
import java.util.Map;

/*

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

    /*
     * Non working //time limit exceeded

        for(int i=0;i<nums.length-k;i++){
            for(int j=i+1;j<=i+k && j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    */

        if (nums.length <= 0 || k <= 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i])) <= k) {
                //System.out.println(nums[i]);
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII obj = new ContainsDuplicateII();
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 2));
        System.out.println(obj.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }
}
