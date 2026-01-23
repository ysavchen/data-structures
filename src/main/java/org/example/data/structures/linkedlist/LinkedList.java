package org.example.data.structures.linkedlist;

public interface LinkedList<T> {

    T getFirstElement();

    T getLastElement();

    void insertToFront(T data);

    void insertToBack(T data);

    boolean delete(T data);

    int getNumberOfElements();

}
