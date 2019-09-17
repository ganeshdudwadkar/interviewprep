package leetcode.medium;

// https://leetcode.com/problems/pacific-atlantic-water-flow/

/*

417. Pacific Atlantic Water Flow

Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:

The order of returned grid coordinates does not matter.
Both m and n are less than 150.


Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();

        int m = matrix.length;

        if (m == 0) return result;

        int n = matrix[0].length;

        boolean[][] reachingPacificShores = new boolean[m][n];

        // check where the water on the edges is coming from
        // basically find the source of water

        for (int i = 0; i < m; i++) {
            markAllValidNeighbors(matrix, reachingPacificShores, i, 0);
        }

        for (int j = 1; j < n; j++) {
            markAllValidNeighbors(matrix, reachingPacificShores, 0, j);
        }

        boolean[][] reachingAtlanticShores = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            markAllValidNeighbors(matrix, reachingAtlanticShores, i, n - 1);
        }

        for (int j = 0; j < n - 1; j++) {
            markAllValidNeighbors(matrix, reachingAtlanticShores, m - 1, j);
        }

        // take intersection
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (reachingPacificShores[i][j] && reachingAtlanticShores[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }

    private void markAllValidNeighbors(int[][] matrix, boolean[][] canReach, int i, int j) {
        if (i < 0 || i >= canReach.length || j < 0 || j >= canReach[0].length || canReach[i][j]) return;

        canReach[i][j] = true;
        if (i - 1 >= 0 && matrix[i - 1][j] >= matrix[i][j]) markAllValidNeighbors(matrix, canReach, i - 1, j);
        if (i + 1 < canReach.length && matrix[i + 1][j] >= matrix[i][j])
            markAllValidNeighbors(matrix, canReach, i + 1, j);
        if (j - 1 >= 0 && matrix[i][j - 1] >= matrix[i][j]) markAllValidNeighbors(matrix, canReach, i, j - 1);
        if (j + 1 < canReach[0].length && matrix[i][j + 1] >= matrix[i][j])
            markAllValidNeighbors(matrix, canReach, i, j + 1);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
        List<int[]> res = obj.pacificAtlantic(matrix);
        for (int[] coordinates : res)
            System.out.println(Arrays.toString(coordinates));
    }
}
