package leetcode.easy;

// Strobogrammatic Number (LC # 246)

/*

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        if (num == null || num == "") return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');
        char[] arr = num.toCharArray();
        int len = arr.length;
        for (int i = 0; i <= len / 2; i++) {
            if (!map.containsKey(arr[i])) return false;
            if (map.get(arr[i]) != arr[len - i - 1]) return false;
        }
        return true;
    }

    public static void main(String[] args){

        StrobogrammaticNumber obj = new StrobogrammaticNumber();
        System.out.println(obj.isStrobogrammatic("9661"));
        System.out.println(obj.isStrobogrammatic("9668"));
        System.out.println(obj.isStrobogrammatic("9662"));
    }
}
