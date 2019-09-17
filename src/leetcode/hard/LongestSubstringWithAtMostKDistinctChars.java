package leetcode.hard;

// Longest Substring with At Most K Distinct Characters (LC # 340) (#2 Top Hit Google)

/*

Given a string, find the length of the longest substring T that contains at most k distinct characters.
For example, Given s = “eceba” and k = 2,
T is "ece" which its length is 3.

 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctChars {

    // This problem can be solved using two pointers. The important part is while (map.size() > k),
    // we move left pointer to make sure the map size is less or equal to k.
    // This can be easily extended to any number of unique characters.

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int best = 0;
        for(int i = 0; i < s.length(); i++) {
            // character at the right pointer
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // make sure map size is valid, no need to check left pointer less than s.length()
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            best = Math.max(best, i - left + 1);
        }
        return best;
    }

    public static void main(String[] args){

        LongestSubstringWithAtMostKDistinctChars obj = new LongestSubstringWithAtMostKDistinctChars();
        System.out.println(obj.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("eceba", 1));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("eceba", 3));
        System.out.println(obj.lengthOfLongestSubstringKDistinct("eceeba", 2));
    }

}
