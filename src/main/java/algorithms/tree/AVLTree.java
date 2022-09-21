package algorithms.tree;

/**
 * <p>AVL (Adelson-Velsky and Landis) trees are self-balancing binary search
 * trees. BSTs are fast but the worst case scenario of operating becomes
 * O(n) instead of O(log n) if the tree is not balanced.
 *
 * <p>AVL trees balance the tree everytime a node is added or removed so that
 * the worst time complexity never exceeds O(log n).
 */
public class AVLTree<T extends Comparable<T>> implements Tree<T> {
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
        } else if (value.compareTo(node.value) > 0) {
            node.rightChild = insert(node.rightChild, value);
        } else {
            // This will return the root of the newly modified tree at the end of call stack.
            return node;
        }

        updateHeight(node);
        return applyRotation(node);
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

        updateHeight(node);
        return applyRotation(node);
    }

    private void updateHeight(Node<T> node) {
        int maxHeight = Math.max(
                height(node.leftChild),
                height(node.rightChild)
        );

        node.height = maxHeight + 1;
    }

    private int height(Node<T> node) {
        return node != null ? node.height : 0;
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);

        if (balance > 1) {
            if (balance(node.leftChild) < 0) {
                node.leftChild = rotateLeft(node.leftChild);
            }

            return rotateRight(node);
        }

        if (balance < -1) {
            if (balance(node.rightChild) > 0) {
                node.rightChild = rotateRight(node.rightChild);
            }

            return rotateLeft(node);
        }

        return node;
    }

    private int balance(Node<T> node) {
        return node != null
                ? height(node.leftChild) - height(node.rightChild)
                : 0;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> leftNode = node.leftChild;
        Node<T> centerNode = leftNode.rightChild;

        leftNode.rightChild = node;
        node.leftChild = centerNode;

        updateHeight(node);
        updateHeight(leftNode);

        return leftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rightChild = node.rightChild;
        Node<T> centerNode = rightChild.leftChild;

        rightChild.leftChild = node;
        node.rightChild = centerNode;

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
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
        return this.root == null;
    }

    private static class Node<T extends Comparable<T>> {
        private T value;
        private int height;
        private Node<T> leftChild;
        private Node<T> rightChild;

        private Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value + "";
        }
    }
}
