package sorting;
import java.util.Arrays;

public class MergeSort {

    public void sort(int[] a) {
        msort(a, 0, a.length - 1);
    }

    private void msort(int[] a, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            msort(a, lo, mid);
            msort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }
    }

    private void merge(int[] a, int lo, int mid, int hi) {
        // deep copy to aux[]
        int[] aux = new int[a.length];
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                // a[k] = aux[j++];   // this copying is unnecessary ?
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        int[] arr = {27, 9, 7, 81, 3, 2, 34, 28, 5};
        s.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
