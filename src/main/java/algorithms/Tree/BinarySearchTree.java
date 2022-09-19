package algorithms.Tree;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> search(T value) {
        return search(root, value);
    }

    public Node<T> search(Node<T> root, T value) {
        if (root == null || root.value == value) {
            return root;
        }

        // If value < root.value then go left.
        if (value.compareTo(root.value) < 0) {
            return search(root.leftChild, value);
        }

        // If value > root.value then go right.
        return search(root.rightChild, value);
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> root, T value) {
        if (root == null) {
            root = new Node<>(value);
            return root;
        }

        // If value < root.value then go left.
        if (value.compareTo(root.value) < 0) {
            root.leftChild = insert(root.leftChild, value);

            // If value > root.value then go right.
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        return root;
    }

/*    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> root, T value) {
        if (value.compareTo(root.value) < 0) {
            root.leftChild = delete(root.leftChild, value);
        } else if (value.compareTo(root.value) > 0) {
            root.rightChild = delete(root.rightChild, value);
        } else {
            if (root.leftChild == null && root.rightChild == null) {
                return null;
            } else if (root.rightChild == null) {
                return root.leftChild;
            } else if (root.leftChild == null) {
                return root.rightChild;
            } else {

            }
        }

    }

    public T findMax() {
        return findMax(root).value;
    }

    private Node<T> findMax(Node<T> root) {
        if (root.rightChild == null) {
            return root;
        } else {
            root.rightChild = findMax(root.rightChild);
        }
    }*/


    private static class Node<T> {
        private T value;
        private Node<T> leftChild;
        private Node<T> rightChild;

        private Node(T value) {
            this.value = value;
        }

        private T getValue() {
            return value;
        }

        private void setValue(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }

}


