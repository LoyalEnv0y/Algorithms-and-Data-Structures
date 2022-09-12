package algorithms.stack;

import java.util.Arrays;
import java.util.Iterator;

/**
 * <p>Stacks are LIFO (Last in first out) meaning that you process the
 * item that is most recently added.
 *
 * <p>Push an item to the end of the stack and pop from the end of the stack.
 */
public class Stack<T> implements Iterable<T> {
    private T[] stack;
    private int lastIndex;

    public Stack() {
        @SuppressWarnings("unchecked")
        final T[] s = (T[]) new Object[1];

        this.stack = s;
        this.lastIndex = -1;
    }

    /**
     * <p>Checks if the stack is empty. It only includes the {@code Non-Null}
     * items int the array.
     *
     * @return true if the {@code lastIndex} is equal to -1.
     */
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    /**
     * <p>Checks if the Stack is full
     *
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
     * <p>Appends the given element to the first index that's value is
     * {@code null}. Increments the {@code lastIndex} to keep track of
     * the last {@code Non-Null} value's index.
     *
     * <p>If the stack is full, instead of throwing an exception, it
     * doubles the size of the array calling {@code resize()}.
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
     * <p>Sets the last {@code Non-Null} item to {@code Null}. Decrements
     * the {@code lastIndex} to keep track of the last {@code Non-Null}
     * value's index.
     *
     * <p>If the {@code stack} is only 25% or less full, then it calls
     * {@code resize()} method with the half of the current array's length
     * to shrink it by half.
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

        if (lastIndex <= (cap() - 1) / 4) {
            resize(cap() / 2);
        }

        return toReturn;
    }

    /**
     * <p>When a stack needs to be resized (shrink or grow), this method is
     * being called. It creates a new array with the given size and copies
     * all the elements of the original stack (only {@code Non-Null} values
     * are copied) to the newly created array. Sets the stack to be the new
     * array.
     *
     * @param newLength is the length specified by the user to be used in
     *                 the new array.
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

    /**
     * <p>To satisfy the {@code Iterable} interface, {@code iterator}
     * method needs to be implemented. Method is called when client tries
     * to iterate over the stack with a {@code foreach} loop. It then
     * returns a {@code StackIterator} class to be used by the for loop.
     *
     * @return a new instance of {@code StackIterator} class.
     */
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int index = 0;

        /**
         * <p>Checks if the current item in the {@code index} exists.
         * It is being called at the beginning of every iteration in a
         * {@code foreach} loop to check if the loop reached the end.
         *
         * @return true if the stack <i>is NOT</i> empty <i>AND</i>
         * index is less than or equal to the {@code lastIndex}.
         */
        @Override
        public boolean hasNext() {
            return !isEmpty() && index <= lastIndex;
        }

        /**
         * <p>Returns the element at the {@code index} in the stack.
         * Increments the index by one. It is called when the inside
         * of the {@code foreach} loop is finished executing and the
         * loop needs to be advancing.
         *
         * @return the element at the {@code index} in the stack.
         */
        @Override
        public T next() {
            T toReturn = stack[index];
            index++;
            return toReturn;
        }
    }
}
