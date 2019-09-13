package leetcode.hard;

// Best Meeting Point (LC # 296)

/*

https://leetcode.com/problems/best-meeting-point/#/description

A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

 */

import java.util.LinkedList;
import java.util.Queue;

public class BestMeetingPoint {

    // This solution is same as Shortest Distance From All Buildings but gives TLE on leetcode
    public int minTotalDistance(int[][] grid) {
        int distance;
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        //int[][] visits = new int[m][n];
        int maxVisits = 0;
        boolean[][] visited;
        Queue<int[]> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    //maxVisits++;
                    distance = 0;
                    q = new LinkedList<>();
                    visited = new boolean[m][n];
                    q.offer(new int[]{i, j, distance});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        dist[x][y] += cur[2];
                        visited[x][y] = true;
                        distance = cur[2] + 1;
                        if (y + 1 < n && !visited[x][y + 1]) {
                            q.offer(new int[]{x, y + 1, distance});
                            visited[x][y + 1] = true;
                        }
                        if (y - 1 >= 0 && !visited[x][y - 1]) {
                            q.offer(new int[]{x, y - 1, distance});
                            visited[x][y - 1] = true;
                        }
                        if (x + 1 < m && !visited[x + 1][y]) {
                            q.offer(new int[]{x + 1, y, distance});
                            visited[x + 1][y] = true;
                        }
                        if (x - 1 >= 0 && !visited[x - 1][y]) {
                            q.offer(new int[]{x - 1, y, distance});
                            visited[x - 1][y] = true;
                        }
                    }
                    //printGrid(dist);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print(dist[i][j]+",");
                if (dist[i][j] < res) {
                    res = dist[i][j];
                }
            }
            //System.out.println();
        }
        //if (res == Integer.MAX_VALUE) return 1;
        //else return res;
        return res;
    }

    public void printGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 1}, {0, 0, 0}, {1, 0, 0}};
        BestMeetingPoint obj = new BestMeetingPoint();
        System.out.println(obj.minTotalDistance(grid));
    }
}
