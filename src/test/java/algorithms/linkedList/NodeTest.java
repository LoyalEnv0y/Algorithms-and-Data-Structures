package algorithms.linkedList;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NodeTest {
    private Node<Integer> node;
    private Random random;

    public NodeTest() {
        this.node = new Node<>();
        this.random = new Random();
    }

    public void start(int i) {
        this.node = new Node<>(i);
    }

    @Test
    public void testNodeValueEmptyAtStart() {
        assertNull(node.getValue());
    }

    @Test
    public void testNodeValueIsCorrectAtStart() {
        start(100);
        assertEquals(100, node.getValue());
    }

    @Test
    public void testSetNext() {
        Node<Integer> newNode = new Node<>(10);
        node.setNext(newNode);
        assertEquals(newNode, node.getNext());
    }

    @Test
    public void testSetPrev() {
        Node<Integer> newNode = new Node<>(40);
        node.setPrev(newNode);
        assertEquals(newNode, node.getPrev());
    }
}
