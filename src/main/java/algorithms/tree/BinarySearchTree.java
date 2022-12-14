package algorithms.tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    @Override
    public void insert(T value) {
        this.root = insert(this.root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        // If the given value is less than node value then go left otherwise, go right.
        if (value.compareTo(node.value) < 0) {
            node.leftChild = insert(node.leftChild, value);
        } else {
            node.rightChild = insert(node.rightChild, value);
        }

        // This will return the root of the newly modified tree at the end of call stack.
        return node;
    }

    @Override
    public void remove(T value) {
        this.root = remove(this.root, value);
    }

    private Node<T> remove(Node<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.leftChild = remove(node.leftChild, value);
        } else if (value.compareTo(node.value) > 0) {
            node.rightChild = remove(node.rightChild, value);
        } else {

            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }

            node.value = getMax(node.leftChild);
            node.leftChild = remove(node.leftChild, node.value);
        }

        return node;
    }

    @Override
    public void traverse(String order) {
        String formatted = order.toLowerCase().replace(" ", "").strip();

        switch (formatted) {
            case "pre", "preorder" -> traversePreOrder(this.root);
            case "post", "postorder" -> traversePostOrder(this.root);
            default -> traverseInOrder(this.root);
        }
    }

    private void traverseInOrder(Node<T> node) {
        if (node != null) {
            traverseInOrder(node.leftChild);
            System.out.println(node);
            traverseInOrder(node.rightChild);
        }
    }

    private void traversePreOrder(Node<T> node) {
        if (node != null) {
            System.out.println(node);
            traversePreOrder(node.leftChild);
            traversePreOrder(node.rightChild);
        }
    }

    private void traversePostOrder(Node<T> node) {
        if (node != null) {
            traversePostOrder(node.leftChild);
            traversePostOrder(node.rightChild);
            System.out.println(node);
        }
    }

    @Override
    public T getMax() {
        if (isEmpty()) {
            return null;
        }

        return getMax(this.root);
    }

    private T getMax(Node<T> node) {
        if (node.rightChild == null) {
            return node.value;
        }

        return getMax(node.rightChild);
    }

    @Override
    public T getMin() {
        if (isEmpty()) {
            return null;
        }

        return getMin(this.root);
    }

    private T getMin(Node<T> node) {
        if (node.leftChild == null) {
            return node.value;
        }

        return getMin(node.leftChild);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }
}