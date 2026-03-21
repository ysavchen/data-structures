package org.example.data.structures.stack;

import org.example.data.structures.stack.exception.FullStackException;

/**
 * Стек на основе статического массива
 */
public class StaticArrayStack<T> implements Stack<T> {

    private final T[] array;
    private int size = 0;

    public StaticArrayStack(int capacity) {
        this.array = (T[]) new Object[capacity];
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
     * Получение элемента из стека (элемент удаляется)
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
     * Получение элемента из стека (элемент не удаляется)
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
