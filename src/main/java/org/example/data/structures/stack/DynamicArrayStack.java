package org.example.data.structures.stack;

import org.example.data.structures.array.DynamicArray;
import org.example.data.structures.array.DynamicArrayImpl;

/**
 * Стек на основе динамического массива
 */
public class DynamicArrayStack<T> implements Stack<T> {

    private final DynamicArray<T> array;

    public DynamicArrayStack() {
        this.array = new DynamicArrayImpl<>();
    }

    @Override
    public void push(T element) {
        array.addElement(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        int lastElementIndex = array.getSize() - 1;
        T element = array.getElement(lastElementIndex);
        array.deleteByIndex(lastElementIndex);
        return element;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        int lastElementIndex = array.getSize() - 1;
        return array.getElement(lastElementIndex);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }
}
