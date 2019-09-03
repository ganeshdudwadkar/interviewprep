package leetcode.medium;

// https://leetcode.com/problems/reverse-words-in-a-string/

/*

Given an input string, reverse the string word by word.

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

 */

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        String out = "";
        for (int i = parts.length - 1; i > 0; i--) {
            out += parts[i] + " ";
        }
        return out + parts[0];
    }

    public static void main(String[] args) {

        ReverseWordsInAString example = new ReverseWordsInAString();
        System.out.println(example.reverseWords("the sky is blue"));
        System.out.println(example.reverseWords("  hello world!  "));
    }
}
