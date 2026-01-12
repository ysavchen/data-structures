package org.example.data.structures.stack;

import org.example.data.structures.stack.exception.FullStackException;

/**
 * Стек на основе статического массива
 */
public class StaticArrayStack<T> implements Stack<T> {

    private final T[] stack;
    private int pushIndex = 0;
    private int numberOfElements = 0;

    public StaticArrayStack(int size) {
        this.stack = (T[]) new Object[size];
    }

    @Override
    public void push(T item) {
        if (stack.length == pushIndex) {
            throw new FullStackException();
        }
        stack[pushIndex] = item;
        pushIndex++;
        numberOfElements++;
    }

    /**
     * Retrieves and removes an element from the stack
     *
     * @return element
     */
    @Override
    public T pop() {
        if (numberOfElements == 0) {
            return null;
        }
        int lastElementIndex = pushIndex - 1;
        T element = stack[lastElementIndex];
        stack[lastElementIndex] = null;
        pushIndex--;
        numberOfElements--;
        return element;
    }

    /**
     * Retrieves, but does not remove, an element from the stack
     *
     * @return element
     */
    @Override
    public T peek() {
        if (numberOfElements == 0) {
            return null;
        }
        int lastElementIndex = pushIndex - 1;
        return stack[lastElementIndex];
    }

    @Override
    public boolean isEmpty() {
        return stack.length == 0;
    }

    public int getSize() {
        return stack.length;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
