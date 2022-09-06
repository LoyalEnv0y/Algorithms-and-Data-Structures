package algorithms.unionFind;

import java.util.Arrays;

/*
* Quick find algorithm in a union find is good when finding if the two given elements are connected to the same
* root. It does this in 0(1) time.
*
* However, Quick find is bad at connecting two groups because it works in quadratic -> O(n^2) time
*/

public class QuickFindUF {
    private int[] content;

    public QuickFindUF(int size) {
        content = new int[size];

        for (int i = 0; i < content.length; i++) {
            content[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return content[p] == content[q];
    }

    public void union(int p, int q) {
        int pValue = content[p];

        for (int i = 0; i < content.length; i++) {
            if (content[i] == pValue) {
                content[i] = content[q];
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(content);
    }
}
