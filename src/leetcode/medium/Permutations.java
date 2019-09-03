package leetcode.medium;

// https://leetcode.com/problems/permutations/

/*

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> perms = new LinkedList<>();
        ;
        if (len == 1) {
            LinkedList<Integer> last = new LinkedList<Integer>();
            last.add(nums[0]);
            perms.add(last);
            return perms;
        }
        int digit = nums[0];
        List<List<Integer>> remaining = permute(Arrays.copyOfRange(nums, 1, len));
        for (List<Integer> ls : remaining) {
            for (int i = 0; i < len; i++) {
                ls.add(i, digit);
                perms.add(new LinkedList<Integer>(ls));
                ls.remove(i);
            }
        }
        return perms;
    }

    // Alternative non-recursive version

    public List<List<Integer>> permuteNonRec(int[] num) {
        List<List<Integer>> result = new ArrayList<>();

        //start from an empty list
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (List<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<>(current);
        }

        return result;
    }


    public static void main(String[] args) {

        Permutations obj = new Permutations();
        System.out.println(obj.permute(new int[]{1, 2, 3}));
        System.out.println(obj.permuteNonRec(new int[]{1, 2, 4}));
    }

}
