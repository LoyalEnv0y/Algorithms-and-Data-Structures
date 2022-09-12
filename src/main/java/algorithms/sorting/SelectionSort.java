package algorithms.sorting;

public class SelectionSort implements Sorting{
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            exchange(arr, i, min);
        }
    }
}
