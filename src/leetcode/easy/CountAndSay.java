package leetcode.easy;

// https://leetcode.com/problems/count-and-say/

/*

38. Count and Say

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

 */

// Using String - 38ms
public class CountAndSay {

    public String countAndSay(int n) {
        String seq = "1";
        for (int i = 1; i < n; i++) {
            seq = getNextSeq(seq);
        }
        return seq;
    }

    public String getNextSeq(String s) {
        int count = 1;
        int sLen = s.length();
        String res = "";
        for (int i = 1; i < sLen; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                res += "" + count + s.charAt(i - 1);
                count = 1;
            }
        }
        res += "" + count + s.charAt(sLen - 1);
        return res;
    }

    public static void main(String[] args) {

        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(4));

    }
}

/*

Using StringBuilder : (4ms)

public class Solution {
    public String countAndSay(int n) {
        StringBuilder seq = new StringBuilder("1");
        for(int i=1;i<n;i++){
            seq = getNextSeq(seq);
        }
        return seq.toString();
    }

    public StringBuilder getNextSeq(StringBuilder s){
        int count = 1;
        int sLen = s.length();
        StringBuilder res = new StringBuilder("");
        for(int i=1;i<sLen;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            } else {
                res.append(count);
                res.append(s.charAt(i-1));
                count = 1;
            }
        }
        res.append(count);
        res.append(s.charAt(sLen-1));
        return res;
    }
}

 */