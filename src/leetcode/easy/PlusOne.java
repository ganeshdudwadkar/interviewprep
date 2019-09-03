package leetcode.easy;

// https://leetcode.com/problems/plus-one/

/*

66. Plus One

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

 */

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int l = digits.length;
        int len = l;
        while (--len >= 0) {
            if (digits[len] == 9) {
                digits[len] = 0;
            } else {
                digits[len] += 1;
                return digits;
            }
        }

        if (digits[0] == 0) {
            int[] newDigits = new int[l + 1];
            newDigits[0] = 1;
            for (int i = 0; i < l; i++) {//not needed as rest all will be zeros always
                newDigits[i + 1] = digits[i];//
            }
            return newDigits;
        } else {
            System.out.println("Unreachable");
            return digits;  //unreachable
        }
    }

    // Easy

    public static int[] plusOneEasy(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    public static void main(String[] args) {

        int[] num1 = new int[]{1, 2, 3};
        int[] num2 = new int[]{9, 9, 9, 9};
        System.out.println(Arrays.toString(PlusOne.plusOne(num1)));
        System.out.println(Arrays.toString(PlusOne.plusOne(num2)));

    }

}
