package algorithms.stack;

public class Main {
    public static void main(String[] args) {
        // Initialize a new stack of integers with capacity 100
        Stack<Integer> myStack = new Stack<>(100);

        // Fill the stack
        for (int i = 1; i <= 10; i++) {
            myStack.push(i);
        }
        System.out.println("Stack: " + myStack);

        // Pop the last Non-Null item in the stack
        System.out.println("Removed item: " + myStack.pop());
        System.out.println("Stack: " + myStack);

        // Get size = 99
        System.out.println("Size: " + myStack.size());
        // Get capacity = 100
        System.out.println("Capacity: " + myStack.cap());
    }
}


