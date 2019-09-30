package leetcode.dynamicprogramming;

// From book - Introduction to Algorithms

/*
Given a rod of length n inches and a table of prices p for 1 to n, determine the max revenue Rn obtainable by cutting up
the rod and selling the pieces. Note that if the price Pn for a rod of length n is large enough, an optimal solution
may require no cutting at all.
 */

import java.util.Arrays;

import static java.lang.Math.max;

public class RodCutting {

    // Recursive top-down implementation
    // maxProfit for each number gets calculated multiple times due to recursion hence it takes exponential time O(2^n)
    int maxProfit(int[] prices, int n) {
        if (n == 0) return 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxProfit = max(maxProfit, prices[i] + maxProfit(prices, n - i));
        }
        return maxProfit;
    }

    // Recursive top-down memoization solution - O(n^2) Time Complexity
    int maxProfitAux(int[] prices, int[] aux, int n) {
        if (n == 0) return 0;
        if (aux[n] > 0) {
            // System.out.println("Returning aux[" + n + "] as " + aux[n]);
            return aux[n]; // return precalculated memoized profit
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxProfit = max(maxProfit, prices[i] + maxProfitAux(prices, aux, n - i));
        }
        aux[n] = maxProfit;
        return maxProfit;
    }

    // Non-recursive bottom-up memoization solution - O(n^2) Time Complexity
    int maxProfixBottomUpAux(int[] prices, int n) {
        int[] aux = new int[prices.length];
        aux[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxProfit = 0;
            for (int j = 1; j <= i; j++) {
                maxProfit = max(maxProfit, prices[j] + aux[i - j]);
            }
            aux[i] = maxProfit;
        }
        System.out.println(Arrays.toString(aux));
        return aux[n];
    }

    public static void main(String[] args) {
        // indexes represents the length
        int[] prices = new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        System.out.println(new RodCutting().maxProfit(prices, 10));
        int[] aux = new int[prices.length];
        System.out.println(new RodCutting().maxProfitAux(prices, aux, 10));
        System.out.println(Arrays.toString(aux));
        System.out.println(new RodCutting().maxProfixBottomUpAux(prices, 10));

    }
}
