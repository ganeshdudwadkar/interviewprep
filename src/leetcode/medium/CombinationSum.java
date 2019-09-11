package leetcode.medium;

// https://leetcode.com/problems/combination-sum/

/*

39. Combination Sum

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> combi = new ArrayList<>();
        combinationSum(candidates, target, results, combi, 0);
        return results;
    }

    private void combinationSum(int[] candidates, int target, List<List<Integer>> results, List<Integer> combi, int index) {  // index is provided to repeat the same number again as it is allowed
        for (int i = index; i < candidates.length; i++) {
            int remaining = target - candidates[i];
            if (remaining == 0) {
                combi.add(candidates[i]);
                results.add(new ArrayList<Integer>(combi));
                combi.remove(combi.size() - 1);
                return;
            } else if (remaining > 0) {
                combi.add(candidates[i]);
                combinationSum(candidates, remaining, results, combi, i);
                combi.remove(combi.size() - 1);
            }
        }
    }

    public static void main(String[] args){

        CombinationSum obj = new CombinationSum();
        System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
