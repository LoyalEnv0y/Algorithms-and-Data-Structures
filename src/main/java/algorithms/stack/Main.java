package algorithms.stack;

public class Main {
    public static void main(String[] args) {
        // Initialize a new stack of integers
        Stack<Integer> myStack = new Stack<>();

        // check size and capacity
        printSizeAndCap(myStack);
        System.out.println();

        // Fill the stack, print it and check it's size and capacity
        for (int i = 1; i <= 8; i++) {
            myStack.push(i);
        }
        printStack(myStack);
        printSizeAndCap(myStack);
        System.out.println();

        // Pop the last Non-Null item in the stack
        System.out.println("Removed item: " + myStack.pop());
        printStack(myStack);
        printSizeAndCap(myStack);
        System.out.println();

        // Remove items until the size of the array is 25% of capacity
        while (myStack.size() > 2) {
            System.out.println("Removed item: " + myStack.pop());
        }

        printStack(myStack);
        printSizeAndCap(myStack);
        System.out.println();
    }

    private static void printSizeAndCap(Stack<?> stack) {
        // Print size
        System.out.println("Size: " + stack.size());
        // Print capacity
        System.out.println("Capacity: " + stack.cap());
    }

    private static void printStack(Stack<?> stack) {
        System.out.println("Stack: " + stack);
    }
}


