package algorithms.sorting;

import java.util.Arrays;

public class MergeSort implements Sorting {
    @Override
    public void sort(int[] arr) {
        int length = arr.length;

        if (length < 2) {
            return;
        }

        int middleIndex = length / 2;
        int[] leftPart = Arrays.copyOfRange(arr, 0, middleIndex);
        int[] rightPart = Arrays.copyOfRange(arr, middleIndex, length);

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
