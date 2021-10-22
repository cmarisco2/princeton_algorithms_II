import java.util.Iterator;

/* *****************************************************************************
 *  Name:              Christopher Marisco
 *  Coursera User ID:  uuidV4()
 *  Last modified:     April 8, 2021
 *****************************************************************************/
public class Queue<Item> implements Iterable<Item> {
    private Node head;
    private Node tail;
    private int size = 0;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size(){
        return this.size;
    }

    public void enqueue(Item item) {
        if(item == null) throw new IllegalArgumentException("Cannot enqueue a null item");
        Node temp = new Node();
        temp.item = item;
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = tail.next;
        }
        size++;
    }

    public Item deQueue() {
        if (head == null) throw new IllegalArgumentException("Cannot DeQueue an Empty Queue");
        Item item = head.item;
        if (head.next != null) {
            head = head.next;
            size--;
            return item;
        }
        head = null;
        tail = null;
        size--;
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
}
