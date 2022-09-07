package algorithms.linkedList;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
    private final LinkedList<Integer> linkedList;

    public LinkedListTest() {
        this.linkedList = new LinkedList<>();

        for (int i = 1; i <= 100; i++) {
            linkedList.append(i);
        }
    }

    @Test
    public void testAppendToEmptyList() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        emptyList.append(1);
        assertEquals(1, emptyList.getTail().getValue());
    }

    @Test
    public void testAppendWhenMultipleItemsInList() {
        linkedList.append(105);
        assertEquals(105, linkedList.getTail().getValue());
    }

    @Test
    public void testAppendAllWithArrayList() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            testList.add(i);
        }
        emptyList.appendAll(testList);

        assertEquals(testList.get(0), emptyList.getHead().getValue());
        assertEquals(testList.get(testList.size() - 1), emptyList.getTail().getValue());
        assertEquals(testList.get(15), emptyList.getNodeAt(15).getValue());
    }

    @Test
    public void testAppendAllWithArray() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        emptyList.appendAll(array);

        assertEquals(array[0], emptyList.getHead().getValue());
        assertEquals(array[array.length - 1], emptyList.getTail().getValue());
        assertEquals(array[4], emptyList.getNodeAt(4).getValue());
    }

    @Test
    public void testAppendAllWithAnotherHead() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        LinkedList<Integer> testList = new LinkedList<>();
        for (int i = 1; i <= 20; i++) {
            testList.append(i);
        }
        emptyList.appendAll(testList.getHead());

        assertEquals(testList.getHead().getValue(), emptyList.getHead().getValue());
        assertEquals(testList.getTail().getValue(), emptyList.getTail().getValue());
        assertEquals(testList.getNodeAt(15).getValue(), emptyList.getNodeAt(15).getValue());
    }

    @Test
    public void testInsertAtEmptyList() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        emptyList.insert(0, 10);
        assertEquals(10, emptyList.getHead().getValue());
    }

    @Test
    public void testInsertAtListOfMultipleItems() {
        linkedList.append(102);
        linkedList.insert(100, 101);

        assertEquals(101, linkedList.getNodeAt(100).getValue());
    }

    @Test
    public void testInsertAtListWithIndexSmallerThen0() {
        linkedList.insert(-1, 100);

        assertEquals(100, linkedList.getHead().getValue());
    }

    @Test
    public void testInsertAtListWithIndexBiggerThenLength() {
        linkedList.insert(10000, 6);
        assertEquals(6, linkedList.getTail().getValue());
    }

    @Test
    public void testHeadChangesWhenInsertedAtHead() {
        linkedList.insert(0, 10);
        assertEquals(10, linkedList.getHead().getValue());
    }

    @Test
    public void testTailChangesWhenInsertedAtTail() {
        linkedList.insert(100, 101);
        assertEquals(101, linkedList.getTail().getValue());
    }

    @Test
    public void testReplaceAt() {
        linkedList.replaceAt(2, 10);
        assertEquals(10, linkedList.getNodeAt(2).getValue());
    }

    @Test
    public void testHeadChangesWhenReplacedAtHead() {
        linkedList.replaceAt(0, -1);
        assertEquals(-1, linkedList.getHead().getValue());
    }

    @Test
    public void testTailChangesWhenReplacedAtTail() {
        linkedList.replaceAt(99, -1);
        assertEquals(-1, linkedList.getTail().getValue());
    }

    @Test
    public void testReplacingAtOutOfIndexThrowsError() {
        int replaceIndex = 105;
        Exception exception = assertThrows(Exception.class,
                () -> linkedList.replaceAt(replaceIndex, 1000));

        assertEquals("\nError\n  " + replaceIndex + " is out of 0 - " +
                (linkedList.getLength() - 1), exception.getMessage());
    }

    @Test
    public void testDeleteAt() {
        int valueAt = linkedList.getNodeAt(15).getValue();
        linkedList.deleteAt(15);
        assertNotSame(valueAt, linkedList.getNodeAt(15).getValue());
    }

    @Test
    public void testHeadChangesWhenDeletedAtHead() {
        int headValue = linkedList.getHead().getValue();
        linkedList.deleteAt(0);
        assertNotSame(headValue, linkedList.getHead().getValue());
    }

    @Test
    public void testTailChangesWhenDeletedAtTail() {
        int tailValue = linkedList.getTail().getValue();
        linkedList.deleteAt(100);
        assertNotSame(tailValue, linkedList.getTail().getValue());
    }

    @Test
    public void testDeleteAtWhereIndexSmallerThen0() {
        int headValue = linkedList.getHead().getValue();
        linkedList.deleteAt(-1);
        assertNotSame(headValue, linkedList.getHead().getValue());
    }

    @Test
    public void testDeleteAtWhereIndexBiggerThenListLength() {
        int tailValue = linkedList.getTail().getValue();
        linkedList.deleteAt(1000);
        assertNotSame(tailValue, linkedList.getTail().getValue());
    }

    @Test
    public void testInvertEmptyList() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        LinkedList<Integer> invertedEmptyList = emptyList.invertList();

        assertEquals(emptyList.getNodeAt(0).getValue(), invertedEmptyList.getNodeAt(0).getValue());
    }

    @Test
    public void testInvertListWithLengthOne() {
        LinkedList<Integer> emptyList = new LinkedList<>();
        emptyList.append(1);
        LinkedList<Integer> invertedEmptyList = emptyList.invertList();

        assertEquals(emptyList.getNodeAt(0).getValue(), invertedEmptyList.getNodeAt(0).getValue());
    }

    @Test
    public void testInvertList() {
        LinkedList<Integer> invertedList = linkedList.invertList();

        assertEquals(linkedList.getHead().getValue(), invertedList.getTail().getValue());
        assertEquals(linkedList.getTail().getValue(), invertedList.getHead().getValue());
        assertEquals(linkedList.getLength(), invertedList.getLength());
    }

    @Test
    public void testGetNodeAt() {
        int head = linkedList.getHead().getValue();
        int tail = linkedList.getTail().getValue();

        assertEquals(head, linkedList.getNodeAt(0).getValue());
        assertEquals(tail, linkedList.getNodeAt(99).getValue());
    }

    @Test
    public void testGetNodeAtOutOfIndexThrowsError() {
        int nodeIndex = -1;
        Exception exception = assertThrows(Exception.class,
                () -> linkedList.getNodeAt(nodeIndex));

        assertEquals("\nError\n  " + nodeIndex + " is out of 0 - " +
                (linkedList.getLength() - 1), exception.getMessage());
    }
}
