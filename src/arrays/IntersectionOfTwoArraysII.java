package arrays;

import java.util.*;

/*
        LeetCode # 350
        Given two arrays, write a function to compute their intersection.

        Example 1:

        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]
        Example 2:

        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [4,9]

        */


class SolutionII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hm = new HashMap<>();
        int val;
        for (int num : nums1) {
            val = 0;
            if (hm.containsKey(num)) {
                val = hm.get(num);
            }
            hm.put(num, val + 1);
        }

        List<Integer> intersect = new ArrayList<>();
        for (int num : nums2) {
            if (hm.containsKey(num)) {
                val = hm.get(num);
                if (val > 0) {
                    intersect.add(num);
                    hm.put(num, val - 1);
                }
            }
        }

        int[] intersect_arr = new int[intersect.size()];
        for (int i = 0; i < intersect.size(); i++) {
            intersect_arr[i] = intersect.get(i);
        }
        return intersect_arr;
    }
}

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        int[] array1 = new int[]{4, 9, 5};
        int[] array2 = new int[]{9, 4, 9, 8, 4};
        SolutionII solution = new SolutionII();
        int[] sol = solution.intersect(array1, array2);
        System.out.print(Arrays.toString(sol));
    }
}
