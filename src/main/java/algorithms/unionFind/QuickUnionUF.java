package algorithms.unionFind;

import java.util.Arrays;

public class QuickUnionUF {
    private final int[] content;

    public QuickUnionUF(int limit) {
        content = new int[limit];

        for (int i = 0; i < content.length; i++) {
            content[i] = i;
        }
    }

    public int root(int i) {
        if (content[i] == i) {
            return content[i];
        }

        return root(content[i]);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pParent = root(p);
        int qParent = root(q);

        content[pParent] = qParent;
    }

    @Override
    public String toString() {
        return Arrays.toString(content);
    }
}
