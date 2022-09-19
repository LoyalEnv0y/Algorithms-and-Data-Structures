package algorithms.Tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bts = new BinarySearchTree<>();
        bts.insert(5);
        bts.insert(1);
        bts.insert(7);
        bts.insert(2);
        bts.insert(8);
        bts.insert(6);

        System.out.println(bts.search(2));
    }
}
