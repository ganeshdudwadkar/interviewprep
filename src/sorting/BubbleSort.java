package sorting;

import java.util.Arrays;

//The idea is to push the max element to its final position in every iteration
//That means smaller keys are bubbled-up in the array
//if there are no exchanges in any iteration means the array is already sorted

public class BubbleSort {

    public void sort(int[] array) {
        boolean exchange = true;
        for (int i = 0; i < array.length && exchange; i++) {
            exchange = false;
            for (int j = 1; j < array.length - i; j++)
                if (array[j] < array[j - 1]) {
                    exch(array, j, j - 1);
                    exchange = true;
                }
        }
    }

    private void exch(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 41, 9, 18, 10};
        new BubbleSort().sort(array);
        System.out.println(Arrays.toString(array));
    }

}

