package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    public int[] twoSum(int[] nums, int target) {
        // create a map
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            if (numsMap.containsKey(search)) {
                return new int[]{numsMap.get(search), i};
            }
            numsMap.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] array = {12, 41, 9, 18, 10};
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(array, 27);
        if (result != null){
            System.out.println(Arrays.toString(result));
        }

    }

}