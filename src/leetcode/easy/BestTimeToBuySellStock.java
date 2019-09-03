package leetcode.easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/*

121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

 */

public class BestTimeToBuySellStock {

    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days == 0) {
            return days;
        }
        //int[] dp = new int[days];
        int min_day = prices[0];
        int max_prof = 0;
        int todays_prof = 0;
        for (int i = 1; i < days; i++) {
            todays_prof = prices[i] - min_day;
            min_day = Math.min(min_day, prices[i]);
            max_prof = Math.max(max_prof, todays_prof);
            //dp[i] = max_prof;
        }
        return max_prof;
    }

    public static void main(String[] args) {

        BestTimeToBuySellStock obj = new BestTimeToBuySellStock();
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(obj.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}
