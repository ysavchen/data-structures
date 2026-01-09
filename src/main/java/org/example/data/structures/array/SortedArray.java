package org.example.data.structures.array;

public interface SortedArray<T extends Comparable<T>> {

    T getElement(int index);

    int findElement(T element);

    int addElement(T element);

    void deleteElement(T element);

    int getSize();

    int getNumberOfElements();

}
