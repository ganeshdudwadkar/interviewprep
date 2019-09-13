package leetcode.hard;

// Shortest Distance from All Buildings - (LC # 317) - Beats 47.28%
/*

 https://leetcode.com/problems/shortest-distance-from-all-buildings/#/description
 You want to build a house on an empty land which reaches all buildings in the shortest amount of distance.
 You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.

 */

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        int distance;
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] visits = new int[m][n];
        int buildings = 0;
        boolean[][] visited;
        Queue<int[]> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    distance = 0;
                    q = new LinkedList<>();
                    visited = new boolean[m][n];
                    q.offer(new int[]{i, j, distance});
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        dist[x][y] += cur[2];
                        visits[x][y]++;
                        distance = cur[2] + 1;
                        if (y + 1 < n && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
                            q.offer(new int[]{x, y + 1, distance});
                            visited[x][y + 1] = true;
                        }
                        if (y - 1 >= 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
                            q.offer(new int[]{x, y - 1, distance});
                            visited[x][y - 1] = true;
                        }
                        if (x + 1 < m && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                            q.offer(new int[]{x + 1, y, distance});
                            visited[x + 1][y] = true;
                        }
                        if (x - 1 >= 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                            q.offer(new int[]{x - 1, y, distance});
                            visited[x - 1][y] = true;
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //System.out.print(dist[i][j]+",");
                if (dist[i][j] != 0 && visits[i][j] == buildings && res > dist[i][j]) {
                    res = dist[i][j];
                }
            }
            //System.out.println();
        }
        if (res == Integer.MAX_VALUE) return -1;
        else return res;
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{0,1,2},{0,0,0},{1,0,2}};
        ShortestDistanceFromAllBuildings obj = new ShortestDistanceFromAllBuildings();
        System.out.println(obj.shortestDistance(grid));
    }
}
