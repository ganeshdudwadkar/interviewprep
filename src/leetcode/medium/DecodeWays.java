package leetcode.medium;

// https://leetcode.com/problems/decode-ways/

/*

91. Decode Ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 */

public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.equals("0"))
            return 0;


        int[] t = new int[s.length() + 1];
        t[0] = 1;

        //if(s.charAt(0)!='0')
        if (isValid(s.substring(0, 1)))
            t[1] = 1;
        else
            t[1] = 0;

        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i - 1, i))) {
                t[i] += t[i - 1];
            }

            if (isValid(s.substring(i - 2, i))) {
                t[i] += t[i - 2];
            }
        }

        return t[s.length()];
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return false;
        int value = Integer.parseInt(s);
        return value >= 1 && value <= 26;
    }

    public static void main(String[] args){

        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings("226"));
    }
}
