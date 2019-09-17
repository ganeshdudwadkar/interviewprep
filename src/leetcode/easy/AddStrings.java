package leetcode.easy;

// https://leetcode.com/problems/add-strings/

/*

415. Add Strings

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder n1 = new StringBuilder(num1).reverse();
        StringBuilder n2 = new StringBuilder(num2).reverse();
        int lenDiff = Math.abs(n1.length() - n2.length());
        if (n1.length() > n2.length()) {
            n2 = appendZeros(n2, lenDiff);
        } else {
            n1 = appendZeros(n1, lenDiff);
        }
        StringBuilder result = new StringBuilder(n1.length() + 1);
        int carry = 0;
        int temp;
        for (int i = 0; i < n1.length(); i++) {
            temp = Character.getNumericValue(n1.charAt(i)) + Character.getNumericValue(n2.charAt(i)) + carry;
            if (temp > 9) carry = 1;
            else carry = 0;
            result.append(temp % 10);
        }
        if (carry == 1) result.append(carry);
        return result.reverse().toString();
    }

    private StringBuilder appendZeros(StringBuilder s1, int n) {
        for (int i = 0; i < n; i++) {
            s1.append(0);
        }
        return s1;
    }

    public static void main(String[] args) {
        AddStrings obj = new AddStrings();
        System.out.println(obj.addStrings("99999999", "202"));
    }
}
