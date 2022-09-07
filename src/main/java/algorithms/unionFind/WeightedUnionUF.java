package algorithms.unionFind;

import java.util.Arrays;

public class WeightedUnionUF {
    private final int[] id;
    private final int[] size;

    public WeightedUnionUF(int limit) {
        id = new int[limit];
        size = new int[limit];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int i) {
        if (id[i] == i) {
            return i;
        }

        /*
         * Below line makes sure the tree is flattened so that maximum
         * traversal is kept to minimum.
         *
         * For example if id[3] = 1 and id[1] = 5 then when we run the
         * below line with $i being 3 it becomes id[3] = id[1] which
         * means id[3] is now directly connected to id[5] -> id[3] = 5
         */
        id[i] = id[id[i]];
        return root(id[i]);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /*
     * It is almost the same as the previous but this time we are
     * determining the bigger tree by checking the size of p's head
     * to the size of q's head. If the size of q's head is bigger
     * than, we union p's head to q's head. vice versa...
     *
     * This way, we always make sure that the smaller tree is added to the
     * bigger tree and the depth of the tree never gets too large.
     */
    public void union(int p, int q) {
        int pParent = root(p);
        int qParent = root(q);

        if (pParent == qParent) {
            return;
        }

        if (size[pParent] <= size[qParent]) {
            id[pParent] = qParent;
            size[qParent] += size[pParent];
        } else {
            id[qParent] = pParent;
            size[pParent] += size[qParent];
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(id);
    }
}
