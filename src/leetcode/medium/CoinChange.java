package leetcode.medium;

// https://leetcode.com/problems/coin-change/

/*

322. Coin Change

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.

 */

import java.util.*;

public class CoinChange {

    Map<Integer, Integer> hm;
    Set<Integer> hs;

    CoinChange() {
        hm = new HashMap<>();
        hs = new HashSet<>();
        hm.put(0, 0);
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (hm.containsKey(amount)) {
            //System.out.println("HashMap hit for amount " + amount);
            return hm.get(amount);
        } else if (hs.contains(amount)) {
            //System.out.println("HashSet hit for amount " + amount);
            return -1;
        }
        int remaining, res;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            remaining = amount - coin;
            if (remaining == 0) {
                //System.out.println("Perfect match found");
                min = 0;
                break; // we must break here as array is sorted and remaining all will result in -1 res
            } else if (remaining > 0) {
                //System.out.println("Calling coinChange for " + remaining + " amount");
                res = coinChange(coins, remaining);
                if (res == -1) {
                    continue;
                }
                min = res < min ? res : min;
            }
        }

        if (min == Integer.MAX_VALUE) {
            hs.add(amount);
            return -1;
        }
        hm.put(amount, min + 1);
        return min + 1;
    }

    /*
    #Recursive Method: #
    The idea is very classic dynamic programming: think of the last step we take.
    Suppose we have already found out the best way to sum up to amount a, then for the last step, we can choose any coin type
    which gives us a remainder r where r = a-coins[i] for all i's. For every remainder,
    go through exactly the same process as before until either the remainder is 0 or less than 0 (meaning not a valid solution).
    With this idea, the only remaining detail is to store the minimum number of coins needed to sum up to r so that we don't need to recompute it over and over again.
     */

    public int coinChangeAlternate(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
        if (rem < 0) return -1; // not valid
        if (rem == 0) return 0; // completed
        if (count[rem - 1] != 0) return count[rem - 1]; // already computed, so reuse
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }

    public int coinChangeIterative(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    public static void main(String[] args){

        CoinChange obj = new CoinChange();
        System.out.println(obj.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(obj.coinChangeAlternate(new int[]{1, 2, 5}, 11));
        System.out.println(obj.coinChangeIterative(new int[]{1, 2, 5}, 21));
    }
}
