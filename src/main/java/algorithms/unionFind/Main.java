package algorithms.unionFind;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;

        Percolation percolation = new Percolation(size);

        while (!percolation.percolates()) {
            percolation.open(random.nextInt(size), random.nextInt(size));
        }

        System.out.println(percolation);
        System.out.println(percolation.percolates());
    }
}