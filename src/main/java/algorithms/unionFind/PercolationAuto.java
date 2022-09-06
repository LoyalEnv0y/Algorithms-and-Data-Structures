package algorithms.unionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PercolationAuto {
    private final int size;
    private String[] coords;
    private final Percolation perc;
    private int openedTiles = 0;

    public PercolationAuto(int size) {
        this.size = size;
        this.coords = new String[size * size];
        this.perc = new Percolation(size);
    }

    public void start() throws InterruptedException {
        createRandomCoords();

        for (int i = 0; !perc.percolates(); i++) {
            System.out.println(perc);
            System.out.println();

            int testI = coords[i].charAt(0) - '0';
            int testJ = coords[i].charAt(3) - '0';

            perc.open(testI, testJ);
            openedTiles++;
//            Thread.sleep(500);
        }

        System.out.println(perc);
        System.out.println(perc.percolates());
        System.out.print("Total Opened Tiles: " + this.openedTiles);
    }

    public ArrayList<String> createCoordinates() {
        ArrayList<String> coordinates = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                coordinates.add(i + ", " + j);
            }
        }
        return coordinates;
    }

    public void createRandomCoords() {
        List<String> randomCoords = createCoordinates();
        Collections.shuffle(randomCoords);
        coords = randomCoords.toArray(coords);
    }
}
