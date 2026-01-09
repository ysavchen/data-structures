package org.example.data.structures.stack;

public interface Stack<T> {

    void push(T item);

    T pop();

    T peek();

    int getSize();

    int getNumberOfElements();

}
