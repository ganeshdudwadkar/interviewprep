package leetcode.hard;

// https://leetcode.com/problems/regular-expression-matching/

/*

10. Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

 */

import java.util.Arrays;

public class RegularExpressionMatching {

    // Using Recursion :

    public boolean isMatch(String s, String p) {
        if (p.contains(".") || p.contains("*")) {
            if (p.length() == 1 || p.charAt(1) != '*')
                return comp(s, p, s.length(), 0) && isMatch(s.substring(1), p.substring(1));
            for (int i = 0; i == 0 || comp(s, p, s.length(), i - 1); i++) {
                if (isMatch(s.substring(i), p.substring(2)))
                    return true;
            }
        }
        return s.equals(p);
    }

    private boolean comp(String s, String p, int sLen, int i) {
        return sLen > i && (p.charAt(0) == s.charAt(i) || p.charAt(0) == '.');
    }

    // DP Version

    public boolean isMatchDP(String s, String p) {
        boolean[] match = new boolean[s.length() + 1];
        Arrays.fill(match, false);
        match[s.length()] = true;
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                for (int j = s.length() - 1; j >= 0; j--)
                    match[j] = match[j] || match[j + 1] && (p.charAt(i - 1) == '.' || s.charAt(j) == p.charAt(i - 1));
                i--;
            } else {
                for (int j = 0; j < s.length(); j++)
                    match[j] = match[j + 1] && (p.charAt(i) == '.' || p.charAt(i) == s.charAt(j));
                match[s.length()] = false;
            }
        }
        return match[0];
    }

    public static void main(String[] args){

        RegularExpressionMatching obj = new RegularExpressionMatching();
        System.out.println(obj.isMatch("aab", "c*a*b"));
        System.out.println(obj.isMatch("mississippi", "mis*is*p*."));
        System.out.println(obj.isMatch("ab", ".*"));
        System.out.println(obj.isMatchDP("aab", "c*a*b"));
        System.out.println(obj.isMatchDP("mississippi", "mis*is*p*."));
        System.out.println(obj.isMatchDP("ab", ".*"));

    }

}
