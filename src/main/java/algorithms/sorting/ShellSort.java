package algorithms.sorting;

public class ShellSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        int interval = arr.length / 2;

        while (interval > 0) {
            for (int i = interval; i < arr.length; i++) {
                for (int j = i; j >= interval && arr[j] < arr[j - interval]; j -= interval) {
                    exchange(arr, j, j - interval);
                }
            }
            interval /= 2;
        }
    }
}
