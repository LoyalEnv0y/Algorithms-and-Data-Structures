package algorithms.sorting;

import java.util.Random;

public class QuickSort implements Sorting {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        exchange(arr, pivot, pivotIndex);

        int lp = lowIndex;
        int rp = highIndex;

        while (lp < rp) {
            while (arr[lp] <= pivot && lp < rp) {
                lp++;
            }

            while (arr[rp] >= pivot && lp < rp) {
                rp--;
            }
            exchange(arr, lp, rp);
        }

        exchange(arr, lp, highIndex);

        quickSort(arr, lowIndex, lp - 1);
        quickSort(arr, lp + 1, highIndex);
    }
}
