package algorithms.sorting;

public class ShellSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                for (int j = i; j >= gap && arr[j] < arr[j - gap]; j -= gap) {
                    exchange(arr, j, j - gap);
                }
            }
        }
    }
}
