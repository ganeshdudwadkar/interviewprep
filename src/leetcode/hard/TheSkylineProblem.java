package leetcode.hard;

// https://leetcode.com/problems/the-skyline-problem/

/*
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo, write a program
to output the skyline formed by these buildings collectively.
 */

import java.util.*;

public class TheSkylineProblem {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }

        List<Point> points = new ArrayList<>(); // populate points
        for (int[] b : buildings) {
            points.add(new Point(b[0], b[2], 0)); // left edge
            points.add(new Point(b[1], b[2], 1)); // right edge
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) { // compare x coordinate -> compare left or right -> compare height based on left or right
                if (a.x != b.x) {
                    return a.x - b.x;
                } else if (a.flag != b.flag) { // add left edge first
                    return a.flag - b.flag;
                } else {
                    if (a.flag == 0) { // left edge, highest should be add to map first
                        return b.h - a.h;
                    } else {
                        // right edge, lowest should be removed first
                        return a.h - b.h;
                    }
                }
            }
        });

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder()); // <height, cnt>
        map.put(0, 1);
        int prevHeight = 0;

        for (Point p : points) {
            if (p.flag == 0) { // left edge
                map.put(p.h, map.getOrDefault(p.h, 0) + 1);
            } else { // right edge
                map.put(p.h, map.get(p.h) - 1);
                if (map.get(p.h) == 0) {
                    map.remove(p.h);
                }
            }

            int curHeight = map.firstKey();
            if (curHeight != prevHeight) {
                res.add(new int[]{p.x, curHeight});
                prevHeight = curHeight;
            }
        }

        return res;
    }
}

class Point {

    int x;
    int h;
    int flag;

    public Point(int x, int h, int flag) {
        this.x = x;
        this.h = h;
        this.flag = flag;
    }
}
