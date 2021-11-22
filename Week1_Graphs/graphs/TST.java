/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     November 22, 2021
 *
 * Ternary Search Trie
 * Utilizes a Tree Representation of Strings with Common Prefixes.
 * Has QuickSort like method of keeping Equal keys in the middle.
 *
 * **Check Notes for Concept and Illustration
 *****************************************************************************/
public class TST<Value> {
    private Node root;

    private class Node{
        char c;
        Value val;
        Node left, right, mid;
    }

    public Value get(String key){
        Node x = get(root, key, 0);
        if(x == null) return null;
        return x.val;
    }

    private Node get(Node x, String key, int charIndex){
        if(x == null) return null;
        char c = key.charAt(charIndex);
        if (c < x.c) return get(x.left, key, charIndex);
        else if( c > x.c) return get(x.right, key, charIndex);
        else if(charIndex < key.length() - 1)
            return get(x.mid, key, charIndex + 1);
        else return x;
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d){
        char c = key.charAt(d);
        if(x == null) { x = new Node(); x.c = c;}
        if(c < x.c) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if(d < key.length() - 1)
            x.mid = put(x.mid, key, val, d + 1);
        else x.val = val;
        return x;
    }

    public static void main(String[] args){

    }
}
