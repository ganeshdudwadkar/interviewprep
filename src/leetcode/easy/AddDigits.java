package leetcode.easy;

// https://leetcode.com/problems/add-digits/


/*

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

Example:

Input: 38
Output: 2
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
             Since 2 has only one digit, return it.

 */

public class AddDigits {

    public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum > 9) {
            return addDigits(sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        AddDigits ad = new AddDigits();
        System.out.println(ad.addDigits(38));
        System.out.println(ad.addDigits(199));
    }
}
