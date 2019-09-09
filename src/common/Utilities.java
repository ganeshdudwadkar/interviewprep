package common;

import java.util.Arrays;

public class Utilities {

    public static void print2DArray(int[][] grid){
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void print2DArray(char[][] grid){
        for (char[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }
}
