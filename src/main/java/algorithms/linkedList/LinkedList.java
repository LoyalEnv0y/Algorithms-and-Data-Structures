package algorithms.linkedList;

import java.util.List;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList() {
        this.head = new Node<>();
        this.tail = new Node<>();
        this.length = 0;
    }

    public LinkedList(T value) {
        this();
        this.head.setValue(value);
        length = 1;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return this.length;
    }

    public void append(T value) {
        Node<T> toAppend = new Node<>(value);

        if (head.getValue() == null) {
            head = toAppend;
            tail = head;

        } else {
            tail.setNext(toAppend);
            toAppend.setPrev(tail);
            tail = toAppend;
        }

        length++;
    }

    public void appendAll(List<T> list) {
        for (T t : list) {
            append(t);
        }
        length += list.size();
    }

    public void appendAll(T[] a) {
        for (T i : a) {
            append(i);
        }
        length += a.length;
    }

    public void appendAll(Node<T> head) {
        Node<T> current = head;
        while (current != null) {
            append(current.getValue());
            current = current.getNext();
        }
    }

    public void appendAll(LinkedList<T> list) {
        appendAll(list.head);
    }

    public void insert(int index, T value) {
        Node<T> toInsert = new Node<>(value);

        if (length == 0) {
            head = toInsert;
            tail = head;

        } else if (index <= 0) {
            toInsert.setNext(head);
            head.setPrev(toInsert);
            head = toInsert;

        } else if (index >= length) {
            tail.setNext(toInsert);
            toInsert.setPrev(tail);
            tail = toInsert;

        } else {
            Node<T> prev = getNodeAt(index - 1);
            prev.getNext().setPrev(toInsert);
            toInsert.setNext(prev.getNext());
            toInsert.setPrev(prev);
            prev.setNext(toInsert);
        }
        length++;
    }

    public void replaceAt(int index, T value) {
        if (getNodeAt(index) == null) {
            throw new IndexOutOfBoundsException("\nError\n  " + index + " is out of 0 - " + (length - 1));
        }
        getNodeAt(index).setValue(value);
    }

    public void deleteAt(int index) {
        if (index <= 0) {
            head.getNext().setPrev(null);
            setHead(head.getNext());

        } else if (index + 1 >= length) {
            setTail(tail.getPrev());
            tail.setNext(null);

        } else {
            Node<T> toDelete = getNodeAt(index);

            toDelete.getPrev().setNext(toDelete.getNext());
            toDelete.getNext().setPrev(toDelete.getPrev());
        }

        length--;
    }

    public LinkedList<T> invertList() {
        LinkedList<T> toInvert = new LinkedList<>();
        toInvert.appendAll(this);

        Node<T> temp = null;
        Node<T> current = toInvert.getHead();

        while (current != null) {
            temp = current.getPrev();
            current.setPrev(current.getNext());
            current.setNext(temp);
            current = current.getPrev();
        }

        if (temp != null) {
            Node<T> anotherTemp = toInvert.head;
            toInvert.setHead(temp.getPrev());
            toInvert.setTail(anotherTemp);
        }

        return toInvert;
    }

    public Node<T> getNodeAt(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("\nError\n  " + index + " is out of 0 - " + (length - 1));
        }

        Node<T> tracker = head;

        for (int i = 0; tracker != null; i++) {
            if (i == index) {
                return tracker;
            }
            tracker = tracker.getNext();
        }

        return null;
    }

    @Override
    public String toString() {
        Node<T> tracker = head;
        StringBuilder sb = new StringBuilder();

        while (tracker != null) {
            sb.append(tracker.getValue()).append(" <-> ");
            tracker = tracker.getNext();
        }
        return sb.toString();
    }

    public String toStringReverse() {
        Node<T> tracker = this.getTail();
        StringBuilder sb = new StringBuilder();

        while (tracker != null) {
            sb.append(tracker.getValue()).append(" <-> ");
            tracker = tracker.getPrev();
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object list) {
        if (this == list) {
            return true;
        }

        if (!(list instanceof LinkedList)) {
            return false;
        }

        @SuppressWarnings("unchecked")
        LinkedList<T> comparedList = (LinkedList<T>) list;

        if (this.length != comparedList.length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!this.getNodeAt(i).equals(comparedList.getNodeAt(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 6;
        hash = 19 * hash + length;
        return hash;
    }
}
