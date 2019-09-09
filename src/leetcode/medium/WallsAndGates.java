package leetcode.medium;

// Walls and Gates (LeetCode # 286) - beats 79%

/*



 */

import common.Utilities;

import java.util.Arrays;

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    inform(rooms, i, j, 0);
                }
            }
        }
    }

    private void inform(int[][] rooms, int i, int j, int dist) {
        if (j > 0 && rooms[i][j - 1] > dist + 1) {
            //System.out.println("Updating room["+(i)+"]["+(j-1)+"] with " + (dist + 1));
            rooms[i][j - 1] = dist + 1;
            inform(rooms, i, j - 1, dist + 1);
        }
        if (j < rooms[0].length - 1 && rooms[i][j + 1] > dist + 1) {
            //System.out.println("Updating room["+(i)+"]["+(j+1)+"] with " + (dist + 1));
            rooms[i][j + 1] = dist + 1;
            inform(rooms, i, j + 1, dist + 1);
        }
        if (i < rooms.length - 1 && rooms[i + 1][j] > dist + 1) {
            //System.out.println("Updating room["+(i+1)+"]["+(j)+"] with " + (dist + 1));
            rooms[i + 1][j] = dist + 1;
            inform(rooms, i + 1, j, dist + 1);
        }
        if (i > 0 && rooms[i - 1][j] > dist + 1) {
            //System.out.println("Updating room["+(i-1)+"]["+(j)+"] with " + (dist + 1));
            rooms[i - 1][j] = dist + 1;
            inform(rooms, i - 1, j, dist + 1);
        }
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {2, 0, 1, 1, 0},
                {3, 5, 0, 3, 0},
                {1, 8, 0, 2, 0},
                {0, 0, 0, 0, 1}
        };

        new WallsAndGates().wallsAndGates(grid);
        Utilities.print2DArray(grid);

        /*
        Output is ->

        [1, 0, 1, 1, 0]
        [2, 1, 0, 1, 0]
        [1, 1, 0, 1, 0]
        [0, 0, 0, 0, 1]

         */
    }
}
