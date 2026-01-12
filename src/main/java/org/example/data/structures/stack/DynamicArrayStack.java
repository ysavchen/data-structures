package org.example.data.structures.stack;

import org.example.data.structures.array.DynamicArray;
import org.example.data.structures.array.DynamicArrayImpl;

/**
 * Стек на основе динамического массива
 */
public class DynamicArrayStack<T> implements Stack<T> {

    private final DynamicArray<T> stack;

    private int lastElementIndex;

    public DynamicArrayStack() {
        this.stack = new DynamicArrayImpl<>();
    }

    @Override
    public void push(T element) {
        lastElementIndex = stack.addElement(element);
    }

    @Override
    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        T element = stack.getElement(lastElementIndex);
        stack.deleteByIndex(lastElementIndex);
        lastElementIndex--;
        return element;
    }

    @Override
    public T peek() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.getElement(lastElementIndex);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
