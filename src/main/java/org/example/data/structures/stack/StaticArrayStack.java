package org.example.data.structures.stack;

import org.example.data.structures.stack.exception.EmptyStackException;
import org.example.data.structures.stack.exception.FullStackException;

/**
 * Стек на основе статического массива
 */
public class StaticArrayStack {

    private final int[] stack;
    private int pushIndex;

    public StaticArrayStack(int size) {
        this.stack = new int[size];
    }

    public void push(int item) {
        if (stack.length == pushIndex) {
            throw new FullStackException();
        }
        stack[pushIndex] = item;
        pushIndex++;
    }

    /**
     * Retrieves and removes an element from the stack
     *
     * @return element
     */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastElementIndex = --pushIndex;
        return stack[lastElementIndex];
    }

    /**
     * Retrieves, but does not remove, an element from the stack
     *
     * @return element
     */
    public int peek() {
        return 0; // todo: fix
    }

    public boolean isEmpty() {
        return pushIndex == 0;
    }
}
