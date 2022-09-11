package algorithms.stack;

import java.util.Arrays;

/**
 * <p>Stacks are LIFO (Last in first out) meaning that you examine the
 * item that is most recently added.
 * <p>Push an item to the end of the stack and pop from the end of the stack.
 */
public class Stack<T> {
    private final T[] stack;
    private int lastIndex;

    public Stack(int N) {
        @SuppressWarnings("unchecked")
        final T[] s = (T[]) new Object[N];

        this.stack = s;
        this.lastIndex = -1;
    }

    /**
     * Checks if the stack is empty. It only includes the {@code Non-Null} items int the array.
     * @return true if the {@code lastIndex} is equal to -1.
     */
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    /**
     * @return true if all the items in the stack are not filled
     * and all indexes have values.
     */
    public boolean isFull() {
        return lastIndex == stack.length - 1;
    }

    /**
     * @return the top {@code Non-Null} item in the stack.
     * If the stack is empty (All null) returns {@code null}.
     */
    public T top() {
        return (isEmpty()) ? null : stack[lastIndex];
    }

    /**
     * <p>Appends the given element to the first index that's value is {@code null}.
     * Increments the lastIndex to keep track of the last {@code Non-Null} value's index.
     * If the stack is full then it throws a StackIsFullException.
     * @param value the value to be appended at the end of the stack
     * @throws StackIsFullException
     *         if  {@code lastIndex == stack.length() + 1}
     */
    public void push(T value) {
        if (isFull()) {
            throw new StackIsFullException(
                    "\n" + StackIsFullException.class.getSimpleName() +
                            "\n  Cannot add " + value +
                            " to stack while stack is full"
            );
        }

        lastIndex++;
        stack[lastIndex] = value;
    }

    /**
     * <p>Sets the last {@code Non-Null} item to {@code Null}.
     * Decrements the lastIndex to keep track of the last {@code Non-Null} value's index.
     * If the stack is already empty it throws a StackIsEmptyException.
     * @return the removed item's value.
     * @throws StackIsEmptyException
     *         if {@code lastIndex == -1}
     */
    public T pop() {
        if (isEmpty()) {
            throw new StackIsEmptyException(
                    "\n" + StackIsEmptyException.class.getSimpleName()
                            + "\n  Cannot pop from an empty stack"
            );
        }

        T toReturn = top();

        stack[lastIndex] = null;
        lastIndex--;

        return toReturn;
    }

    /**
     * @return the number of {@code Non-Null} items.
     */
    public int size() {
        return this.lastIndex + 1;
    }

    /**
     * @return the capacity of the stack.
     */
    public int cap() {
        return this.stack.length;
    }

    /**
     * Creates a new array that only has {@code Non-Null} values of the stack.
     *
     * @return the sliced array with {@code Non-Null} values
     */
    @Override
    public String toString() {
        T[] nonNullItems = Arrays.copyOfRange(this.stack, 0, lastIndex + 1);
        return Arrays.toString(nonNullItems);
    }
}
