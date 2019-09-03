package leetcode.easy;

import java.util.Arrays;

public class TwoSum {
    public int[] solution(int[] nums, int target) {
        int l = nums.length;
        for (int i = 0; i < l; i++)
            for (int j = i + 1; j < l; j++)
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {12, 41, 9, 18, 10};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.solution(array, 27);
        if (result != null) ;
        System.out.println(Arrays.toString(result));
    }

}