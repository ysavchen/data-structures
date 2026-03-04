package org.example.data.structures.linkedlist;

public interface LinkedList<T> {

    T getFirstElement();

    T getLastElement();

    void insertToFront(T value);

    void insertToBack(T value);

    boolean delete(T value);

    int getNumberOfElements();

}
