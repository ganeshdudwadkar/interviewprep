package leetcode.medium;

// https://leetcode.com/problems/restore-ip-addresses/

/*

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

 */

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> ls = new ArrayList<>();
        helper(s, ls, 4, "");
        return ls;
    }

    private void helper(String s, List<String> ls, int dep, String res) {
        int len = s.length();
        if (len > dep * 3 || len < dep) {
            return; //String too large or too small
        }

        if (dep == 1) {
            if (isValid(s)) {
                res += "." + s;
                ls.add(res);
            }
            return;
        }

        for (int i = 0; i < len - dep + 1; i++) {
            String sub = s.substring(0, i + 1);
            if (isValid(sub)) {
                if (dep != 4) {
                    helper(s.substring(i + 1), ls, dep - 1, res + "." + sub);
                } else {
                    helper(s.substring(i + 1), ls, dep - 1, sub);
                }
            }
        }
    }

    private boolean isValid(String num) {
        int val = Integer.valueOf(num);
        if (val >= 0 && val <= 255) {
            return String.valueOf(val).length() == num.length(); // Additionally verify if there are no leading zeros
        }
        return false;
    }

    // Alternate solution

    public List<String> restoreIpAddresses1(String s) {
        List<String> ans = new ArrayList<String>();
        int len = s.length();
        for (int i = 1; i <= 3; ++i) {  // first cut
            if (len - i > 9) continue;
            for (int j = i + 1; j <= i + 3; ++j) {  //second cut
                if (len - j > 6) continue;
                for (int k = j + 1; k <= j + 3 && k < len; ++k) {  // third cut
                    int a, b, c, d;                // the four int's seperated by "."
                    a = Integer.parseInt(s.substring(0, i));
                    b = Integer.parseInt(s.substring(i, j)); // notice that "01" can be parsed into 1. Need to deal with that later.
                    c = Integer.parseInt(s.substring(j, k));
                    d = Integer.parseInt(s.substring(k));
                    if (a > 255 || b > 255 || c > 255 || d > 255) continue;
                    String ip = a + "." + b + "." + c + "." + d;
                    if (ip.length() < len + 3)
                        continue;  // this is to reject those int's parsed from "01" or "00"-like substrings
                    ans.add(ip);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        RestoreIPAddresses obj = new RestoreIPAddresses();
        System.out.println(obj.restoreIpAddresses("25525511135"));
        System.out.println(obj.restoreIpAddresses1("2512551113"));
    }
}
