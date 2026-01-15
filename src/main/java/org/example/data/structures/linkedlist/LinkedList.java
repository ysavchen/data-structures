package org.example.data.structures.linkedlist;

public interface LinkedList<T> {

    T getFirstElement();

    void insertToFront(T data);

    void insertToBack(T data);

    int getNumberOfElements();

}
