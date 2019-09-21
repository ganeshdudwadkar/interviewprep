package leetcode.medium;

// 73. Meeting Room II - LC 253
// Fnd the minimum number of conference rooms required.

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Definition for an interval.
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return start + " -> " + end;
    }
}


public class MeetingRoomsII {

    // Uses min heap, average time complexity is O(nlogn)

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });

        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Interval> heap = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        // start with the first meeting, put it to a meeting room
        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // get the meeting room that finishes earliest
            Interval interval = heap.poll();

            if (intervals[i].start >= interval.end) {
                // if the current meeting starts right after
                // there's no need for a new room, merge the interval
                interval.end = intervals[i].end;
            } else {
                // otherwise, this meeting needs a new room
                heap.offer(intervals[i]);
            }

            // don't forget to put the meeting room back
            heap.offer(interval);
        }

        return heap.size();
    }

    // Alternative O(n) solution
    public int minMeetingRoomsAlternate(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }

    public static void main(String[] args) {

        Interval[] intervals1 = {new Interval(0, 5), new Interval(5, 10), new Interval(12, 15)};
        Interval[] intervals2 = {new Interval(0, 6), new Interval(5, 13), new Interval(12, 15)};
        MeetingRoomsII obj = new MeetingRoomsII();
        System.out.println(obj.minMeetingRooms(intervals1));
        System.out.println(obj.minMeetingRoomsAlternate(intervals2));
    }
}


