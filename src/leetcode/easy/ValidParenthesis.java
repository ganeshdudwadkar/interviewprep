package leetcode.easy;

// https://leetcode.com/problems/valid-parentheses/

/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false

 */

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> cStack = new Stack<Character>();
        int len = s.length();
        char c;
        for (int i = 0; i < len; i++) {
            c = s.charAt(i);
            if (c == ')') {
                if (cStack.empty() || cStack.pop() != '(') {
                    return false;
                }
                continue;
            }
            if (c == ']') {
                if (cStack.empty() || cStack.pop() != '[') {
                    return false;
                }
                continue;
            }
            if (c == '}') {
                if (cStack.empty() || cStack.pop() != '{') {
                    return false;
                }
                continue;
            }
            cStack.push(c);
        }
        return cStack.empty();
    }

    public static void main(String[] args) {

        ValidParenthesis obj = new ValidParenthesis();
        System.out.println(obj.isValid("()[]{}"));
        System.out.println(obj.isValid("()[{[]}]"));
        System.out.println(obj.isValid("()[{[]}{]}"));
    }

}
