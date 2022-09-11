package algorithms.queue;

public class Main {
    public static void main(String[] args) {
        // Initialize a new queue of integers
        Queue<Integer> myQueue = new Queue<>();

        // Check size and capacity
        printSizeAndCap(myQueue);
        printQueue(myQueue);
        printHeadAndTail(myQueue);
        System.out.println();

        // Fill the queue, print it and check it's size and capacity
        for (int i = 1; i <= 8; i++) {
            myQueue.enqueue(i);
        }
        printSizeAndCap(myQueue);
        printQueue(myQueue);
        printHeadAndTail(myQueue);
        System.out.println();

        // Dequeue From the queue
        System.out.println("Removed item: " + myQueue.dequeue());
        printSizeAndCap(myQueue);
        printQueue(myQueue);
        printHeadAndTail(myQueue);
        System.out.println();

        // Remove items until the size of the array is 25% of capacity
        while (myQueue.size() > 2) {
            System.out.println("Removed item: " + myQueue.dequeue());
        }
        printSizeAndCap(myQueue);
        printQueue(myQueue);
        printHeadAndTail(myQueue);
    }

    private static void printSizeAndCap(Queue<?> queue) {
        // Print size
        System.out.println("Size: " + queue.size());
        // Print capacity
        System.out.println("Capacity: " + queue.cap());
    }

    private static void printHeadAndTail(Queue<?> queue) {
        // Print head
        System.out.println("Head: " + queue.getHead());
        // Print tail
        System.out.println("Tail: " + queue.getTail());
    }

    private static void printQueue(Queue<?> queue) {
        System.out.println("Queue: " + queue);
    }
}
