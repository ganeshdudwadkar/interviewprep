package leetcode.easy;

// https://leetcode.com/problems/add-binary/

/*

67. Add Binary

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

 */

public class AddBinary {

    public String addBinary(String a, String b) {
        // System.out.println("Adding " + a + " & " + b);
        int aLen = a.length();
        int bLen = b.length();
        if (aLen == 0) {
            return b;
        } else if (bLen == 0) {
            return a;
        }
        String res = "";
        int ai = aLen;
        int bi = bLen;
        int c = 0;
        while (ai > 0 && bi > 0) {
            ai--;
            bi--;
            if (a.charAt(ai) == '1' && b.charAt(bi) == '1') {
                if (c == 1) {
                    res = "1" + res;
                } else {
                    res = "0" + res;
                }
                c = 1;
            } else if (a.charAt(ai) == '1' || b.charAt(bi) == '1') {
                if (c == 1) {
                    res = "0" + res;
                } else {
                    res = "1" + res;
                }
            } else {
                res = "" + c + res;
                c = 0;
            }
        }
        // System.out.println("ai: " + ai + " bi: " + bi + " c: " + c);
        if (ai == 0 && bi == 0) {
            if (c == 1) {
                res = "1" + res;
            }
        } else if (ai == 0) {
            if (c == 1) {
                res = addBinary(b.substring(0, bi), "1") + res;
            } else {
                res = b.substring(0, bi) + res;
            }
        } else if (bi == 0) {
            if (c == 1) {
                res = addBinary(a.substring(0, ai), "1") + res;
            } else {
                res = a.substring(0, ai) + res;
            }
        }
        return res;
    }

    // Alternate solution

    public String addBinaryAlternate(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

