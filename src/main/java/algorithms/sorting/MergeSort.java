package algorithms.sorting;

public class MergeSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        int length = arr.length;

        if (length < 2) {
            return;
        }

        int middleIndex = length / 2;
        int[] leftPart = new int[middleIndex];
        int[] rightPart = new int[length - middleIndex];

        for (int i = 0; i < middleIndex; i++) {
            leftPart[i] = arr[i];
        }

        for (int i = middleIndex; i < length; i++) {
            rightPart[i - middleIndex] = arr[i];
        }

        sort(leftPart);
        sort(rightPart);

        merge(arr, leftPart, rightPart);
    }

    public void merge(int[] arr, int[] leftPart, int[] rightPart) {
        int leftSize = leftPart.length;
        int rightSize = rightPart.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {

            if (leftPart[i] <= rightPart[j]) {
                arr[k] = leftPart[i];
                i++;

            } else {
                arr[k] = rightPart[j];
                j++;
            }

            k++;
        }

        while (i < leftSize) {
            arr[k] = leftPart[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightPart[j];
            j++;
            k++;
        }
    }
}
