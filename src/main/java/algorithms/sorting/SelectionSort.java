package algorithms.sorting;

public class SelectionSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            int min = i;

            for (int j = i; j < length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            exchange(arr, min, i);
        }
    }
}
