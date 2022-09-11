package algorithms.stack;

import java.util.Arrays;

/**
 * <p>Stacks are LIFO (Last in first out) meaning that you examine the
 * item that is most recently added.
 *
 * <p>Push an item to the end of the stack and pop from the end of the stack.
 */
public class Stack<T> {
    private T[] stack;
    private int lastIndex;

    public Stack() {
        @SuppressWarnings("unchecked")
        final T[] s = (T[]) new Object[1];

        this.stack = s;
        this.lastIndex = -1;
    }

    /**
     * Checks if the stack is empty. It only includes the {@code Non-Null} items int the array.
     *
     * @return true if the {@code lastIndex} is equal to -1.
     */
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    /**
     * @return true if all the items in the stack are filled
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
     * Increments the {@code lastIndex} to keep track of the last {@code Non-Null}
     * value's index.
     *
     * <p>If the stack is full, instead of throwing an exception, it resizes
     * the array twice the capacity of the original array by calling {@code resize()}.
     *
     * @param value the value to be appended at the end of the stack.
     */
    public void push(T value) {
        if (isFull()) {
            resize(stack.length * 2);
        }

        lastIndex++;
        stack[lastIndex] = value;
    }

    /**
     * <p>Sets the last {@code Non-Null} item to {@code Null}.
     * Decrements the {@code lastIndex} to keep track of the last {@code Non-Null}
     * value's index.
     *
     * <p>If the {@code stack} is only 25% or less full, then the function calls
     * {@code resize()} method with the half of the current array's length to shrink it
     * by half.
     *
     * <p>If the stack is already empty it throws a StackIsEmptyException.
     *
     * @return the removed item's value.
     * @throws StackIsEmptyException if {@code lastIndex == -1}
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

        if (lastIndex <= (stack.length - 1) / 4) {
            resize(stack.length / 2);
        }

        return toReturn;
    }

    /**
     * <p>When an array needs to be resized (shrink or grow), this method is being called.
     * It creates a new array with the given size and copies all the elements of the
     * original array (only {@code Non-Null} values are copied) to the newly created array.
     *
     * @param newLength is the length specified by the user to be used in the new array.
     */
    private void resize(int newLength) {
        @SuppressWarnings("unchecked")
        T[] resizedStack = (T[]) new Object[newLength];

        for (int i = 0; i < size(); i++) {
            resizedStack[i] = stack[i];
        }

        this.stack = resizedStack;
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
     * @return the sliced array with {@code Non-Null} values.
     */
    @Override
    public String toString() {
        T[] nonNullItems = Arrays.copyOfRange(this.stack, 0, lastIndex + 1);
        return Arrays.toString(nonNullItems);
    }
}
