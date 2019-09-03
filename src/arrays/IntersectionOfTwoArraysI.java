package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*

    LeetCode # 349
    Given two arrays, write a function to compute their intersection.

        Example 1:

        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2]
        Example 2:

        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [9,4]
        Note:

        Each element in the result must be unique.
        The result can be in any order.

*/

class Solution {
    private boolean binSearch(int[] nums, int key) {
        int start = 0, end = nums.length - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                return true;
            } else if (nums[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int l1 = nums1.length;
        List<Integer> intersect = new ArrayList<Integer>();

        for (int i = 0; i < l1; i++) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                continue;//skip same elems
            }
            if (binSearch(nums2, nums1[i])) {
                intersect.add(nums1[i]);
            }
        }

        int[] intersect_arr = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) {
            intersect_arr[i] = intersect.get(i);
        }
        return intersect_arr;
    }
}


public class IntersectionOfTwoArraysI {

    public static void main(String[] args) {
        int[] array1 = new int[]{4, 9, 5};
        int[] array2 = new int[]{9, 4, 9, 8, 4};
        Solution solution = new Solution();
        int[] sol = solution.intersection(array1, array2);
        System.out.print(Arrays.toString(sol));
    }
}
