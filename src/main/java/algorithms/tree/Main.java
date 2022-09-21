package algorithms.tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bts = new BinarySearchTree<>();
        bts.insert(5);
        bts.insert(1);
        bts.insert(2);
        bts.insert(8);
        bts.insert(9);
        bts.insert(6);

        System.out.println(bts.search(2));

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
        bts.traverse("in");
    }
}
