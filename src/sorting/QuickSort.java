package sorting;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] a) {
        //add logic to shuffle
        sort(a, 0, a.length - 1);
    }

    private void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        int pivot = a[lo]; //1st elem is considered pivot in this case so pivot elem gets to its final position in first round
        while (i < j) {
            //find item on left to swap
            while (a[++i] < pivot) {
                if (i == hi) {
                    break;
                }
            }
            //find item on right to swap
            while (pivot < a[--j]) {
                if (j == lo) {
                    break;
                }
            }
            if (i < j) { //check if pointer crossed
                exch(a, i, j); //keep exchanging elems wrt pivot
            }
        }
        exch(a, lo, j);//swap index lo (pivot) with index j so that pivot gets to its final position
        return j; //return index of item now known to be in place
    }

    public void exch(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] arr = {27, 9, 7, 81, 3, 2, 34, 28, 5};
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
