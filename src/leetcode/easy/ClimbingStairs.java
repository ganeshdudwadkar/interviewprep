package leetcode.easy;

// https://leetcode.com/problems/climbing-stairs/

/*

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

 */

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n < 0)
            return 0;
        if (n == 1)
            return 1;

        int[] stairs = new int[n];

        stairs[0] = 1;
        stairs[1] = 2;

        for (int i = 2; i < n; ++i)
            stairs[i] = stairs[i - 1] + stairs[i - 2];

        return stairs[n - 1];
    }

    // In below solution -> Store the interim results to optimize it but for our problem we don't need the loop

    private static long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // example
        for (int i = 1; i <= n; i++)
            System.out.println(i + ": " + fibonacci(i));
    }

/*    public static void main(String args[]) {
        int n1=0,n2=1,n3,i,count=10;
        System.out.print(n1+" "+n2);//printing 0 and 1

        for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed {
            n3=n1+n2;
        System.out.print(" "+n3);
        n1=n2;
        n2=n3;
    }*/

}

