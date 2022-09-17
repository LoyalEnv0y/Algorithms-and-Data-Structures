package algorithms.sorting;

public class InsertionSort implements Sorting {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    exchange(arr, j, j - 1);
                }
            }
        }
    }
}
