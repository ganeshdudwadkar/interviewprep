package leetcode.medium;

// https://leetcode.com/problems/number-of-islands/

/*

200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

 */

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    checkNeighbour(grid, i, j);
                }
            }
        }
        return count;
    }

    private void checkNeighbour(char[][] grid, int i, int j) {
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            grid[i + 1][j] = '0';
            checkNeighbour(grid, i + 1, j);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            grid[i][j + 1] = '0';
            checkNeighbour(grid, i, j + 1);
        }
        if (i > 0 && grid[i - 1][j] == '1') {
            grid[i - 1][j] = '0';
            checkNeighbour(grid, i - 1, j);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            grid[i][j - 1] = '0';
            checkNeighbour(grid, i, j - 1);
        }
        /* diagonal checks not reqd
        if(i+1<mat.length&&j+1<mat[0].length&&mat[i+1][j+1]==1){
            mat[i+1][j+1]=0;
            checkNeighbour(mat,i+1,j+1);
        }*/
    }

    public static void main(String[] args) {

        char[][] grid1 = new char[][]{
                {'1', '1', '1', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'1', '1', '0', '0', '0' },
                {'0', '0', '0', '0', '0' }
        };

        System.out.println(new NumberOfIslands().numIslands(grid1));

        char[][] grid2 = new char[][]{
                {'1', '0', '1', '1', '0' },
                {'1', '0', '0', '1', '0' },
                {'1', '1', '0', '1', '0' },
                {'0', '0', '1', '0', '1' }
        };

        System.out.println(new NumberOfIslands().numIslands(grid2));

    }

}
