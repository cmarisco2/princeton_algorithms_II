import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 11, 2021
 *
 * Create a Queue API for use in Graphs
 *****************************************************************************/
public class Bag<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(Item item) {
        Node temp = new Node();
        temp.item = item;
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = tail.next;
        }
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        Node temp = head;

        public boolean hasNext() {
            return temp != null;
        }

        public Item next() {
            Item item = temp.item;
            temp = temp.next;
            return item;
        }
    }

    public static void main(String[] args) {
        String[] list = {"Today not Tomorrow", "The Weather is abysmal", "Dawn is nigh", "Who keeps the watch?"};
//        LinkedStringQueue queue = new LinkedStringQueue();
        Bag<String> bag = new Bag<>();
        for (String s : list)
            bag.add(s);
        for (String s : bag)
            StdOut.println("The Next Element: " + s);
    }
}
