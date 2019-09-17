package leetcode.medium;

// https://leetcode.com/articles/find-permutation/ - Locked

/*
# Find Permutation (LC # 484)

Input: "I"
Output: [1,2]
Explanation: [1,2] is the only legal initial spectial string can construct secret signature "I",
where the number 1 and 2 construct an increasing relationship.

Input: "DI"
Output: [2,1,3]
Explanation: Both [2,1,3] and [3,1,2] can construct the secret signature "DI",
but since we want to find the one with the smallest lexicographical permutation, you need to output [2,1,3]
---------
For example, given IDIIDD we start with sorted sequence 1234567
Then for each k continuous D starting at index i we need to reverse [i, i+k] portion of the sorted sequence.

IDIIDD
1234567 // sorted
1324765 // answer
 */

public class FindPermutation {

    public int[] findPermutation(String s) {
        int n = s.length(), arr[] = new int[n + 1];
        for (int i = 0; i <= n; i++) arr[i] = i + 1; // sorted
        for (int h = 0; h < n; h++) {
            if (s.charAt(h) == 'D') {
                int l = h;
                while (h < n && s.charAt(h) == 'D') h++;
                reverse(arr, l, h);
            }
        }
        return arr;
    }

    private void reverse(int[] arr, int l, int h) {
        while (l < h) {
            arr[l] ^= arr[h];
            arr[h] ^= arr[l];
            arr[l] ^= arr[h];
            l++; h--;
        }
    }
}
