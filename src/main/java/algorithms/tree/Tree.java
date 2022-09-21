package algorithms.tree;


import algorithms.tree.BinarySearchTree.Node;

public interface Tree<T extends Comparable<T>> {
    Node<T> search(T value);
    void insert(T value);
    void remove(T value);
    void traverse(String order);
    T getMax();
    T getMin();
    boolean isEmpty();
}
