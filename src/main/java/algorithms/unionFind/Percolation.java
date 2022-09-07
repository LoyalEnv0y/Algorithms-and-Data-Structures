package algorithms.unionFind;

import java.util.Arrays;

/*
 * Percolation is an exercise to use the quickfind data structure.
 */
public class Percolation {
    int N;
    String[] grid;
    WeightedUnionUF perc;
    String blockedCell = "🔴";
    String openedCell = "🟢";
    String fullCell = "🔵";


    public Percolation(int N) {
        this.N = N;
        this.grid = new String[N * N];

        /*
         * The UnionFind structure below (perc) will have 2 more elements
         * in it than the grid because at index 0, we will have a head
         * pointer that unionizes with every cell in the 0th row.
         *
         * And at the last index of the perc there will be a tail pointer
         * that unionizes with every cell int the (N-1)th row.
         *
         * These two pointer at the head and tail will be important when we
         * are checking if the grid percolates and if the cell is full or not
         *
         * This design comes with a flaw that the (ith, jth) element in the
         * grid corresponds to (i+1th, j+1th) element. This is because while
         * first element in the grid is at 0th index, The first element int
         * the perc is at 1st index.
         */
        this.perc = new WeightedUnionUF(N*N + 2);

        Arrays.fill(grid, blockedCell);
    }

    /* Open row i, column j (all 0 based)
     *
     * If the row is 0 then that means it is at the top row, and we need
     * to unionize it with the head.
     *
     * If the row is N-1 then that means it is at the end row, and we need
     * to unionize it with the tail.
     *
     * Remember that perc stores the indexes of the grid as 1 based so, we
     * need to account for that.
     */
    public void open(int i, int j) {
        grid[i * N + j] = openedCell;

        // Unionize with the head
        if (i == 0) {
            perc.union(j+1, 0);
        }

        // Unionize with the tail
        if (i == N-1) {
            perc.union((i * N + j) + 1, N*N+1);
        }
        // Check the neighbours to see if they are open. If so, we unionize
        // them with the newly opened grid.
        checkNeighbours(i, j);
    }

    public boolean isOpen(int i, int j) {
        // checks for out of bounds
        if ((i < 0 || i > N-1) || (j < 0 || j > N-1)) {
            return false;
        }

        return grid[i * N + j].equals(openedCell) ||
                grid[i * N + j].equals(fullCell);
    }

    public boolean isFull(int i, int j) {
        /* if the given cell of the grid is connected to the head of the
         * perc, we return true. Otherwise, false.
         *
         * Remember that index are different with grid and perc so, we
         * need to translate the index of grid to perc by adding 1 to it.
         */
        return perc.connected((i * N + j) + 1, 0);
    }

    public boolean percolates() {
        // The grid percolates if the head is connected to tail.
        return perc.connected(0, N*N+1);
    }

    // Check top, right, bottom and left of the origin index and unionize
    // any that are open with the origin.
    private void checkNeighbours(int i, int j) {
        int origin = i * N + j;
        int top = (i-1) * N + j;
        int right = (i) * N + j+1;
        int bottom = (i+1) * N + j;
        int left = i * N + j-1;

        // Check the top
        if (isOpen(i-1, j)) {
            perc.union(origin+1, top+1);
        }
        // Check the right
        if (isOpen(i, j+1)){
            perc.union(origin+1, right+1);
        }
        // Check the bottom
        if (isOpen(i+1, j)) {
            perc.union(origin+1, bottom+1);
        }
        // Check the left
        if (isOpen(i, j-1)) {
            perc.union(origin+1, left+1);
        }
    }

    public void finish() {
        for (int i = 0; i < grid.length; i++) {
            if (perc.connected(0, i+1)) {
                grid[i] = fullCell;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < grid.length; i++) {
            if ((i % N == 0) && (i != 0)) {
                sb.append("\n");
            }
            sb.append(grid[i]).append(" ");
        }

        return sb.toString();
    }
}
