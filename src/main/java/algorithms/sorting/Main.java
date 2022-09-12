package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        shuffleArray(arr);

        //System.out.println(Arrays.toString(arr));
        System.out.println(selectionSort.isSorted(arr));
        System.out.println("\n**************\n");

        long startTime = System.nanoTime();
        selectionSort.sort(arr);
        long endTime = System.nanoTime();
        //System.out.println(Arrays.toString(arr));
        System.out.println(selectionSort.isSorted(arr));
        System.out.println((endTime - startTime * 1.0) / Math.pow(60, 5));
    }

    // Shuffle the array using Knuth's shuffle algorithm -> https://www.youtube.com/watch?v=i8kD33wx9Mo
    public static void shuffleArray(int[] arrayToShuffle) {
        Random random = new Random();

        for (int i = arrayToShuffle.length - 1; i >= 0; i--) {
            int randomIndex = random.nextInt(i + 1);

            int temp = arrayToShuffle[i];
            arrayToShuffle[i] = arrayToShuffle[randomIndex];
            arrayToShuffle[randomIndex] = temp;
        }
    }
}
