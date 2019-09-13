package leetcode.hard;

// https://leetcode.com/problems/minimum-window-substring/ -
// Use this solution as template for all Sliding Window Problems

/*

76. Minimum Window Substring

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, 0);
        for (char c : t.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                return ""; // wow
        }

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map.get(c1) > 0)
                counter--;
            map.put(c1, map.get(c1) - 1);

            end++;

            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                char c2 = s.charAt(start);
                map.put(c2, map.get(c2) + 1);

                if (map.get(c2) > 0)
                    counter++;

                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args){

        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(obj.minWindow("ADOBECODEBANC", "ADC"));
    }
}
