package sorting;

import java.util.Arrays;

public class InsertionSort {

    //The idea of insertion sort is to sort the array starting with 1 size, 2 size, 3 size etc
    //So after every ith iteration, array is already sorted till ith element and rest of the elements are unseen
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) { //insert j th element to its final position of the current run
                if (array[j] < array[j - 1]) {
                    exch(array, j - 1, j);
                } else break;//because previous elements are already sorted till j
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
        new InsertionSort().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
