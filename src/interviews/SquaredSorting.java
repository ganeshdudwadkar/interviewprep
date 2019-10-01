package interviews;

// Given an integer array in sorted order, return a squared sorted array

import java.util.Arrays;

public class SquaredSorting {

    public int[] getSuaredArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        int[] sqrd = new int[nums.length];
        int index = nums.length - 1;
        while (start <= end) {
            if (Math.abs(nums[start]) <= (Math.abs(nums[end]))) {
                sqrd[index--] = nums[end] * nums[end];
                end--;
            } else {
                sqrd[index--] = nums[start] * nums[start];
                start++;
            }
        }
        return sqrd;
    }

    public static void main(String[] args) {
        SquaredSorting obj = new SquaredSorting();
        int[] res1 = obj.getSuaredArray(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(res1));
        int[] res2 = obj.getSuaredArray(new int[]{-7, -2, -1, 0, 1, 2, 6});
        System.out.println(Arrays.toString(res2));
    }

}
