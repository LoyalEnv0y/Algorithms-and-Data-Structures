package algorithms.tree;

public interface Tree<T extends Comparable<T>> {
    void insert(T value);

    void remove(T value);

    void traverse(String order);

    T getMax();

    T getMin();

    boolean isEmpty();
}
