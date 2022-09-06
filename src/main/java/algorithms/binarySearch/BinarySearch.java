package algorithms.binarySearch;

import java.util.Scanner;

public class BinarySearch {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ui();
    }

    public static void ui() {
        System.out.println("Size of the array:");
        System.out.print("> ");
        int size = Integer.parseInt(scanner.nextLine());

        System.out.println("Building array...");
        int[] array = buildArray(size);
        System.out.println("Array has been built\n");

        ui:
        while (true) {
            System.out.println("1 - Linear");
            System.out.println("2 - Binary");
            System.out.println("3 - Quit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> System.out.println(linearSearch(array, getItem()));
                case "2" -> System.out.println(binarySearch(array, getItem()));
                case "3" -> {
                    break ui;
                }
            }
        }
    }

    public static int getItem() {
        System.out.println("Item to find: ");
        System.out.print("> ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int[] buildArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = i+1;
        }

        return array;
    }

    public static int linearSearch(int[] array, int item) {
        int tries = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                System.out.println(tries);
                return i;
            }
            tries++;
        }

        return -1;
    }

    public static int binarySearch(int[] array, int item) {
        int tries = 0;
        int low = 0;
        int high = array.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int currentValue = array[mid];

            tries++;

            if (item == currentValue) {
                System.out.println(tries);
                return mid;
            } else if (currentValue < item) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
}
