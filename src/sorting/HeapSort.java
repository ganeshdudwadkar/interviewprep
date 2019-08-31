package sorting;
import java.util.Arrays;

public class HeapSort {

    public void sort(int[] a) {
        int N = a.length;
        constructHeap(a, N);

        while (N > 1) {
            //exchange 1st element (which is highest) with last (to its final position)
            exch(a, 1, N--);
            //sink the root to reconstruct the heap
            sink(a, 1, N);
        }
    }
    //Construct the heap by performing sink operations on all parent nodes (in a bottom-up fashion)
    private void constructHeap(int[] a, int N) {
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
    }
    //move parent node downwards if its less than its child
    private void sink(int[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) {
                j++;
            }
            if (!less(a, k, j)) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    //Indices are "off-by-one" to support 1-based indexing.
    private void exch(int[] array, int x, int y) {
        int temp = array[x - 1];
        array[x - 1] = array[y - 1];
        array[y - 1] = temp;
    }

    //Indices are "off-by-one" to support 1-based indexing.
    private boolean less(int[] a, int i, int j) {
        return a[i - 1] < a[j - 1];
    }

    public static void main(String[] args) {
        HeapSort s = new HeapSort();
        int[] arr = {27, 9, 7, 81, 3, 2, 34, 28, 5};
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}