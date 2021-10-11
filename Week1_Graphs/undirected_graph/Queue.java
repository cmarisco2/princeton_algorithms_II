import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     October 11, 2021
 *
 * Create a Queue API for use in Graphs
 *****************************************************************************/
public class Queue<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Item item) {
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

    public Item deQueue() {
        if (head == null) throw new IllegalArgumentException("Cannot DeQueue an Empty Queue");
        Item item = head.item;
        if (head.next != null) {
            head = head.next;
            return item;
        }
        head = null;
        tail = null;
        return item;
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
        Queue<String> queue = new Queue<>();
        for (String s : list)
            queue.enqueue(s);
        for (String s : queue)
            StdOut.println("The Next Element: " + s);
    }
}
