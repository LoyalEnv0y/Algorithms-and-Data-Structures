package algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        test(arr);

/*        testSorting(new SelectionSort(), arr);
        testSorting(new InsertionSort(), arr);
        testSorting(new ShellSort(), arr);
        testSorting(new MergeSort(), arr);
        testSorting(new QuickSort(), arr);*/
    }

    public static void testSorting(Sorting sortingType, int[] arr) {
        System.out.println(sortingType.getClass().getSimpleName() + ": ");

        shuffleArray(arr);
        System.out.println(Arrays.toString(arr));

        long startTime = System.nanoTime();
        sortingType.sort(arr);
        long endTime = System.nanoTime();

        System.out.println(sortingType.isSorted(arr));
        System.out.println(Arrays.toString(arr));
        System.out.println((endTime - startTime) / Math.pow(10, 9));

        System.out.println();
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

    public static void test(int[] arrToTest) {
        shuffleArray(arrToTest);
        ShellSort ss = new ShellSort();

        long start = System.nanoTime();
        ss.sort(arrToTest);
        long end = System.nanoTime();
        System.out.println("Normal: " + (end - start) / Math.pow(10, 9));
        System.out.println("Sorted: " + ss.isSorted(arrToTest));


        shuffleArray(arrToTest);

        long start2 = System.nanoTime();
        ss.mySort(arrToTest);
        long end2 = System.nanoTime();
        System.out.println("Mine: " + (end2 - start2) / Math.pow(10, 9));
        System.out.println("Sorted: " + ss.isSorted(arrToTest));
    }
}
