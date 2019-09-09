package leetcode.medium;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

/*

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

 */

import java.util.*;

public class LetterCombinationOfAPhoneNumber {


    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> hm = new HashMap<>();
        hm.put('1', new ArrayList<>());
        hm.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        hm.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        hm.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        hm.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        hm.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        hm.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        hm.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        hm.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));

        List<String> ls = getCombi(digits, hm);
        //\Collections.sort(ls);
        return ls;
    }

    private List<String> getCombi(String digits, Map<Character, List<String>> hm) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            return hm.get(digits.charAt(0));
        }
        List<String> chars = hm.get(digits.charAt(0));
        List<String> results = new ArrayList<>();
        List<String> remaining = getCombi(digits.substring(1), hm);
        for (String sub : remaining) {
            for (String c : chars) {
                results.add(c + sub);
            }
        }
        return new ArrayList<>(results);
    }

    public static void main(String[] args){

        System.out.println(new LetterCombinationOfAPhoneNumber().letterCombinations("232"));
    }
}
