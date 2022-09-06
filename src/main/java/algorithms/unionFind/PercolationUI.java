package algorithms.unionFind;

import java.util.Scanner;

public class PercolationUI {
    private final Scanner scanner;
    private Percolation perc;

    public PercolationUI() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("*******WELCOME*******");
        System.out.println("How big do you want to gird to be?");
        int gridLength = Integer.parseInt(scanner.nextLine());
        this.perc = new Percolation(gridLength);

        while (true) {
            printChoices();
            System.out.print("> ");
            String choice = scanner.nextLine();

            if (choice.isEmpty()) {
                break;
            }
            processChoice(choice);
            System.out.println();
        }
    }

    private void printChoices() {
        System.out.println("1: Print the grid");
        System.out.println("2: Open a cell");
        System.out.println("3: Check if the cell is full");
        System.out.println("4: Check if percolates");
        System.out.println("Empty entry quits");
    }

    private void processChoice(String choice) {
        switch (choice) {
            case "1" -> System.out.println(perc);
            case "2" -> {
                int[] coordinates = parseCoordinates(getCoordinates());
                perc.open(coordinates[0], coordinates[1]);
            }
            case "3" -> {
                int[] coordinates = parseCoordinates(getCoordinates());
                System.out.println(perc.isFull(coordinates[0], coordinates[1]));
            }
            case "4" -> System.out.println(perc.percolates());
        }
    }

    private String[] getCoordinates() {
        System.out.println("Choose a cell (separate with a comma)");
        System.out.print("> ");

        String input = scanner.nextLine();
        return input.replace(" ", "").split(",");
    }

    private int[] parseCoordinates(String[] stringCoordinates) {
        int[] coordinates = new int[2];

        coordinates[0] = Integer.parseInt(stringCoordinates[0]);
        coordinates[1] = Integer.parseInt(stringCoordinates[1]);

        return coordinates;
    }
}
