package leetcode.easy;

// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

/*

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true
Example 2:

Input: [1,2,3,4]
Output: false

 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int n : nums) {
            if (!hs.contains(n)) {
                hs.add(n);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(obj.containsDuplicate(new int[]{1, 2, 3, 2}));
    }
}
