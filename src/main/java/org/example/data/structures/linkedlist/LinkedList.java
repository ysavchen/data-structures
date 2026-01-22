package org.example.data.structures.linkedlist;

public interface LinkedList<T> {

    T getFirstElement();

    T getLastElement();

    void insertToFront(T data);

    void insertToBack(T data);

    void delete(T data);

    int getNumberOfElements();

}
