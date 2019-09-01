package leetcode.easy;

// https://leetcode.com/problems/valid-anagram/

/*

Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

 */


import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramAllChars(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            } else {
                hm.put(s.charAt(i), 1);
            }
            if (hm.containsKey(t.charAt(i))) {
                hm.put(t.charAt(i), hm.get(t.charAt(i)) - 1);
            } else {
                hm.put(t.charAt(i), -1);
            }
        }
        // System.out.println(hm);
        for (char key : hm.keySet()) {
            if (hm.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
        System.out.println(validAnagram.isAnagramAllChars("tard$", "gho%"));
        System.out.println(validAnagram.isAnagramAllChars("c@rd", "cr@d"));
    }
}

