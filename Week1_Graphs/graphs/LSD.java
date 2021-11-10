import edu.princeton.cs.algs4.StdOut;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     November 10, 2021
 *
 * Least Significant Digit Sort Class
 *
 * Radix Sort Using Key-Indexed Counting as the Basis for sorting on Fixed Length Strings.
 * R = Radix Value (Number of 'bins'). This Case 256 bit for Extended ASCII Characters
 * N = Length of the array of Strings
 * W = Fixed Length of Each String in the String Array.
 *
 * Uses The Method of Key Indexed Counting
 * -Frequency Counting:
 *      -keys = small ints, *count array is indexed based on the key
 *      -count[key]++ every time it occurs in the given array.
 * -Count --->> Indices:
 *      -Value @ i = Value @ i + Value @ (i - 1)
 *      -count[r+1] += count[r]
 * -Distribute Data:
 *      -Use the count's indices to put data into an auxiliary array as we traverse the given array
 *      -Find Index Position (count[r])
 *      -put in aux[], then count[r]++
 *      -aux[count[r]++] = a[i], where r is typically a[i].key()
 *      -key() in this instance in actually charAt(d), where d is the index of a given string from the given array.
 *****************************************************************************/
public class LSD {

    public static void sort(String[] a, int W){
        int N = a.length;
        int R = 256;

        String [] aux = new String[N];

        for(int d = W - 1; d >= 0; d--){
//            Freq Count
            int [] count = new int[R + 1];
            for(int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
//            Count -> Indices
            for(int r = 0; r < R; r++)
                count[r + 1] += count[r];
//            Distribute Data
            for(int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
//            copy back to original array
            for(int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }

    public static void main(String[] args){
        StdOut.println("Test");
    }
}
