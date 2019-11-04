package leetcode.medium;

// https://leetcode.com/problems/brick-wall/

/*

554. Brick Wall

There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.



Example:

Input: [[1,2,2,1],
        [3,1,2],
        [1,3,2],
        [2,4],
        [3,1,2],
        [1,3,1,1]]

Output: 2

 */

import java.util.*;

public class BrickWall {

    // Best way is to keep track of ends using a map and the map entry with max ends has the least bricks crossing it
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }

    // Below solution works on small numbers only.
    public int leastBricksUnaccepted(List<List<Integer>> wall) {
        int rows = wall.size();
        int columns = wall.get(0).stream().reduce(0, Integer::sum);
        int[][] array = new int[rows][columns];
        int row = 0;
        for (List<Integer> ls : wall) {
            int col = 0;
            for (int num : ls) {
                for (int j = 0; j < num - 1; j++) {
                    array[row][col++] = 1;
                }
                array[row][col++] = 0;
            }
            row++;
        }

        // print matrix
        /*
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        } */


        int min = rows;
        int cur_sum;
        for (int j = 0; j < columns - 1; j++) {
            cur_sum = 0;
            for (int i = 0; i < rows; i++) {
                cur_sum += array[i][j];

            }
            // System.out.println(cur_sum);
            min = Math.min(min, cur_sum);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>(6);
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));

        System.out.println(new BrickWall().leastBricks(wall));
    }
}
