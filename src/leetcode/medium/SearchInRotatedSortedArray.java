package leetcode.medium;

// https://leetcode.com/problems/search-in-rotated-sorted-array/

/*

33. Search in Rotated Sorted Array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

 */

public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        if (hi < 0) return -1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }

    public static void main(String[] args) {

        SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(obj.search(arr, 0));
        System.out.println(obj.search(arr, 3));
    }
}
