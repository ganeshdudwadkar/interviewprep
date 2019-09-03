package leetcode.medium;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/

/*

Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int sLen = s.length();
        if (sLen <= 1) return sLen;
        int left = 0;
        int right = 0;
        int max_len = 0;
        char c;
        Set<Character> set = new HashSet<>();
        while (right < sLen) {
            c = s.charAt(right);
            if (set.contains(c)) {
                if (set.size() > max_len) {
                    max_len = set.size();
                }
                while (set.contains(c)) {
                    set.remove(s.charAt(left++));
                }

            }
            set.add(c);
            right++;
        }
        if (set.size() > max_len) {
            max_len = set.size();
        }
        return (max_len == 0) ? sLen : max_len;
    }

    /*

    The basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring.
    Move the right pointer to scan through the string , and meanwhile update the hashmap.
    If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
     */

    public int lengthOfLongestSubstringII(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }


    /*

    Yet Another - Same as mine but elegant
    The idea is use a hash set to track the longest substring without repeating characters so far,
    use a fast pointer j to see if character j is in the hash set or not, if not, great, add it to the hash set,
    move j forward and update the max length, otherwise, delete from the head by using a slow pointer i until we can put character j to the hash set.
     */

    public int lengthOfLongestSubstringIII(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args) {

        LongestSubstringWithoutRepeatingChars obj = new LongestSubstringWithoutRepeatingChars();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstringII("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstringIII("pwwkew"));

    }
}
