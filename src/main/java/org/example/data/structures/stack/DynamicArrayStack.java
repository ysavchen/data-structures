package org.example.data.structures.stack;

import org.example.data.structures.array.DynamicArray;
import org.example.data.structures.array.DynamicArrayImpl;

/**
 * Стек на основе динамического массива
 */
public class DynamicArrayStack<T> implements Stack<T> {

    private final DynamicArray<T> stack;

    public DynamicArrayStack() {
        this.stack = new DynamicArrayImpl<>();
    }

    @Override
    public void push(T element) {
        stack.addElement(element);
    }

    @Override
    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        int lastElementIndex = stack.getSize() - 1;
        T element = stack.getElement(lastElementIndex);
        stack.deleteByIndex(lastElementIndex);
        return element;
    }

    @Override
    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        int lastElementIndex = stack.getSize() - 1;
        return stack.getElement(lastElementIndex);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int getSize() {
        return stack.getSize();
    }
}
