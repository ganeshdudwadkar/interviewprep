package leetcode.hard;

// https://leetcode.com/problems/wildcard-matching/

/*

44. Wildcard Matching

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

 */

public class WildcardMatching {

    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    public boolean isMatchDP(String s, String p) {
        int m = s.length(), n = p.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') count++;
        }
        if (count == 0 && m != n) return false;
        else if (n - count > m) return false;

        boolean[] match = new boolean[m + 1];
        match[0] = true;
        for (int i = 0; i < m; i++) {
            match[i + 1] = false;
        }
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') {
                for (int j = 0; j < m; j++) {
                    match[j + 1] = match[j] || match[j + 1];
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    match[j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
                }
                match[0] = false;
            }
        }
        return match[m];
    }

    // my solution that worked for 1707 test cases out of 1809 test cases - failed due to TLE
    public boolean isMatchRecursive(String s, String p) {
        //System.out.println(s + " " + p);
        if (s.equals(p)) return true;
        if (p.equals("")) return false;
        if (s.equals("")) {
            while (p.charAt(0) == '*') {
                if (p.equals("*")) return true;
                // skip all continuous stars
                p = p.substring(1);
            }
            return false;
        }
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') return isMatch(s.substring(1), p.substring(1));
        if (p.charAt(0) == '*') {
            while (p.charAt(0) == '*') {
                if (p.length() == 1) return true;
                // skip all continuous stars
                p = p.substring(1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (p.charAt(0) == '?' || s.charAt(i) == p.charAt(0)) {
                    boolean check = isMatch(s.substring(i), p);
                    if (check) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        WildcardMatching obj = new WildcardMatching();
        System.out.println(obj.isMatch("aa", "a*"));
        System.out.println(obj.isMatch("ab", "?*"));
        System.out.println(obj.isMatch("aab", "c*a*b"));
        System.out.println(obj.isMatchDP("aa", "a*"));
        System.out.println(obj.isMatchDP("ab", "?*"));
        System.out.println(obj.isMatchDP("aab", "c*a*b"));

    }
}
