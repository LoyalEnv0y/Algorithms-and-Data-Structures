package algorithms.tree;

public class Main {
    public static void main(String[] args) {
/*        BinarySearchTree<Integer> bts = new BinarySearchTree<>();
        bts.insert(5);
        bts.insert(1);
        bts.insert(2);
        bts.insert(8);
        bts.insert(9);
        bts.insert(6);

        System.out.println(bts.getMin());
        System.out.println(bts.getMax());
        System.out.println();

        bts.traverse("in");
        System.out.println();
        bts.traverse("pre");
        System.out.println();
        bts.traverse("post");
        System.out.println();

        bts.remove(5);
        bts.traverse("in");*/


        AVLTree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.insert(8);

        avlTree.traverse("in");
        System.out.println();
    }
}
