package sorting;
import java.util.Arrays;

public class SelectionSort {

    //The idea is to find the lowest element in every iteration by scanning the entire or remaining array
    public void sort(int[] array) {
        int minIndex;
        for (int i = 0; i < array.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            exch(array, i, minIndex);
        }
    }

    private void exch(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {12, 41, 9, 18, 10};
        new SelectionSort().sort(array);
        System.out.println(Arrays.toString(array));
    }

}

