package leetcode.medium;

// - https://leetcode.com/problems/basic-calculator-ii/

/*
227. Basic Calculator II

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5

 */

import java.util.Stack;

//
public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        s = s.trim();
        char c;
        // dummy pushes to avoid peeking edge case
        nums.push(0);
        ops.push('+');
        int num = 0;
        int i = 0;
        while (i < s.length()) {
            c = s.charAt(i);
            i++;
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            } else {
                if (!Character.isSpaceChar(c)) {
                    // if * or / on top of ops stack, then immediately perform those operations using operate method
                    // since the num is now completely formed
                    operate(nums, ops, num);
                    ops.push(c); // push the new operator that is found
                    num = 0;
                }
            }
        }
        // last one
        operate(nums, ops, num);

        // process the remaining stack for additions and subtractions
        int ans = 0;
        while (!nums.empty()) {
            ans += nums.pop(); // only additions are left
        }
        return ans;
    }

    private void operate(Stack<Integer> nums, Stack<Character> ops, int num) {
        switch (ops.peek()) {
            case '/':
                nums.push(nums.pop() / num);
                ops.pop();
                break;
            case '*':
                nums.push(nums.pop() * num);
                ops.pop();
                break;
            case '-':
                nums.push(0 - num);
                break; //subtraction later as addition
            case '+':
                nums.push(num); // addition later
        }
    }
}
