package algorithms.sorting;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        testSorting(new SelectionSort(), arr);
        testSorting(new InsertionSort(), arr);
        testSorting(new ShellSort(), arr);
    }

    public static void testSorting(Sorting sortingType, int[] arr) {
        System.out.println(sortingType.getClass().getSimpleName() + ": ");

        shuffleArray(arr);
        //System.out.println(Arrays.toString(arr));

        long startTime = System.nanoTime();
        sortingType.sort(arr);
        long endTime = System.nanoTime();

        System.out.println(sortingType.isSorted(arr));
        //System.out.println(Arrays.toString(arr));
        System.out.println((endTime - startTime) /  Math.pow(10, 9));

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
}
