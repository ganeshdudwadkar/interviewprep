package leetcode.medium;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/

/*

150. Evaluate Reverse Polish Notation

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

 */

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return -1;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int x, y;
        for (String token : tokens) {
            switch (token) {
                case "*":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x * y);
                    break;
                case "/":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x / y);
                    break;
                case "+":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x + y);
                    break;
                case "-":
                    y = stack.pop();
                    x = stack.pop();
                    stack.push(x - y);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){

        EvaluateReversePolishNotation example = new EvaluateReversePolishNotation();

        String[] input1 = {"2", "1", "+", "3", "*"};
        System.out.println(example.evalRPN(input1));

        String[] input2 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(example.evalRPN(input2));
    }
}
