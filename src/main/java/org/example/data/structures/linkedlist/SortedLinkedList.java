package org.example.data.structures.linkedlist;

public interface SortedLinkedList<T> {

    T getFirstElement();

    T getLastElement();

    void add(T value);

    T findElement(T element);

    boolean isEmpty();

    int getSize();

}
