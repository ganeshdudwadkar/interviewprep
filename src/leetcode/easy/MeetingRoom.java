package leetcode.easy;

// Meeting Room (Can attend all meetings?) LC #252

import java.util.Arrays;
import java.util.Comparator;

// Definition for an interval.
 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }

public class MeetingRoom {

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null)
            return false;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) { return a.start - b.start; }
        });

        for (int i = 1; i < intervals.length; i++)
            if (intervals[i].start < intervals[i - 1].end)
                return false;
        return true;
    }

    public static void main(String[] args){

        Interval[] intervals1 = {new Interval(0,5), new Interval(5,10), new Interval(12,15)};
        Interval[] intervals2 = {new Interval(0,6), new Interval(5,10), new Interval(12,15)};
        MeetingRoom obj = new MeetingRoom();
        System.out.println(obj.canAttendMeetings(intervals1));
        System.out.println(obj.canAttendMeetings(intervals2));
    }
}
