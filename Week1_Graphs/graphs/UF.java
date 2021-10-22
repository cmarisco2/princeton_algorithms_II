/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     March 26, 2021
 **************************************************************************** */
/*
 *
 * This Class implements the Weighted QuickUnion with Path Compression Algorithm for Unions.
 * Still O(n) for initialization :(
 *
 * But is almost linear! at an O(N + M lg*N)!!!!
 *
 * Best Union Algorithm currently. The third implementation.
 *
 *
 * */

import java.util.Arrays;

public class UF {
    private final int[] id;
    private final int[] sz;

    public UF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        Arrays.fill(sz, 1);
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    //  One Line change to flatten the tree.
//  Using the grandparent node vice the parent node, each skip.
    public int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

}
