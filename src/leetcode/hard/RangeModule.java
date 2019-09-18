package leetcode.hard;

// https://leetcode.com/problems/range-module/

/*

715. Range Module

A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.

addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
Example 1:
addRange(10, 20): null
removeRange(14, 16): null
queryRange(10, 14): true (Every number in [10, 14) is being tracked)
queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
Note:

A half open interval [left, right) denotes all real numbers left <= x < right.
0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
The total number of calls to addRange in a single test case is at most 1000.
The total number of calls to queryRange in a single test case is at most 5000.
The total number of calls to removeRange in a single test case is at most 1000.

 */


/*

Explanation:
Take addRange for example.
If all points in the range including both ends are removed, and you want to insert new ends.
The value of the start point depends on its previous point. If its lowerKey is false, it should be true. Otherwise take no action.
The value of the end point depends on its previous value. If it was false, it should still be false. If it was true, it should be removed since start is now true.

Several Key points:

floorKey is used instead of lower key because end is exclusive. So the value at the end actually matters when it comes to determine the value of end point.
For example,
(1,false), (8,true), addRange(7,8). (1,false), (7,true), is expected. But using lowerKey would give (1,false), (7,true), (8,false)
clear should include the end point because if the end point is true, it should be removed. Two consecutive true are not allowed. In other words, there should only be a end point there if it is false.
Time complexity of all three methods are log(n). submap takes O(logn) time, clear takes constant time.
 */

import java.util.TreeMap;

class RangeModule {
    TreeMap<Integer, Boolean> map;

    public RangeModule() {
        map = new TreeMap<>();
        map.put(0, false);
    }

    public void addRange(int left, int right) {
        boolean from = map.get(map.lowerKey(left));
        boolean to = map.get(map.floorKey(right));
        map.subMap(left, true, right, true).clear();
        if (!from) map.put(left, true);
        if (!to) map.put(right, false);
    }

    public boolean queryRange(int left, int right) {
        int lower = map.lowerKey(right);
        return lower <= left && map.get(lower);
    }

    public void removeRange(int left, int right) {
        boolean from = map.get(map.lowerKey(left));
        boolean to = map.get(map.floorKey(right));
        map.subMap(left, true, right, true).clear();
        if (from) map.put(left, false);
        if (to) map.put(right, true);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */


/*

Below solution gives TLE;

class RangeModule {
    Set<Integer> set;
    public RangeModule() {
        set = new HashSet<>();
    }

    public void addRange(int left, int right) {
        for(int i=left; i<right;i++){
            set.add(i);
        }
    }

    public boolean queryRange(int left, int right) {
        for(int i=left; i< right; i++){
            if (!set.contains(i)) return false;
        }
        return true;
    }

    public void removeRange(int left, int right) {
        for(int i=left; i<right;i++){
            set.remove(i);
        }
    }
}

 */