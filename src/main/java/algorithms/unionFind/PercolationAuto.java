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

            String[] coordsSplit = coords[i]
                    .replace(" ", "").split(",");

            int iAxis = Integer.parseInt(coordsSplit[0]);
            int jAxis = Integer.parseInt(coordsSplit[1]);

            perc.open(iAxis, jAxis);
            openedTiles++;
            perc.finish();
//            Thread.sleep(100);
        }

        System.out.println(perc);
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
