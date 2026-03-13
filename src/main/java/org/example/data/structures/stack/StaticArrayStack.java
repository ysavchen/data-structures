package org.example.data.structures.stack;

import org.example.data.structures.stack.exception.FullStackException;

/**
 * Стек на основе статического массива
 */
public class StaticArrayStack<T> implements Stack<T> {

    private final T[] array;
    private int size;

    public StaticArrayStack(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public void push(T item) {
        if (array.length == size) {
            throw new FullStackException();
        }
        int pushIndex = isEmpty() ? 0 : size;
        array[pushIndex] = item;
        size++;
    }

    /**
     * Retrieves and removes an element from the stack
     *
     * @return element
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        int lastElementIndex = size - 1;
        T element = array[lastElementIndex];
        array[lastElementIndex] = null;
        size--;
        return element;
    }

    /**
     * Retrieves, but does not remove, an element from the stack
     *
     * @return element
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        int lastElementIndex = size - 1;
        return array[lastElementIndex];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
