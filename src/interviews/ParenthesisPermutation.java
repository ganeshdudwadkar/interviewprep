package interviews;

/**
 * Implement an algorithm to print all valid (i.e. properly opened and closed)
 * combinations of n-pairs of parentheses.
 * <p>
 * EXAMPLE:
 * Input: 3
 * Output:
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 * <p>
 * Invalid case: )(()()
 * <p>
 * Input: 2
 * Output:
 * ()()
 * (())
 * <p>
 * Input: 1
 * ()
 * invalid case: ))((
 */

// - Originally https://leetcode.com/problems/generate-parentheses/ (LC 22)

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class ParenthesisPermutation {

    public Set<String> permute(int n) {
        Set<String> ans = new HashSet<>();
        if (n <= 0) return ans;
        if (n == 1) {
            ans.add("()");
            return ans;
        }

        Set<String> remaining = permute(n - 1);
        String temp;
        for (String s : remaining) {
            for (int i = 0; i < s.length(); i++) {
                temp = s.substring(0, i) + "()" + s.substring(i);
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Set<String> ans = new ParenthesisPermutation().permute(3);

        for (String string : ans) {
            System.out.println(string);
        }
    }
}

