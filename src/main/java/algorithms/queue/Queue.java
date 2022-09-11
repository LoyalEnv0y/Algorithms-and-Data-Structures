package algorithms.queue;

import java.util.Arrays;

/**
 * <p>Queues are FIFO (First in first out) meaning that the least recent item
 * will be processed first.
 *
 * <p>When an item is to be added it is added at the end of the queue (tail)
 * and when an item needs to be taken it is always taken from the beginning
 * of the queue (head).
 */
public class Queue<T> {
    private T[] queue;
    private int tailIndex;
    private int headIndex;

    public Queue() {
        @SuppressWarnings("unchecked")
        T[] q = (T[]) new Object[1];

        this.queue = q;
        this.tailIndex = -1;
        this.headIndex = -1;
    }

    /**
     * <p>Checks if the stack is empty. It checks the stack with tail value.
     *
     * @return true if the {@code tailIndex} is equal to -1.
     */
    public boolean isEmpty() {
        return tailIndex == -1;
    }

    /**
     * <p>Checks if the stack is full.
     *
     * @return true if {@code tailIndex} is one less compared to the
     * length of the stack.
     */
    public boolean isFull() {
        return tailIndex == queue.length - 1;
    }

    /**
     * @return Returns the head of the queue. Ignores {@code Non-Null} items.
     * If the queue is empty then it returns null.
     */
    public T getHead() {
        return (isEmpty()) ? null : queue[headIndex];
    }

    /**
     * <p>Same as {@code getHead}. Only difference is that this method returns
     * the tail of the queue.
     *
     * @return Returns the tail of the queue. Ignores {@code Non-Null} items.
     * If the queue is empty then it returns null.
     */
    public T getTail() {
        return (isEmpty()) ? null : queue[tailIndex];
    }

    /**
     * <p>Appends the given item to the end of the queue. Increments the
     * {@code tailIndex} by one. If this is the first item to be queued, it
     * will assign the {@code headIndex} as 0.
     *
     * <p>If the queue is full then it calls the {@code resize()} method
     * to double the size of the array.
     *
     * @param item is the item to be added to the queue
     */
    public void enqueue(T item) {
        if (isFull()) {
            resize(queue.length * 2);
        }

        tailIndex++;
        queue[tailIndex] = item;

        if (headIndex == -1) {
            headIndex = 0;
        }
    }

    /**
     * <p>Removes the first element in the queue specified by the
     * {@code headIndex}. Increments the headIndex by one to keep track
     * of the new head.
     *
     * <p>If the number of elements in the queue is less than or equal to
     * 25% of the capacity then it calls {@code resize()} to shrink the array
     * by half. When it halves the queue it resets the head and tail indexes.
     *
     * <p>If the user tries to dequeue an item from an empty queue it throws
     * a QueueIsEmptyException.
     *
     * @return the dequeued item.
     * @throws QueueIsEmptyException if called with an empty queue.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new QueueIsEmptyException(
                    "\n" + QueueIsEmptyException.class.getSimpleName() +
                            "\n  Cannot dequeue an empty queue"
            );
        }

        T toReturn = queue[headIndex];

        queue[headIndex] = null;
        headIndex++;

        if (size() <= (cap()) / 4) {
            resize(cap() / 2);

            int oldSize = size();
            this.headIndex = 0;
            this.tailIndex = oldSize - 1;
        }

        return toReturn;
    }

    /**
     * <p>When a queue needs to be resized (shrink or grow), this method
     * is being called. It creates a new array with the given size and
     * copies all the elements of the original queue (only {@code Non-Null}
     * values are copied) to the newly created array. Sets the queue to be
     * the new array.
     *
     * @param newLength is the length specified by the user to be used in
     *                  the new array.
     */
    private void resize(int newLength) {
        @SuppressWarnings("unchecked")
        T[] newQueue = (T[]) new Object[newLength];

        for (int i = 0; i < size(); i++) {
            newQueue[i] = queue[headIndex + i];
        }

        this.queue = newQueue;
    }

    /**
     * @return the number of {@code Non-Null} items. If the queue is empty
     * then return 0.
     */
    public int size() {
        return (isEmpty()) ? 0 : tailIndex - headIndex + 1;
    }

    /**
     * @return the capacity of the queue.
     */
    public int cap() {
        return queue.length;
    }

    /**
     * <p>Creates a new array that only has {@code Non-Null} values of
     * the queue. If the queue is empty then it returns "[]".
     *
     * @return the sliced array with {@code Non-Null} values.
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        T[] nonNullItems = Arrays.copyOfRange(this.queue, headIndex, tailIndex + 1);
        return Arrays.toString(nonNullItems);
    }
}
