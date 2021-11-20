import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     November 20, 2021
 *
 * Utilizes an internal Node with an array of Node References.
 * Each Ref is implicitly defined by the array indices via the Radix of the alphabet used.
 *
 * Objects used as values in Node class b/c Java forbids Generic Arrays.
 * Recast as Values via the public get() method.
 *
 *
 * Template for creating trees with finite potential children at each level, but not explicitly defined until needed.
 *****************************************************************************/
public class TrieRWay<Value> {
    private static final int R = 256; //extended ascii
    private Node root = new Node();

    private static class Node{
        private Object val;
        private Node[] next =  new Node[R];
    }

    public Value get(String key){
        Node x = get(root, key, 0 );
        if(x == null) return null;
        return (Value) x.val;
    }

    private Node get(Node x, String key, int d){
        if(x == null) return null;
        if(d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d){
        if(x == null) x = new Node();
        if(d == key.length()){x.val = val; return x;}
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public void delete(String key){
        if(!contains(key)) throw new NoSuchElementException("Key Does not exist in Trie");
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d){
        if(x == null) return null;
        if(d == key.length()){
            x.val = null;
            return null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        if(x.val != null) return x;

        for(char c = 0; c < R; c++)
            if(x.next[c] != null) return x;

        return null;
    }

    public boolean contains(String key){
        return get(key) != null;
    }

    public static void main(String[] args){
        TrieRWay trie = new TrieRWay();
        trie.put("Hello", 3);
        trie.put("World", 4);
        trie.put("Hi", 2);
        trie.put("Earth", 9);

        StdOut.println("Contains Key 'Bye': " + trie.contains("Bye"));
        StdOut.println("Contains Key 'Hi': " + trie.contains("Hi"));
        StdOut.println("Contains Key 'Earth': " + trie.contains("Earth"));
//        trie.delete("mom");
        trie.delete("Earth");
        StdOut.println("Contains Key 'Earth': " + trie.contains("Earth"));

    }
}
