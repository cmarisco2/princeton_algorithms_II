import edu.princeton.cs.algs4.StdOut;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     May 6, 2021
 *****************************************************************************/
public class MinPQ<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N;

    public MinPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key item) {
        pq[++N] = item;
        swim(N);
    }

    public Key delMin() {
        Key min = pq[1];
        exch(1, N--);
        sink(1);
        pq[N + 1] = null;
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private void printPQ() {
        StdOut.println("The Underlying Array Structure is: ");
        for (int i = 1; i <= N; i++)
            StdOut.print(pq[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        MinPQ<String> queue = new MinPQ<>(10);
        String[] letters = {"T", "A", "G", "H", "P", "R", "C", "O", "M", "Z"};
        StdOut.println("The input letter sequence is:");
        for (String s : letters)
            StdOut.print(s + " ");
        StdOut.println();
        for (String s : letters)
            queue.insert(s);
        queue.printPQ();
        StdOut.println("The Min Letter Removed is: " + queue.delMin());
        queue.printPQ();
    }
}
