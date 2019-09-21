package leetcode.medium;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/

/*

438. Find All Anagrams in a String

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllStringsInAnagram {

    public List<Integer> findAnagrams(String s, String p) {
        //if (s == null || p == null)
        List<Integer> ls = new ArrayList<>();
        if (p.length() > s.length()) return ls;
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        char c;
        for (int i = 0; i < p.length(); i++) {
            c = p.charAt(i);
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
            c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        if (isAnagram(sMap, pMap)) ls.add(0);
        char d;
        for (int i = 0; i < s.length() - p.length(); i++) {
            // System.out.println(sMap);
            c = s.charAt(i + p.length());
            d = s.charAt(i);
            // add c
            // System.out.println("c is " + c);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            // remove d
            // System.out.println("d is " + d);
            sMap.put(d, sMap.get(d) - 1);
            if (isAnagram(sMap, pMap)) ls.add(i + 1);
        }
        return ls;

    }

    private boolean isAnagram(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for (char c : pMap.keySet()) {
            if (!sMap.containsKey(c) || !sMap.get(c).equals(pMap.get(c))) return false;
        }
        return true;
    }

    private boolean isAnagramAlternate(Map<Character,Integer> sMap, Map<Character,Integer> pMap){
        for(char c: pMap.keySet()){
            if (!sMap.containsKey(c)) return false;
            int x = sMap.get(c);
            int y = pMap.get(c);
            if (x != y) return false;
        }
        return true;
    }

    /* sMap.get(c) != pMap.get(c) is failing when number is outside -128 to 127
    private boolean isAnagram(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for (char c : pMap.keySet()) {
            if (!sMap.containsKey(c) || sMap.get(c) != pMap.get(c)) return false;
        }
        return true;
    }
    */

    public static void main(String[] args){

        FindAllStringsInAnagram obj = new FindAllStringsInAnagram();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc"));
        System.out.println(obj.findAnagrams("abab", "ab"));
        System.out.println(obj.findAnagrams("aaaaaaaaa", "aaaaaaaa"));

        /*
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        char c = 'a';
        pMap.put(c, 10);
        sMap.put(c, 10);
        if (sMap.get(c) == pMap.get(c)) {
            System.out.println(c + " value is same");
        }
        char d = 'b';
        pMap.put(d, 10000);
        sMap.put(d, 10000);
        if (sMap.get(d) == pMap.get(d)) {
            System.out.println(d + " value is same");
        }
        if (sMap.get(d).equals(pMap.get(d))) {
            System.out.println(d + " value is same");
        }
        */
    }
}
