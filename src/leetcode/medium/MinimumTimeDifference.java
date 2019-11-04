package leetcode.medium;

// https://leetcode.com/problems/minimum-time-difference/

/*

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.

 */


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
/*    public int findMinDifferenceTwoData(List<String> timePoints) {
        final int MAX_MINS = 60 * 24;
        String[] s1 = timePoints.get(0).split(":");
        String[] s2 = timePoints.get(1).split(":");

        int t1mins = minsFromMidnight(s1);
        int t2mins = minsFromMidnight(s2);
        if (t1mins > t2mins) {
            return Math.min(t1mins - t2mins, t2mins + MAX_MINS - t1mins);
        } else {
            return Math.min(t2mins - t1mins, t1mins + MAX_MINS - t2mins);
        }
    }*/

    public int findMinDifference(List<String> timePoints) {
        final int MAX_MINUTES = 60 * 24;
        if (timePoints.size() >= MAX_MINUTES) return 0; // pigeon hole principle
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            minutes[i] = minsFromMidnight(timePoints.get(i).split(":"));
        }
        Arrays.sort(minutes);
        int min_diff = MAX_MINUTES;
        int diff;
        for (int i = 1; i < minutes.length; i++) {
            diff = minutes[i] - minutes[i - 1];
            min_diff = Math.min(min_diff, diff);
        }
        // special case
        min_diff = Math.min(min_diff, MAX_MINUTES + minutes[0] - minutes[minutes.length - 1]);
        return min_diff;
    }

    private int minsFromMidnight(String[] s) {
        int h = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        return h * 60 + m;
    }

    public static void main(String[] args) {
        MinimumTimeDifference obj = new MinimumTimeDifference();
        System.out.println(obj.findMinDifference(new ArrayList<>(Arrays.asList("23:59", "00:00"))));
        System.out.println(obj.findMinDifference(new ArrayList<>(Arrays.asList("23:59", "23:50", "00:01"))));
        System.out.println(obj.findMinDifference(new ArrayList<>(Arrays.asList("12:59", "00:00", "11:20"))));
    }
}
